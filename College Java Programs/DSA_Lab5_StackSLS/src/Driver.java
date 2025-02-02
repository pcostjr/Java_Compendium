import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Driver 
{
	private static BufferedReader br;
	/**
	 * The main operating system of the program
	 * @param args
	 * @throws IOException
	 */
	public static void main (String args[]) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		StackSLS items = new StackSLS(); //the LRB that we'll be manipulating
		boolean running = true;
		System.out.println("1: Push Item \n 2: Pop Item \n 3: Peek Item \n 4: Display All \n 5: Clear Stack \n 6: Exit");
		int input;
		while(running)
		{
			input = Integer.parseInt(br.readLine()); 
			switch(input)
			{
				case 1:
					pushItem(items);
					break;
				case 2:
					popItem(items);
					break;
				case 3:
					peekItem(items);
					break;
				case 4:
					displayItems(items); 
					break;
				case 5:
					items.popAll(); //wipes the array
					break;
				case 6:
					running = false;
					break;
			}
		}
	}
	
	/**
	 * Facilitates pushing an item onto the stack
	 * @throws IOException
	 */
	private static void pushItem(StackSLS items) throws IOException
	{
		System.out.println("Please enter the item you'd like to insert.");
		String str = br.readLine(); //takes the item
		items.push(str); //pushed directly into the stack
		System.out.println("Item has been pushed"); 	
	}
	
	
	/**
	 * Facilitates popping a single item off of the stack
	 * @throws IOException
	 */
	private static void popItem(StackSLS items) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{
			System.out.println("Item " + items.pop().toString() + " has been popped off the stack"); //we just print out the item so we can see what we popped
		} //otherwise it would just pop into the aether and be garbage collected
		else
			System.out.println("List is empty.");
	}
	
	/**
	 * Facilitates getting an item from the collection
	 * @throws IOException
	 */
	private static void peekItem(StackSLS items) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{			
			System.out.println("The object is: " + items.peek());
		}
		else //case if empty
			System.out.println("List is empty");
	}
	
	/**
	 * Displays the collection, or lack thereof
	 */
	private static void displayItems(StackSLS items)
	{
		if(!items.isEmpty())
		{			
			System.out.println("List size = " + items.size() + "\n" + "Contents = " + items.toString());
		}
		else
			System.out.println("List is empty.");
	}	
}
