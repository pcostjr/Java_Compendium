import java.util.Scanner;

public class NonsenseRadio {

    public static void main(String[] args)
    {
        boolean running = true;
        while(running) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Input your key here:");
            int key = scan.nextInt();

            System.out.println("You have access to the following stations:");
            if((key & 1) == 1)
                System.out.println("-Rock");
            if((key & 2) == 2)
                System.out.println("-Pop");
            if((key & 4) == 4)
                System.out.println("-EDM");
            if((key & 8) == 8)
                System.out.println("-Country");
            if((key & 16) == 16)
                System.out.println("-Classical");
            if((key & 32) == 32)
                System.out.println("-Jazz");
            if((key & 64) == 64)
                System.out.println("-Metal");
            if((key & 64) == 64)
                System.out.println("-News");



        }
    }
}
