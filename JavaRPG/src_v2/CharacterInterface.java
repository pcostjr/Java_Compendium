// CharacterInterface.java
// @description: Interface defining the core functionality for a D&D character
// @author: pcostjr (modified by Claude)
// created: 1.20.2026

public interface CharacterInterface {
    
    /**
     * Rolls stats for the character using 4d6 drop lowest method
     * This will roll 4 six-sided dice and drop the lowest value
     */
    void rollStats();
    
    /**
     * Performs an attack roll
     * Rolls a d20 and adds the character's relevant ability modifier
     * @return The total attack roll value
     */
    int attack();
    
    /**
     * Calculates damage dealt by the character
     * Rolls 1d6 and adds the character's relevant ability modifier
     * @return The total damage value
     */
    int dealDamage();
    
    /**
     * Defends against an incoming attack
     * Compares the attack value to the character's armor class
     * @param attackValue The attack roll from the attacker
     * @return true if the attack hits, false if it misses
     */
    boolean defend(int attackValue);
    
    /**
     * Takes damage and reduces HP
     * @param damage The amount of damage to take
     */
    void takeDamage(int damage);
    
    /**
     * Gets the character's current hit points
     * @return Current HP
     */
    int getHitPoints();
    
    /**
     * Gets the character's armor class
     * @return Current AC
     */
    int getArmorClass();
}