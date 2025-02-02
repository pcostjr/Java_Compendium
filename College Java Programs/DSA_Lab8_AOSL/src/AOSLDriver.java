import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *Purpose: Data Structurees and Algorithms
 *Status: Completed
 *Last Updated: 11/03/2018
 *Submitted: 11/03/2018
 *Comments: N/A
 *@author Peter Costantino
 *@verion 2018.11.03
 */
public class AOSLDriver
{
	private static BufferedReader br;
	private static AscendinglyOrderedStringList items;
	/**
	 * Runs the program
	 */
	public static void main(String[] args) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in)); //creates the buffered reader
		items = new AscendinglyOrderedStringList(); //creates the array
		boolean run = true; //continues the program loop
		System.out.println("1: Insert Item | 2: Remove Item | 3: Search for Item | " + 
				"4: Clear List | 5: Display List Info | 6: Exit");
		while(run == true)
		{			
			int input = Integer.parseInt(br.readLine().trim()); //parses the input into an int
			switch(input)
			{
			case 1:
				addItem(items);
				break;
			case 2:
				removeItem(items);
				break;
			case 3:
				searchItem(items);
				break;
			case 4:
				items.removeAll();
				System.out.println("List has been cleared.");
				break;
			case 5:
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				System.out.println("Size: " + items.size() + " Contents: " + items.toString());
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				break;
			case 6:
				System.out.println("Program exit.");
				run = false; //stops the program on the next loop
				break;
			default:
				System.out.println("Error. Please use a valid command from the list.");
			}
		}
	}
	
	/**
	 * Facilitates user input for adding an item to the array
	 * @throws IOException
	 */
	private static void addItem(AscendinglyOrderedStringList items) throws IOException
	{
		System.out.println("Please enter the item you would like to add");
		String item = br.readLine().trim();
		String str = "";
		items.add(item);
	}
	
	/**
	 * Facilitates user input for removing an item from the array
	 * @throws IOException
	 */
	private static void removeItem(AscendinglyOrderedStringList items) throws IOException
	{
		System.out.println("Please enter the index of the item you would like to remove");
		int input = 0;
		input = Integer.parseInt(br.readLine().trim());
		if(input < items.size())
			items.remove(input);
		else
			System.out.println("Error: Please use an index that falls within the array size");
	}
	
	/**
	 * Searches for the specified item in the unordered array of items. if successful, will return the position the item is at. Else, will return -1
	 * @param items
	 * @return
	 * @throws IOException
	 */
	private static void searchItem(AscendinglyOrderedStringList items) throws IOException
	{
		System.out.println("Please enter the item you would like to search for");
		DualValue value = items.search(br.readLine().trim());
		System.out.println(value.gtv() == true ? "Item exist in the collection at " + value.getValue() : "Item does not exist in the collection, but should be inserted in index " 
		+ value.getValue() + " to comply with lexicographic order.");
	}
}

