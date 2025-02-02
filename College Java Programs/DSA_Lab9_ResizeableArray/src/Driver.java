import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *Purpose: Data Structurees and Algorithms
 *Status: Completed
 *Last Updated: 11/07/2018
 *Submitted: 11/07/2018
 *@author Peter Costantino
 *@verion 2018.11.07
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
		br = new BufferedReader(new InputStreamReader(System.in)); //creates the buffered reader
		items = new ResizeArray(); //creates the array
		boolean run = true; //continues the program loop
		populate(items);
		System.out.println("1: Bubble Sort \n2: Improved Bubble Sort \n3: Selection Sort \n4: Improved Selection Sort \n" + 
				"5: Insertion Sort \n");
		while(run == true)
		{			
			int input = Integer.parseInt(br.readLine().trim()); //parses the input into an int
			switch(input)
			{
			case 1:
				items.bubbleSort();
				System.out.println(display(items));
				run = false;
				break;
			case 2:
				items.improvedBubbleSort();
				System.out.println(display(items));
				run = false; 
				break;
			case 3:
				items.selectionSort();
				System.out.println(display(items));
				run = false; 
				break;
			case 4:
				items.improvedSelectionSort();
				System.out.println(display(items));
				run = false; 
				break;
			case 5:
				items.insertionSort();
				System.out.println(display(items));
				run = false; 
			default:
				System.out.println("Error. Please use a valid command from the list.");
			}
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

