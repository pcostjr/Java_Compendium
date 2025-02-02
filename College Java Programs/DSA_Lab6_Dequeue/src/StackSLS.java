
public class StackSLS<T> implements StackInterface<T> 
{
	private Node head;
	private int numItems; //we just use this to keep track of size
	
	public StackSLS()
	{
		head = null;
		numItems = 0;
	}
	
	/**
	 * Determines if the collection is empty
	 */
	public boolean isEmpty() 
	{
		return head == null; //if the head is null, then the list is empty
	}
	
	/**
	 * Returns the size of the stack
	 * @return
	 */
	public int size()
	{
		return numItems;
	}

	/**
	 * Wipes the stack
	 */
	public void popAll() 
	{
		head = null;		
	}
	
	/**
	 * Pushes an item onto the stack. We don't need a case for when the stack is empty, because using the SLS means we can just reference whatever is in head
	 * even if it is null, this is still valid.
	 */
	public void push(T newItem) throws StackException
	{
		Node<T> newNode = new Node(newItem, head);
		head = newNode; 
		numItems++;
	}

	public T pop() throws StackException 
	{
		T item = (T)head.getItem();
		head = head.getNext();//unreferences that which was in the head before, and moves the stack
		numItems--;
		return item;		
	}
	
	/*
	 * Returns the item at the top of the array without removing it
	 */
	@SuppressWarnings("unchecked")
	public T peek() throws StackException
	{
		T item = null;
		try
		{
			item = (T)head.getItem();
		}
		catch(Exception e)
		{
		System.out.println("There is nothing here.");
		}
		return item;
	}
	
	/**
	 * Returns the string representation of every item in the array
	 */
	public String toString()
	  {
		  String str = "";
		  Node curr = head;
		  do
		  {
			  str = str + curr.getItem().toString() + ", ";
			  curr = curr.getNext();
		  } while(curr != null);
		  return str;
	  }
}
