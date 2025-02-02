import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *Purpose: Data Structurees and Algorithms
 *Status: Completed
 *Last Updated: 10/08/2018
 *Submitted: 10/09/2018
 *@author Peter Costantino
 *@verion 2018.10.08
 */
@SuppressWarnings("unchecked")
public class Driver2
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
		System.out.println("1: Insert Item | 2: Remove Item | 3: Get Item | " + 
				"4: Search List | 5: Clear List | 6: Display List Information | 7: Exit");
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
				getItem(items);
				break;
			case 4:
				searchShell(items);
				break;
			case 5:
				items.removeAll();
				System.out.println("List has been cleared.");
				break;
			case 6:
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				System.out.println("Size: " + items.size() + " Contents: " + items.toString());
				System.out.println("~~~~~~~~~~~~~~~~~~~");
				break;
			case 7:
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
	private static void addItem(ResizeArray items) throws IOException
	{
		System.out.println("Please enter the item you would like to add");
		int item = Integer.parseInt(br.readLine().trim());
		String str = "";
		if(items.size() == 0) //base case, otherwise our else if statement has nothing to compare to
		{
			items.add(0, item);
			str = "Item was added successfully";
		}
		else if(search(items, item) == -1)
		{
			int i = 0;
			while(i < items.size() && item > (int)items.get(i))//this will find the index for us.
			{
				i++;
			}			
			items.add(i, item);
			str = "Item was added successfully";
		}
		else
		{
			str = "Duplicate item. Not added.";
		}
			System.out.println(str); //just because there are three SOP statements in this, and that we have to print *something* so I cut down the IO overhead a little by stuffing it into one string
	}
	
	/**
	 * Facilitates user input for removing an item from the array
	 * @throws IOException
	 */
	private static void removeItem(ResizeArray items) throws IOException
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
	 * Facilitates user input for getting an item from the array
	 * @throws IOException
	 */
	private static void getItem(ResizeArray items) throws IOException
	{
		System.out.println("Please enter the index of the item you would like to get");
		int input = Integer.parseInt(br.readLine().trim());
		if(input < items.size())
			System.out.println((int)items.get(input));
		else
			System.out.println("Please use an index that falls within the array size");
	}
	
	/**
	 * Searches for the specified item in the unordered array of items. if successful, will return the position the item is at. Else, will return -1
	 * @param items
	 * @return
	 * @throws IOException
	 */
	private static void searchShell(ResizeArray items) throws IOException
	{
		System.out.println("Please enter the item you would like to search for");
		int item = Integer.parseInt(br.readLine().trim());
		int result = search(items, item); //the result from searching
		System.out.println("Search command completed with exit code " + result + (result == - 1 ? " Unsuccessful, did not find " + item + " in the collection " :
			" Successful. Found " + item + " at index " + result)); //conditional statement builds our return string with the necessary information		
	}
	
	private static int search(ResizeArray items, int item)
	{
		int i = 0;
		boolean success = false;
		while(success != true && i < items.size()) //while loop allows us DIA but can also have us stop at any time
		{
			if(item == (int)items.get(i)) //if we find a match
				success = true; //then we set success
			i++;
		}
		return (success == true ? i - 1 : -1); //returns -1 if we can't find it, otherwise will return the index		
	}
}

