import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        // What is printed as a result of executing the code segment?
//        int x = 5;
//        int y = 4;
//        int sum = x + y;
//        double average = (double) (sum / 2);
//        System.out.println(average);
//        double average2 = (double) sum / 2;
//
//        System.out.println(average2);

        double val = -2.5;

        for(double i = -2; i <= 2; i += 0.1)
        {
            int apRound = (int) (i + 0.5);
            long mathRound = Math.round(i);
            System.out.printf("Result from rounding function for i = %f: AP: %d | Math: %d\n", i, apRound, mathRound);
        }

//        {
//            ashfaslkfjalksdjlkf;ajsdlkfjalks;djflk;adsjlkf;ajsdlkf;jaslkdjflkadsjflk;as
//                lkj;asjdflk;ajsdlk;jfalks;djflk;ajdslkfajsdlkjflk;asdjf
//                als;djflkajslk;fjalks;jflk;asjlk;fjaslkd;jfa;s
//
//        }

        // Hypothetical code segment problem
//        int onesDigit = num % 10;
//        int tensDigit = num / 10;

        // variable reassignment & pass-by-value
//        int x = 5;
//        int y = 7;
//        int temp = x;
//        x = y;
//        y = temp;
    }
}