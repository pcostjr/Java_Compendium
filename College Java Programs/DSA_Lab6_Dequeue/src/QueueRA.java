/*
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 10/13/2018
 * Submitted: 10/13/2018
 * Comments: I think I know understand how queues work, and now I can utilize it efficiently
 * @author Peter Costantino
 * @version 2018.10.13
 */
@SuppressWarnings("unchecked") //suppresses generic type warnings
public class QueueRA<T> implements QueueInterface<T>
{
	protected T [] items; //the array for our queue
	protected int numItems; //the number of items in the queue
	protected int front; //variable for the front of the queue
	protected int back; //variable for the back of the queue
	//since this is a circularly linked queue, front and back can be anywhere in the array, not necessarily front before the back.
	/**
	 * Creates a new queue using resizable array
	 */
	public QueueRA()
	{
		items = (T[]) new Object[5];
		numItems = 0;
		front = 0;
		back = 0;
	}
	
	/**
	 * Determines if there's anything in the array
	 */
	public boolean isEmpty() 
	{
		return numItems == 0;
	}
	
	/**
	 * Returns the size of the array
	 * @return
	 */
	public int size()
	{
		return numItems;
	}	

	public void enqueue(T newItem) throws ExtendedQueueException
	{
		if(numItems == items.length) //if the array is full, call resize
			items = resize(items); 	
		items[back] = newItem; //front + index length minus allows us to get a modulo of items.legths, which ends up being the decremented front
		back = (back + 1)%items.length; //increment in circular fashion
		numItems++;
	}//end of method
	
	
	/**
	 * Dequeues everything from the array without returning anything.
	 */
	public void dequeueAll()
	{
		front = 0; //resets the front
		back = 0; //resets the back
		items = (T[]) new Object[5]; //references a new array, the old is garbage collected		
	}//end of method
	 
	/**
	 * Passes the collection reference in and resizes it
	 * If array is "out of order", lines everything up correctly
	 */
	protected T[] resize(T [] items)
	{
		int index = front; //starts at the front of the array
		T [] temp = (T[])new Object[numItems + (numItems/2 + 1)]; //new, extended array we will be putting things into
		for(int i = 0; i < numItems; i++)
		{
			if(index  == items.length) //if the index is at the end of the array while looping
				index = 0;//switch to the front and continue
			temp[i] = items[index++];
		}
		front = 0; //sets the front
		back = numItems; //sets the back
		return temp; //changes the reference in items to the new resized array
	}//end of method

	/*
	 * Retrieves the item at the front of the queue
	 */
	public T dequeue() throws QueueException 
	{
		T obj = items[front]; //gets the front of the queue
		if(!isEmpty())
		{
			items[front++] = null; //nullifies the front
			front = front%items.length; //increments the front in circular fashion
		}
		else
			System.out.println("Error: queue is empty."); 
		numItems--;
		return obj;
	} //end of method

	/*
	 * Retrieves the item at the top of the queue, but leaves it in the collection
	 */
	public T peek() throws QueueException 
	{
		T obj = null;
		if(!isEmpty())
		{
			obj = items[front];
		}
		else
			System.out.println("Error: stack is empty.");
		return obj;
	}	
	
	/**
	 * Returns the contents of the entire queue
	 */
	public String toString()
	{
		int index = front; //start at the front
		String str = "";
		for(int i = 0; i < numItems; i++)
		{			
			str = str + items[index++].toString() + " , ";	
			if(index == items.length) //if we're at the end of the array, but not done adding
				index = 0; //switch to the back
		}
		return str;
	}//end of method	
}
