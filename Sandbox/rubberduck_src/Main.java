/*
rubberduck_src/Main.java
@description: Main method declaration for the example RubberDuck.java
@author: pcostjr
@created: 10.14.2025
@last-update: 10.14.2025
 */
public class Main{
    public static void main(String[] args) {
        // Whenever we invoke a class constructor, we must provide ALL of the variables it calls for.
        RubberDuck matrixDuck = new RubberDuck(false, 1, 2, "rubber", "green");
        RubberDuck sailorDuck = new RubberDuck(true, 2, 2, "rubber", "lemon");
        RubberDuck rollerDuck = new RubberDuck(false, 0, 3, "plastic", "yellow");
        RubberDuck defaultDuck = new RubberDuck();
        System.out.println(defaultDuck);
    }
}
