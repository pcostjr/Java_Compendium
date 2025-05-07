public class Character
{
    // Instance variables
    private String name;
    private int health;
    private int level;
    private String powerUp;
    private int experiencePoints;

    // Static variables
    private static int totalCharacters = 0;
    private static int highestLevel = 1;

    // default constructor
    public Character() {
        this.name = "Player" + (totalCharacters + 1);
        this.health = 100;
        this.level = 1;
        this.powerUp = "None";
        this.experiencePoints = 0;
        totalCharacters++;
    }

    // Constructor with name and pUp params
    public Character(String name, String powerUp) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.powerUp = powerUp;
        this.experiencePoints = 0;
        totalCharacters++;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public String getPowerUp() {
        return powerUp;
    }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setPowerUp(String powerUp) {
        this.powerUp = powerUp;
    }

    public void gainExperience() {
        experiencePoints += 10;
        if (experiencePoints >= 100) {
            levelUp();
        }
    }

    public void heal() {
        if (health < 100) {
            health += 10;
            if (health > 100) health = 100;
        }
    }

    private void levelUp() {
        level++;
        experiencePoints = 0;
        health = 100;
        if (level > highestLevel) {
            highestLevel = level;
        }
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public String getCharacterStats() {
        return "Character: " + name +
                "\nHealth: " + health + "/100" +
                "\nLevel: " + level +
                "\nPower-Up: " + powerUp +
                "\nEXP: " + experiencePoints + "/100";
    }

    // Methods that require user input
    public void takeDamage(int damage) {
        if (damage > 0) {
            health -= damage;
            if (health < 0) health = 0;
        }
    }

    public boolean useSpecialMove(String moveName) {
        if (health > 20) {
            health -= 20;
            System.out.println(name + " used " + moveName + "!");
            return true;
        }
        return false;
    }

    // Static methods
    public static int getTotalCharacters() {
        return totalCharacters;
    }

    public static int getHighestLevel() {
        return highestLevel;
    }
}
