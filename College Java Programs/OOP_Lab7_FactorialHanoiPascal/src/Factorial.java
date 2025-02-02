import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collection;
/*
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated 10/24/2018
 * Submitted: N/A
 * Comments: I figured the better primitive type would be a double, but the best implementation of recursive factorial would be a BigInteger
 * @author Peter Costantino
 * @version 2018.10.24
 */
public class Factorial
{
	private static BufferedReader br;
	/**
	 * The main operating system of the program
	 * @param args
	 * @throws IOException
	 */
	public static void main (String args[]) throws IOException
	{
		boolean running = true;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("0: Exit Program \n 1: Factorial Using int \n 2: Factorial Using double \n 3: Factorial using BigInteger");
		int input;
		while(running)
		{
			input = Integer.parseInt(br.readLine()); 
			switch(input)
			{
				case 0:
					running = false;
					break;
				case 1:
					factorialShell(1);
					break;
				case 2:
					factorialShell(2);
					break;
				case 3:
					factorialShell(3);
					break;
			}
		}
	}
	
	/**
	 * Facilitates working with each factorial program
	 * @param delimeter
	 * @throws IOException
	 */
	public static void factorialShell(int delimeter) throws IOException
	{
		String rtrstr = "Factorial ";
		System.out.println("Please enter the number you'd like to factorialize:");
		if(delimeter == 3)
		{
			BigInteger input = new BigInteger(br.readLine().toString().trim());
			rtrstr = rtrstr + input + "! = " + factorialBI(input);
		}
		else
		{
			int input = Integer.parseInt(br.readLine().trim());
			rtrstr = rtrstr + input + "! = " + (delimeter == 1 ? factorial(input) : factorialdouble(input));
		}
		System.out.println(rtrstr);
	}
	
	/**
	 * Factorializes using an integer n. This breaks at 17! because we reach a value greater than that which can be stored in an integer
	 * @param n
	 * @return
	 */
	public static int factorial(int n)
	{
		//int[] yeet = new int[(int) Math.pow(2, 31)];
		int result = n;
		if(n == 1)
			result = 1;
		else 
			result = (factorial(n - 1) * result);
		System.out.println(result);
		return result;
	}
	
	/**
	 * Factorializes using a double integer n. This doesn't break so early on because double has the greatest maxVal out of every primitive
	 * @param n
	 * @return
	 */
	public static double factorialdouble(int n)
	{
		//int[] yeet = new int[(int) Math.pow(2, 31)];
		double result = n;
		if(n == 1)
			result = 1;
		else result = (result * factorialdouble(n - 1));
		return result;
	}
	
	/**
	 * Factorializes using a BigInteger. This is how we can generate the largest possible factorial available
	 * @param n
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static BigInteger factorialBI(BigInteger n)
	{
		//int[] yeet = new int[(int) Math.pow(2, 31)];
		BigInteger result = BigInteger.ZERO;
		if(n.equals(1))
			result.valueOf(1);
		else result = (result.multiply(factorialBI(n.subtract(BigInteger.ONE))));
		return result;
	}
	
}
