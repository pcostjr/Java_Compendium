import java.util.Random;
import java.util.ArrayList;

class Dice {

    // instance variables
    private ArrayList<Die> dice;

    // creates an empty collection for the dice
    public Dice() {
        this.dice = new ArrayList<>();
    }

    // adds a single die of any sides (>0) to the list
    public void addDie(int sides) {
        if(sides > 0)
            dice.add(new Die(sides));
    }

    // adds a number of dice equal to
    // count (>0) dice of any sides (>0)
    // to the list
    public void addDie(int count, int sides) {
        for(int i = 0; i < count; i++)
            addDie(sides);
    }




    // the die object class used by our dice
    public static class Die implements DieInterface {
        private int sides;
        private int value;
        private Random random;

        public Die(int sides) {
            this.sides = sides;
            this.random = new Random();
            this.value = 1; // Initial value
        }

        public int roll() {
            value = random.nextInt(sides) + 1;
            return value;
        }

        public int getValue() {
            return value;
        }

        public int getSides() {
            return sides;
        }
    }
}