// Character.java
// @description: A stripped-down tabletop RPG character class with combat capabilities
// @author: pcostjr
// created: 1.7.2026
// last update: 1.20.2026
import java.util.ArrayList;

// class constructor
public class Character implements CharacterInterface {
    // base ability score stats
    // strength, dexterity, constitution, intelligence, wisdom, charisma
    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

    // character non-stat elements
    // name, level, HP, AC
    private String name;
    private int level;
    private int hitPoints;
    private int armorClass;
    
    // character type determines which ability modifier is used for attacks/AC
    private String characterType; // "melee", "ranged", or "magic"
    
    // Dice object for rolling
    private Dice dice;

    // default constructor. creates a level 1 melee character called Player for testing purposes
    public Character() {
        this("Player", 1, "melee");
    }

    // creates a character with a name, level, and type
    public Character(String name, int level, String characterType) {
        this.name = name;
        this.level = level;
        
        // validate and set character type
        if (characterType.equalsIgnoreCase("melee") || 
            characterType.equalsIgnoreCase("ranged") || 
            characterType.equalsIgnoreCase("magic")) {
            this.characterType = characterType.toLowerCase();
        } else {
            throw new IllegalArgumentException("character type must be 'melee', 'ranged', or 'magic'");
        }

        // default ability scores (will be replaced by rollStats)
        this.STR = 10;
        this.DEX = 10;
        this.CON = 10;
        this.INT = 10;
        this.WIS = 10;
        this.CHA = 10;

        // create the dice roller for this character
        dice = new Dice();

        // calculate hit points and armor class
        calculateBaseHitPoints();
        calculateArmorClass();
    }

    // calculates ability modifier based on the given score
    public int getAbilityModifier(int abilityScore) {
        return (int) Math.floor((abilityScore - 10) / 2.0);
    }
    
    // returns the primary modifier based on the damage type of the class
    private int getPrimaryAbilityModifier() {
        switch (characterType) {
            case "melee":
                return getAbilityModifier(STR);
            case "ranged":
                return getAbilityModifier(DEX);
            case "magic":
                return getAbilityModifier(INT);
            default:
                return 0;
        }
    }

    // calculates the base HP of the character as a sum of 20 + the ability modifier
    private void calculateBaseHitPoints() {
        this.hitPoints = 20 + getAbilityModifier(CON);
    }

    // calculates the AC of the character as 10 + the primary modifier
    private void calculateArmorClass() {
        this.armorClass = 10 + getPrimaryAbilityModifier();
    }

    // rolls the stat values for the character
    @Override
    public void rollStats() {
        STR = rollStat();
        DEX = rollStat();
        CON = rollStat();
        INT = rollStat();
        WIS = rollStat();
        CHA = rollStat();
        
        // recalculate HP and AC with new stats
        calculateBaseHitPoints();
        calculateArmorClass();
    }
    
    // rolls a single stat using the method of rolling 4d6, dropping the lowest
    // and then summing them together.
    private int rollStat() {
        dice.clear(); // clear previous dice
        dice.addDice(4, 6); // add four 6-sided dice
        dice.rollAll(); // roll all dice
        dice.sortDice(); // sort dice by value (lowest to highest)
        dice.removeDie(0); // remove the lowest die (at index 0)
        
        return dice.getAllValues();
    }

    // performs an 'attack' by rolling 1d20 + primary ability mod to simulate an accuracy roll
    @Override
    public int attack() {
        dice.clear();
        dice.addDie(20); // add a 20-sided die
        int roll = dice.rollDie(0); // Roll it
        return roll + getPrimaryAbilityModifier();
    }

    // simulates dealing damage via a six-sided die + primary ability mod
    public int dealDamage() {
        dice.clear();
        dice.addDie(6); // Add a 6-sided die
        int roll = dice.rollDie(0); // Roll it
        return roll + getPrimaryAbilityModifier();
    }

    // determines if an attack can be blocked.
    // an attack is blocked if the attackvalue is at or below the AC
    public boolean defend(int attackValue) {
        return attackValue >= armorClass;
    }

    // assigns damage values if an attack fails
    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints < 0) {
            hitPoints = 0;
        }
    }

    // determines if character still has hit points
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // increases the character's level by 1
    public void levelUp() {
        level++;
        calculateBaseHitPoints();
        calculateArmorClass();
    }

    // ACCESSORS & MUTATORS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
        calculateArmorClass(); // Recalculate AC if melee
        calculateBaseHitPoints();
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
        calculateArmorClass(); // Recalculate AC if ranged
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
        calculateBaseHitPoints(); // Recalculate HP
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
        calculateArmorClass(); // Recalculate AC if magic
    }

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getCHA() {
        return CHA;
    }

    public void setCHA(int CHA) {
        this.CHA = CHA;
    }


    public int getHitPoints() {
        return hitPoints;
    }


    public int getArmorClass() {
        return armorClass;
    }
    
    public String getCharacterType() {
        return characterType;
    }
    
    public void setCharacterType(String characterType) {
        if (characterType.equalsIgnoreCase("melee") || 
            characterType.equalsIgnoreCase("ranged") || 
            characterType.equalsIgnoreCase("magic")) {
            this.characterType = characterType.toLowerCase();
            calculateArmorClass(); // Recalculate AC with new type
        } else {
            throw new IllegalArgumentException("Character type must be 'melee', 'ranged', or 'magic'");
        }
    }

    // toString representation of the Character
    public String toString() {
        return String.format("Character: %s (Level %d %s)\n" +
                        "HP: %d | AC: %d\n" +
                        "STR: %d (%+d) | DEX: %d (%+d) | CON: %d (%+d)\n" +
                        "INT: %d (%+d) | WIS: %d (%+d) | CHA: %d (%+d)",
                name, level, characterType,
                hitPoints, armorClass,
                STR, getAbilityModifier(STR), 
                DEX, getAbilityModifier(DEX), 
                CON, getAbilityModifier(CON),
                INT, getAbilityModifier(INT), 
                WIS, getAbilityModifier(WIS), 
                CHA, getAbilityModifier(CHA));
    }
}