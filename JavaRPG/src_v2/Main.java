// Main.java
// @description: test driver for the Character class
// @author: pcostjr
// created: 1.20.2026

public class Main {
    public static void main(String[] args) {
        // Create three different character types
        Character warrior = new Character("Fortniticus the Brave", 1, "melee");
        Character archer = new Character("Legally distinct Katniss Everdean", 1, "ranged");
        Character wizard = new Character("Snas Undertlae", 1, "magic");

        System.out.println("Rolling Stats");
        warrior.rollStats();
        archer.rollStats();
        wizard.rollStats();

        System.out.println("\nCharacter Sheets");
        System.out.println(warrior);
        System.out.println("\n" + archer);
        System.out.println("\n" + wizard);

        System.out.println("\n\n=== COMBAT: " + warrior.getName() + " vs " + archer.getName() + " ===");
        
        int round = 1;
        while (warrior.isAlive() && archer.isAlive()) {
            System.out.println("\n--- Round " + round + " ---");
            
            // warrior attacks archer
            int warriorAttack = warrior.attack();
            System.out.println(warrior.getName() + " attacks with roll: " + warriorAttack);
            
            if (archer.defend(warriorAttack)) {
                int damage = warrior.dealDamage();
                archer.takeDamage(damage);
                System.out.println("Hit! " + archer.getName() + " takes " + damage + " damage. HP: " + archer.getHitPoints());
            } else {
                System.out.println("Miss! " + archer.getName() + "'s AC (" + archer.getArmorClass() + ") blocks the attack.");
            }
            
            // Check if archer is still alive before counterattack
            if (!archer.isAlive()) {
                System.out.println("\n" + archer.getName() + " has been defeated!");
                break;
            }
            
            // archer attacks warrior
            int archerAttack = archer.attack();
            System.out.println(archer.getName() + " attacks with roll: " + archerAttack);
            
            if (warrior.defend(archerAttack)) {
                int damage = archer.dealDamage();
                warrior.takeDamage(damage);
                System.out.println("Hit! " + warrior.getName() + " takes " + damage + " damage. HP: " + warrior.getHitPoints());
            } else {
                System.out.println("Miss! " + warrior.getName() + "'s AC (" + warrior.getArmorClass() + ") blocks the attack.");
            }
            
            // check if warrior is still alive
            if (!warrior.isAlive()) {
                System.out.println("\n" + warrior.getName() + " has been defeated!");
                break;
            }
            
            round++;
        }
        
        // declare winner
        System.out.println("\n=== COMBAT RESULTS ===");
        if (warrior.isAlive() && !archer.isAlive()) {
            System.out.println(warrior.getName() + " wins with " + warrior.getHitPoints() + " HP remaining!");
        } else if (archer.isAlive() && !warrior.isAlive()) {
            System.out.println(archer.getName() + " wins with " + archer.getHitPoints() + " HP remaining!");
        }
    }
}