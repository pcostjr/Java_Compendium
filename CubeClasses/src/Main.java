public class Main
{
    public static void main(String[] args)
    {
        Cube myCube = new Cube(5,"red");
        System.out.println(myCube.getSide());
        myCube.setSide(10);
        System.out.println(myCube.getSide());


    }

}