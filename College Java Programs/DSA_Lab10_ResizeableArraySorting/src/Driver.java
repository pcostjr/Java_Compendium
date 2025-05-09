import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *Purpose: Data Structurees and Algorithms
 *Status: Completed
 *Last Updated: 11/14/2018
 *Submitted: 11/20/2018
 *@author Peter Costantino
 *@verion 2018.11.20
 */
@SuppressWarnings("unchecked")
public class Driver
{
	private static BufferedReader br;
	private static ResizeArray items;
	/**
	 * Runs the program
	 */
	public static void main(String[] args) throws IOException
	{
		boolean yeet = true;
		while(yeet)
		{
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxx");
		}
	}
	
	/**
	 * Populates the list with a series of inputs specified by the user.
	 * @throws IOException
	 */
	private static void populate(ResizeArray items) throws IOException
	{
		System.out.println("Please enter the number of integers to add to the list.");
		int amt = Integer.parseInt(br.readLine().trim()); //the amount of integers to specify
		for(int i = 0; i < amt; i++)
		{
			System.out.println("Input #" + (i + 1) + " = ");
			items.add(Integer.parseInt(br.readLine().trim())); //adds the input to the end of the array
		}
		System.out.println(display(items));
	}
	
	public static String display(ResizeArray items)
	{
		return "~~~~~~~~~~~~~~~~~~~ \nSize: " + items.size() + " | Contents: " + items.toString() + "\n~~~~~~~~~~~~~~~~~~~";
	}
	
	
}

