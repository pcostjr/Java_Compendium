public class Main {
    public static void main(String[] args) {
        Dice dice_bag = new Dice();
        dice_bag.addDice(4,6);
        System.out.println(dice_bag.rollAll());
    }
}
