// Project Euler 3: Largest Palindrome Product
// A palindromic number reads the same both ways. The largest palindrome
// made from the product of two 2-digit numbers is 9009 = 91 * 99.
// Find the largest palindrome made from the product of two 3-digit numbers.
public class pe_04 {

    public static void main(String[] args) {


        String str = "", revstr, result = "";
        int check;
        int resultval = 0;
        boolean test;
        for(int i = 100; i <= 999; i++) {
            for(int j = 100; j <= 999; j++) {
                str = Integer.toString(i * j);
                check = i * j;
                revstr = "";
                for(int k = 0; k < str.length(); k++) {
                    revstr = str.charAt(k) + revstr;
                }
                if(revstr.equals(str))
                    if(check > resultval) {
                        result = str;
                        resultval = check;
                    }
            }
        }
        System.out.print(result);

    }
}
