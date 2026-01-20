import java.util.ArrayList;

public class Character {
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

    // class features
    private ArrayList<String> feats;

    // Default constructor, make a level 1 character named "Player"
    public Character() {
        this("Player", 1);
        feats = new ArrayList<>();
    }

    // Create a Character with a name and level. Default all ability scores to 10
    public Character(String name, int level) {
        this.name = name;
        this.level = level;

        // Default ability scores
        this.STR = 10;
        this.DEX = 10;
        this.CON = 10;
        this.INT = 10;
        this.WIS = 10;
        this.CHA = 10;

        feats = new ArrayList<>();

        // Default hit points based on level
        calculateBaseHitPoints();
        calculateArmorClass();
    }

    // Calculates ability score based on the ability score entered
    // i.e. getAbilityModifier(this.getSTR())
    // i.e. getAbilityModifier(STR) if we're within the class
    public int getAbilityModifier(int abilityScore) {
        return (int) Math.floor((abilityScore - 10) / 2.0);
    }

    // HP Calculation
    private void calculateBaseHitPoints() {
        // level one basic hp is 10 + CON
        int baseHitPoints = 10 + getAbilityModifier(CON);
        // any subsequent levels is the level * 6 + CON modifier
        // can replace with random if desired.
        this.hitPoints = baseHitPoints + ((level - 1) * (6 + getAbilityModifier(CON)));
    }

    // 10 + DEX default
    private void calculateArmorClass() {
        // Basic armor class calculation using Dexterity
        this.armorClass = 10 + getAbilityModifier(DEX);
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
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
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

    public ArrayList<String> getFeats() {
        return feats;
    }

    public void setFeats(ArrayList<String> feats) {
        this.feats = feats;
    }

    public void addFeat(String feat) {
        this.feats.add(feat);
    }

    // ToString method for character representation, displays character info using
    // formatted strings so we don't have to concat everything
    @Override
    public String toString() {
        return String.format("Character: %s (Level %d)\n" +
                        "HP: %d | AC: %d\n" +
                        "STR: %d | DEX: %d | CON: %d\n" +
                        "INT: %d | WIS: %d | CHA: %d",
                name, level,
                hitPoints, armorClass,
                STR, DEX, CON,
                INT, WIS, CHA);
    }
}
