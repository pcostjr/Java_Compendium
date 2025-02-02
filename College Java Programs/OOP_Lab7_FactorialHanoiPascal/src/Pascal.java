import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
/*
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated 10/24/2018
 * Submitted: N/A
 * Comments: N/A
 * @author Peter Costantino
 * @version 2018.10.24
 */
public class Pascal
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
		System.out.println("0: Exit Program \n 1: Recursive Binomial Coefficient \n 2: Pascal's Triangle \n 3: Iterative Binomial Coefficient \n 4: Formulaic Binomial Coefficient");
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
					BiCoShell(1);
					break;
				case 2: 
					TriangleShell();
					break;
				case 3:
					BiCoShell(2);
					break;
				case 4:
					BiCoShell(3);
					break;
			}
		}
	}
	
	public static void TriangleShell() throws IOException
	{
		System.out.println("Please enter n:");
		int n = Integer.parseInt(br.readLine().trim());
		Triangle(n);		
	}
	
	/**
	 * Facilitates the recursive Binomial Coefficient
	 * @throws IOException
	 */
	public static void BiCoShell(int delimeter) throws IOException
	{
		System.out.println("Enter n: ");
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println("Enter k: ");
		int k = Integer.parseInt(br.readLine().trim());
		System.out.println(n + " Choose " + k + " = " + (delimeter == 1 ? recursiveBiCo(n, k) : delimeter == 2 ? iterativeBiCo(n, k) : formulaicBiCo(n,k)));
	}
	
	/**
	 * Recursive method for calculating binomial coefficient (N choose K)
	 * @param n
	 * @param k
	 * @return
	 */
	public static int recursiveBiCo(int n, int k)
	{
		int result = 1; //we set the base case, and we can modify for all other cases.
		if(!(k == 0 || n == k))
			result = recursiveBiCo(n - 1 , k) + recursiveBiCo(n - 1, k - 1);
		return result;
	}
	
	public static void Triangle(int n)
	{
		String str = "1 \n ";
		int[] previous = {1}; //previous array for the 0th and n-1th row of pascal's triangle
		int[] current; //the current row of pascal's triangle
		for(int i = 2; i <= n + 1; i++)
		{
			current = new int[i];
			current[0] = 1;
			current[i - 1] = 1;
			for(int l = 0; l <= i - 3; l++) //we subtract 3 because we've already generated the positions for each end, so we're essentially working with a smaller part of the array
			{
				current[l + 1] = previous[l] + previous[l + 1]; //each new position in the current row is an addition of the previous rows.
			}
			str = str + stringArr(current)+ " \n ";
			previous = current;
		}
		System.out.println(str);
	}
	
	public static int iterativeBiCo(int n, int k)
	{
			int value = 0;
			int[] previous = {1};
			int[] current = null;
			for(int i = 2; i <= n + 1; i++)
			{
				current = new int[i];
				current[0] = 1;
				current[i - 1] = 1;
				for(int l = 0; l <= i - 3; l++)
				{
					current[l + 1] = previous[l] + previous[l + 1];
				}
				previous = current;
			}
		return value = current[k];
	}
	
	/**
	 * Internal method used to convert arrays to strings
	 * @return
	 */
	private static String stringArr(int[] arr)
	{
		String str = "";
		for(int i = 0; i < arr.length; i++)
			str = str + arr[i] + " ";
		return str;
	}
	
	/**
	 * Generates the binomial coefficient using the reduction formula
	 * @param n
	 * @param k
	 * @return
	 */
	private static int formulaicBiCo(int n, int k)
	{
		int value = 1;
		if(n - k > k)
		{
			for(int i = n - k + 1; i <= n; i++)
				value *= i;
			value = value/factorial(k);
		}
		else
		{
			for(int i = k + 1; i <= n; i++)
				value *= i;
			value = value/factorial(n - k);
		}		
		return value;
	}
	
	/**
	 * An iterative factorial
	 * @param n
	 * @return
	 */
	public static int factorial(int n)
	{		
		int sum = n; //sum for factorial
		for(int i = 1; i < n; i++)
		{
			sum *= i++;
		}
		return sum;
	}
}
