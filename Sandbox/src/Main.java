public class Main {
    public static void main(String[] args) {
        Cube c1 = new Cube("pink","metal", "underwater", 690);
        Cube c2 = new Cube("blue", "foam", "logo", 3);
        Cube c3 = new Cube();


        System.out.println("Cube c1: " + c1.getSide());
        System.out.println("Cube c1 surface area: " + c1.surfaceArea());
        System.out.println("Cube c1 volume: " + c1.volume());

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);



    }
}