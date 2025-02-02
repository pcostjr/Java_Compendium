import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 10/10/2018
 * Submitted: N/A
 * Comments: N/A
 * @author Peter Costantino
 * @version 2018.10.10
 */
@SuppressWarnings("unchecked")
public class DEQDriver 
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
		DEQ items = new DEQ(); //the collection we'll be manipulating
		boolean running = true;
		System.out.println("1: Insert Back \n 2: Insert Front \n 3: Remove Front \n 4: Remove Back \n 5: Display Front \n 6: Display Back \n 7: Clear DEQ \n 8: Display Content \n 9: Exit");
		int input;
		while(running)
		{
			input = Integer.parseInt(br.readLine()); 
			switch(input)
			{
				case 1:
					enqueue(items, true); //true makes us do the regular enqueue
					break;
				case 2:
					enqueue(items, false); //false makes us do the enqueueFront
					break;
				case 3:
					dequeue(items, true);
					break;
				case 4:
					dequeue(items, false); 
					break;
				case 5:
					peek(items, true);
					break;
				case 6:
					peek(items, false);
					break;
				case 7:
					items.dequeueAll();
					System.out.println("DEQ has been cleared.");
				case 8: 
					display(items);
					break;
				case 9:
					running = false;
					break;
			}
		}
	}
	
	/**
	 * Facilitates pushing an item onto the stack
	 * @throws IOException
	 */
	private static void enqueue(DEQ items, boolean delimeter) throws IOException
	{
		System.out.println("Please enter the item you'd like to insert.");
		String str = br.readLine(); //takes the item
		if(delimeter)
			items.enqueue(str); //enqueues the item
		else
			items.enqueueFirst(str);
		System.out.println("Item has been enqueued"); 	
	}
	
	
	/**
	 * Facilitates popping a single item off of the stack
	 * @throws IOException
	 */
	private static void dequeue(DEQ items, boolean delimeter) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{
			if(delimeter)
				System.out.println("Item " + items.dequeue().toString() + " has been popped out of the queue"); //we just print out the item so we can see what we popped
			else
				System.out.println("Item " + items.dequeueLast() + " has been popped out of the queue");
		} //otherwise it would just pop into the aether and be garbage collected
		else
			System.out.println("Error: Queue is Empty");
	}
	
	/**
	 * Facilitates getting an item from the collection
	 * @throws IOException
	 */
	private static void peek(DEQ items, boolean delimeter) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{			
			if(delimeter)
				System.out.println("Peek from Front is " + items.peek());
			else
				System.out.println("Peek from Back is " + items.peekLast());
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
