import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 10/10/2018
 * Submitted: N/A
 * Comments: none
 * @author Peter Costantino
 * @version 2018.10.10
 */
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
		QueueRA items = new QueueRA(); //the collection that we'll be manipulating
		boolean running = true;
		System.out.println("1: Enqueue \n 2: Dequeue \n 3: Peek \n 4: Clear \n 5: Display \n 6: Exit");
		int input;
		while(running)
		{
			input = Integer.parseInt(br.readLine()); 
			switch(input)
			{
				case 1:
					enqueue(items);
					break;
				case 2:
					dequeue(items);
					break;
				case 3:
					peek(items);
					break;
				case 4:
					dequeueAll(items); 
					break;
				case 5:
					display(items);
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
	private static void enqueue(QueueRA items) throws IOException
	{
		System.out.println("Please enter the item you'd like to insert.");
		String str = br.readLine(); //takes the item
		items.enqueue(str); //enqueues the item
		System.out.println("Item has been enqueued"); 	
	}
	
	
	/**
	 * Facilitates popping a single item off of the stack
	 * @throws IOException
	 */
	private static void dequeue(QueueRA items) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{
			System.out.println("Item " + items.dequeue().toString() + " has been popped off the stack"); //we just print out the item so we can see what we popped
		} //otherwise it would just pop into the aether and be garbage collected
		else
			System.out.println("Error: Queue is Empty");
	}
	
	/**
	 * Facilitates getting an item from the collection
	 * @throws IOException
	 */
	private static void peek(QueueRA items) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{			
			System.out.println("The object is: " + items.peek());
		}
		else //case if empty
			System.out.println("Error: Queue is Empty");
	}
	
	/**
	 * Displays the collection, or lack thereof
	 */
	private static void display(QueueRA items)
	{
		if(!items.isEmpty())
		{			
			System.out.println("List size = " + items.size() + "\n" + "Contents = " + items.toString());
		}
		else
			System.out.println("Error: Queue is Empty");
	}	
	
	/**
	 * Displays the collection, or lack thereof
	 */
	private static void dequeueAll(QueueRA items)
	{
		if(!items.isEmpty())
		{			
			System.out.println("Successfully Dequeued All");
			items.dequeueAll();
		}
		else
			System.out.println("Error: Queue is Empty");
	}	
}
