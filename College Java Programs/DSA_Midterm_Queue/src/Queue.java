

/**
 * For this project, we've decided to use a Queue that has an underlying array beneath it. This facilitates two functions.
 * The first is we do not have to keep track of any sort of time besides the stamp for the customers, since the customers will be placed in the queue newest-last
 * And the underlying array structure will allow us to sift through the array to get information for print statements and such without having to call any sort of index method,
 * allowing us direct index access
 * @author Peter Costantino & Nicholas DiGiovanni
 * @version 2018.12.8
 */
public class Queue<T> implements QueueInterface<T>
{

    private static final int MAX_LIST = 3;
    protected T []items;  // an array of list items
    protected int numItems;  // number of items in list
    protected int back;
    protected int front;
    
    /**
     * Creates a new object of type queue.
     */
    public Queue()
    {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
        back = 0;
        front = 0;
    }  // end default constructor

    /**
     * Determines whether or not the queue is empty
     */
    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty
    
    /**
     * Returns the size of the queue
     * @return numitems
     */
    public int size()
    {
    	return numItems;
    }
    
    /**
     * Wipes the array
     */
    public void dequeueAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
    	items = (T[]) new Object[MAX_LIST];
        numItems = 0;
    } // end removeAll
    /**
     * Resizes the queue
     */
    protected void resize(){
    	if (back==front & numItems == items.length)
        {
        	T[] newitems = (T[]) new Object[numItems*2];
			int i = 0;
			while(i<numItems){
			newitems[i]=items[(front+i)%items.length];
			i++;
			}
			items = newitems;
			front = 0;
			back = numItems;
        }
    }
    /**
     * Stores an object at the back of the queue
     */
    public void enqueue(T newItem)throws  QueueException
    	    {
    	        resize();
    
    	            items[back] = newItem;
    	            back = (back+1)%items.length;
    	            numItems++;
    	    } //end add

    /**	    
     * Retrieves an object from the queue without actually removing it
     */
    public T peek()throws QueueException
    	    {
    	        if (numItems!=0)
    	        {
    	            return items[front];
    	        }
    	        else
    	        {
    	            // index out of range
    	            throw new QueueException(
    	                "StackException on peek");
    	        }  // end if
    	    } // end peek

    	    /**
    	     * Dequeues an object from the Queue.
    	     */
    	    public T dequeue() throws QueueException
    	    {
    	    	T popped = items[front];
    	        if (numItems != 0)
    	        {
    	            items[front] = null;
    	            front = (front+1)%items.length;
    	        }
    	        else
    	        {
    	            // index out of range
    	            throw new QueueException(
    	                "StackException on dequeue");
    	        }  // end if
    	        numItems--;
    	        return popped;
    	    } //end remove
    	    public String toString() {
    	    	String theString = "";
    	    	for(int i=0;i<numItems;i++){
    	    		theString = theString  + items[(front+i)%items.length].toString() + " ";	
    	    	}
    	    	return theString;
    	    }
    	    public int getFront(){
    	    	return front;
    	    }
    	    
    	    /**
    		  * Returns the index of the child corresponding to the key in the parent
    		  * @param obj the object to be searched in the parent array
    		  * @return An int value representing the index of the child array. Returns -1 if that item does not exist
    		  */
    		 protected Customer search(String obj)
    		 {
    		 	int i = 0;
    			boolean success = false;
    			while(success != true && i < numItems) //while loop allows us DIA but can also have us stop at any time
    			{
    				if(obj.equalsIgnoreCase(((Customer) items[i]).getName()))//if both objects are strings
    					success = true; //then we set success
    				i++;
    			}
    			return (success == true ? ((Customer)items[i - 1]) : null); //returns null if we can't find it, otherwise will return the customer at the index found.	
    		 }
    		 
    		 public Customer getCustomer(int i) 
    		 {
     	    	return (Customer)items[i % numItems];
     	    }
    }

