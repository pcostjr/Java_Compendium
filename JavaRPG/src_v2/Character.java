// Character.java
// @description: A D&D character class with combat capabilities
// @author: pcostjr (modified by Claude)
// created: 1.7.2026
// last update: 1.20.2026

import java.util.ArrayList;

/**
 * Represents a D&D character with stats, combat abilities, and character type.
 * Character types: "melee" (STR-based), "ranged" (DEX-based), "magic" (INT-based)
 */
public class Character implements CharacterInterface {
    // Base ability scores
    // In order: Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma
    private int STR;
    private int DEX;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

    // character basics: name, level, HP, AC
    private String name;
    private int level;
    private int hitPoints;
    private int armorClass;
    
    // character type: determines which ability modifier is used for attacks/AC
    private String characterType; // "melee", "ranged", or "magic"

    // class features
    private ArrayList<String> feats;
    
    // Dice object for rolling
    private Dice dice;

    /**
     * Default constructor - creates a level 1 melee character named "Player"
     */
    public Character() {
        this("Player", 1, "melee");
    }

    /**
     * Creates a Character with a name and level, defaults to melee type
     * @param name The character's name
     * @param level The character's starting level
     */
    public Character(String name, int level) {
        this(name, level, "melee");
    }
    
    /**
     * Full constructor - creates a character with name, level, and type
     * @param name The character's name
     * @param level The character's starting level
     * @param characterType The type: "melee", "ranged", or "magic"
     */
    public Character(String name, int level, String characterType) {
        this.name = name;
        this.level = level;
        
        // Validate and set character type
        if (characterType.equalsIgnoreCase("melee") || 
            characterType.equalsIgnoreCase("ranged") || 
            characterType.equalsIgnoreCase("magic")) {
            this.characterType = characterType.toLowerCase();
        } else {
            throw new IllegalArgumentException("Character type must be 'melee', 'ranged', or 'magic'");
        }

        // Default ability scores (will be replaced by rollStats)
        this.STR = 10;
        this.DEX = 10;
        this.CON = 10;
        this.INT = 10;
        this.WIS = 10;
        this.CHA = 10;

        feats = new ArrayList<>();
        dice = new Dice();

        // Calculate hit points and armor class
        calculateBaseHitPoints();
        calculateArmorClass();
    }

    /**
     * Calculates ability modifier based on the ability score
     * Formula: (ability score - 10) / 2, rounded down
     * @param abilityScore The ability score to calculate modifier for
     * @return The ability modifier
     */
    public int getAbilityModifier(int abilityScore) {
        return (int) Math.floor((abilityScore - 10) / 2.0);
    }
    
    /**
     * Gets the relevant ability modifier based on character type
     * Melee = STR, Ranged = DEX, Magic = INT
     * @return The primary ability modifier for this character
     */
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

    /**
     * Calculates base hit points
     * HP = 20 + CON modifier
     */
    private void calculateBaseHitPoints() {
        this.hitPoints = 20 + getAbilityModifier(CON);
    }

    /**
     * Calculates armor class based on character type
     * AC = 10 + primary ability modifier
     * Melee = 10 + STR mod, Ranged = 10 + DEX mod, Magic = 10 + INT mod
     */
    private void calculateArmorClass() {
        this.armorClass = 10 + getPrimaryAbilityModifier();
    }

    /**
     * Rolls stats for the character using 4d6 drop lowest method
     * Rolls 4 six-sided dice, drops the lowest, sums the remaining 3
     * Applies this method to all 6 ability scores
     */
    @Override
    public void rollStats() {
        STR = rollSingleStat();
        DEX = rollSingleStat();
        CON = rollSingleStat();
        INT = rollSingleStat();
        WIS = rollSingleStat();
        CHA = rollSingleStat();
        
        // Recalculate HP and AC with new stats
        calculateBaseHitPoints();
        calculateArmorClass();
    }
    
    /**
     * Helper method to roll a single stat using 4d6 drop lowest
     * @return The stat value (sum of highest 3 dice)
     */
    private int rollSingleStat() {
        dice.clear(); // Clear previous dice
        dice.addDice(4, 6); // Add four 6-sided dice
        dice.rollAll(); // Roll all dice
        dice.sortDice(); // Sort dice by value (lowest to highest)
        dice.removeDie(0); // Remove the lowest die (at index 0)
        
        // Sum the remaining 3 dice
        int sum = 0;
        for (int i = 0; i < dice.size(); i++) {
            sum += dice.getDieValue(i);
        }
        
        return sum;
    }

    /**
     * Performs an attack roll
     * Rolls 1d20 + primary ability modifier
     * @return The total attack roll value
     */
    @Override
    public int attack() {
        dice.clear();
        dice.addDie(20); // Add a 20-sided die
        int roll = dice.rollDie(0); // Roll it
        return roll + getPrimaryAbilityModifier();
    }

    /**
     * Calculates damage dealt by the character
     * Rolls 1d6 + primary ability modifier
     * @return The total damage value
     */
    @Override
    public int dealDamage() {
        dice.clear();
        dice.addDie(6); // Add a 6-sided die
        int roll = dice.rollDie(0); // Roll it
        return roll + getPrimaryAbilityModifier();
    }

    /**
     * Defends against an incoming attack
     * Compares the attack value to the character's armor class
     * @param attackValue The attack roll from the attacker
     * @return true if the attack hits (attackValue >= AC), false if it misses
     */
    @Override
    public boolean defend(int attackValue) {
        return attackValue >= armorClass;
    }

    /**
     * Takes damage and reduces HP
     * HP cannot go below 0
     * @param damage The amount of damage to take
     */
    @Override
    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints < 0) {
            hitPoints = 0;
        }
    }

    /**
     * Checks if the character is still alive
     * @return true if HP > 0, false otherwise
     */
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Leveling Up Method
    public void levelUp() {
        level++;
        calculateBaseHitPoints();
        calculateArmorClass();
    }

    // Getter and Setter Methods
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

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
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

    public ArrayList<String> getFeats() {
        return feats;
    }

    public void setFeats(ArrayList<String> feats) {
        this.feats = feats;
    }

    public void addFeat(String feat) {
        this.feats.add(feat);
    }

    /**
     * ToString method for character representation
     * Displays character info using formatted strings
     */
    @Override
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