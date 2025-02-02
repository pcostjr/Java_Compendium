public class Main {

    public static void foobar(int value) {
        if((value % 2 == 0) && (value % 3 == 0)) {
            System.out.println(value + " - Baz");
        }
        else if(value % 2 == 0) {
            System.out.println(value + " - Foo");
        }
        else if(value % 3 == 0) {
            System.out.println(value + " - Bar");
        }
        else {
            System.out.println(value);
        }

        if((value % 6 == 0) && (value % 12 != 0)) {
            System.out.println(value + " - Qux");
        }
        else if(value % 6 == 0) {
            System.out.println(value + " - Quux");
        }

        if(value % 2 == 0 && perfect_square(value))
        {
            System.out.println(value + " - Woohp!");
        }
    }

    /* Math.sqrt can be valid, but using this method we can
    * determine if value is a perfect square by checking its
    *  integer factors. */
    public static boolean perfect_square(int value)
    {
        for (int i = 1; i * i <= value; i++) {

            // If (i * i = n)
            if ((value % i == 0) && (value / i == i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        for(int i = 0; i < 1000; i++) {
            foobar(i + 1);
        }


    }
}