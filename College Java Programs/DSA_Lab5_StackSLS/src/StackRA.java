public class StackRA<T> implements StackInterface<T>
{
	private T [] items;
	int numItems;
	@SuppressWarnings("unchecked")
	public StackRA()
	{
		items = (T[]) new Object[5];
		numItems = 0;
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
	
	/**
	 * Wipes the array
	 */
	@SuppressWarnings("unchecked")
	public void popAll() 
	{
		// Creates a new array; marks old array for
	     // garbage collection.
	     items = (T[]) new Object[3];
	     numItems = 0;
	}

	/**
	 * Pushes an object onto the stack
	 * Because we know we're only pushing onto index 0, we can use constants in the loop
	 */
	public void push(T newItem) throws StackException 
	{
		if(numItems == items.length)
			resize(items); //resizes if the array is full
		for (int pos = numItems-1; pos >= 0; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
        {
            items[pos+1] = items[pos];
        } // end for
        // insert new item
        items[0] = (T) newItem;
        numItems++;		
	}
	
	/**
	 * Method for resizing the array if it ever becomes full and more items need to be added
	 * Modified to pass the collection in and resize
	 */
	private T[] resize(T [] items)
	{
		T [] temp = (T[])new Object[numItems + (numItems/2 + 1)]; //extends the array by about half the existing spaces plus one
		for(int i = 0; i < numItems; i++)
		{
			temp[i] = items[i]; //copies everything in the cells in i to their respective cells in temp
		}
		return temp; //changes the reference in items to the new resized array
	}


	/*
	 * Retrieves the item at the top of the stack, and removes it from the collection
	 * Because we know we're popping directly from the top, we can use constants
	 */
	public T pop() throws StackException 
	{
		T obj = null;
		if(!isEmpty())
		{
			obj = items[0];
			items[0] = null;
			for (int pos = 1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
			{
				items[pos-1] = items[pos];
			}  // end for
		}
		else
			System.out.println("Error: stack is empty.");	
		return obj;
	}

	/*
	 * Retrieves the item at the top of the stack, but leaves it in the collection
	 */
	public T peek() throws StackException 
	{
		T obj = null;
		if(!isEmpty())//we basically do what add does, except in this instance we don't have to go through the process of removing the item from the array
		{
			obj = items[0];
		}
		else
			System.out.println("Error: stack is empty.");
		return obj;
	}
	
	/**
	 * Returns the string contents of the entire stack
	 */
	public String toString()
	{
		String str = "";
		for(int i = 0; i < numItems; i++)
		{
			str = str + items[i].toString() + " , ";
		}
		return str;
	}
}
