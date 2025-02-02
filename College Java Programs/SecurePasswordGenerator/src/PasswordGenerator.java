import java.security.SecureRandom;
//this is a more "cryptographically-secure" password generator.
//ask me what that means, I couldn't tell you.
import java.util.Scanner;
//generic input stream for non-gui input
public class PasswordGenerator
{

    final static String validchars = "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "1234567890" +
            "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
    //this is an immutable array of every possible value we could write into our password
    //some password fields are fidgety and require we omit certain characters in order to
    //avoid an accidental SQL injection. But we can flag those out if need be.
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        //generic input method
        System.out.println("How many characters would you like your password? (1 - 99)?");
        int entry = input.nextInt();
        if(entry > 0 && entry < 100)
            System.out.print(generatePass(entry));
        //so long as we are in the boundaries of desired length, generate a password.
    }


    private static String generatePass(int length)
    {
        SecureRandom secGen = new SecureRandom();
        //this is our golden goose, a secure random number generator
        String result = "";
        //create a generator and a result string
        int bound = validchars.length();
        for(int i = 0; i < length; i++)
        {
            result = result + validchars.charAt(secGen.nextInt(bound));
        }
        return result;
    }
}
