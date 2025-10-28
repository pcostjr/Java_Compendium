
import java.util.Scanner;

public class CatFinder
{
    public static void main(String[] args) {
        String strTarget = "cat";
        int intTargetLength = strTarget.length();
        boolean bolRunning = true;
        int intIndex = 0;
        int intCount = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("> Enter a word or phrase to process: ");
        String strPhrase = scan.nextLine().trim().toLowerCase();

        while(bolRunning) {
            String strCheck = strPhrase.substring(intIndex, intIndex + intTargetLength);
            if(strCheck.equals(strTarget)){
                intCount++;
            }
            intIndex ++;
            if(intIndex >= strPhrase.length() || intIndex + intTargetLength -1 >= strPhrase.length()) {
                bolRunning = false;
            }
        }

        System.out.printf("The string %s occurs %d times.", strTarget, intCount);

    }
}
