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
		ListReferenceBased items = new ListReferenceBased(); //the LRB that we'll be manipulating
		boolean running = true;
		System.out.println("1: Insert \n 2: Remove \n 3: Get \n 4: Clear \n 5: Display \n 6: Reverse \n 7: Exit");
		int input;
		while(running)
		{
			input = Integer.parseInt(br.readLine()); 
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
					items.removeAll(); //we don't really need a method for this, because if the colletion is already empty, this will make it empty again
					break;
				case 5:
					displayItems(items); //moved to a method because extra lines of code would be messy here
					break;
				case 6:
					reverseList(items);
					break;
				case 7:
					running = false;
					break;
			}
		}
	}
	
	/**
	 * Facilitates adding an item to the collection
	 * @throws IOException
	 */
	private static void addItem(ListReferenceBased items) throws IOException
	{
		System.out.println("Please enter the item you'd like to insert.");
		String str = br.readLine(); //takes the item
		System.out.println("Please enter the index you'd like to insert this item at.");
		int check = Integer.parseInt(br.readLine());
		if(check <= items.size())		
		{
			items.add(check, str); //calls the add as soon as we get the index from the user
		System.out.println("Item has been added"); 	
		}
	}
	
	
	/**
	 * Facilitates removing an item from the collection
	 * @throws IOException
	 */
	private static void removeItem(ListReferenceBased items) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{
			System.out.println("Please enter the index of the item you'd like to remove.");
			items.remove(Integer.parseInt(br.readLine()));
			System.out.println("Item has been successfully removed");
		}
		else //case if empty
			System.out.println("List is empty.");
	}
	
	/**
	 * Facilitates getting an item from the collection
	 * @throws IOException
	 */
	private static void getItem(ListReferenceBased items) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{
			System.out.println("Please enter the index of the item you'd like to remove.");
			System.out.println("The object is: " + items.get(Integer.parseInt(br.readLine())));
		}
		else //case if empty
			System.out.println("List is empty");
	}
	
	/**
	 * Displays the collection, or lack thereof
	 */
	private static void displayItems(ListReferenceBased items)
	{
		if(!items.isEmpty())
		{
			System.out.println("List size = " + items.size() + "\n" + "Contents = " + items.toString());
		}
		else
			System.out.println("List is empty.");
	}
	
	
	/**
	 * Reverses the list
	 */
	private static void reverseList(ListReferenceBased items)
	{
		if(!items.isEmpty())
		{
			ListReferenceBased temp = new ListReferenceBased();
			int size = items.size(); //prevent reevaluation
			for(int i = 0; i < size; i++)
			{
				temp.add(i, items.get(size - 1 - i));
			}
			items = temp;
			System.out.println("Reversed.");
		}
		else
			System.out.println("List is Empty");
	}
	
}
