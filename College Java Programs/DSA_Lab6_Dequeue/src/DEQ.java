
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
public class DEQ<T>  extends QueueRA<T> implements ExtendedQueueInterface<T>
{
	/**
	 * Creates a new double-ended queue
	 */
	public DEQ()
	{
		super();
	}
	
	public void enqueueFirst(T newItem) throws ExtendedQueueException
	{
		if(numItems == items.length) //if the array is full, call resize
			items = resize(items); 	
		front = (front + items.length - 1)%items.length; //decrement in circular fashion, this eliminates the need for cases.
		items[front] = newItem; //front + index length minus allows us to get a modulo of items.legths, which ends up being the decremented front
		numItems++;
	}//end of method

	public T dequeueLast() throws ExtendedQueueException 
	{
		if(numItems == items.length) //if the array is full, call resize
			items = resize(items); 	
		T obj = items[back]; //gets the item
		items[back] = null; //wipes the index
		back = (back + items.length - 1)%items.length; //decrement in circular fashion, this eliminates the need for cases.	
		numItems--;
		return obj;		
	}

	/**
	 * Returns the last item in the queue, without removing it from the collection
	 */
	public T peekLast() throws ExtendedQueueException
	{
		T obj = null;
		if(!isEmpty())
		{
			obj = items[back - 1];
		}
		else
			System.out.println("Error: stack is empty.");
		return obj;
	}	
	
	
}
