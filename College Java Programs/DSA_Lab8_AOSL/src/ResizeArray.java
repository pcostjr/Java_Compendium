
import java.io.IOException;
import java.util.*;
/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 10/13/2018
 * Submitted: 10/13/2018
 * Comments: N/A
 * @author Gabriela Hristescu
 * @modified Peter Costantino
 * @version 2018.10.13
 */
@SuppressWarnings("unchecked")
public class ResizeArray<T> implements ListInterface<T>
{
	protected T [] items;  // an array of list items
	protected int numItems;  // number of items in list

	/**
	 * Creates a new resizable array
	 */
	public ResizeArray()
	{
		items = (T[]) new Object[3];
		numItems = 0;
 	}  // end default constructor

 	/**
  	* Determines if the collection is empty
  	*/
 	public boolean isEmpty()
 	{
     	return numItems == 0;
 	} // end isEmpty

 	/**
  	* Returns the size of the array
  	*/
 	public int size()
 	{
     	return numItems;
 	}  // end size

 	/**
  	* Empties the collection
  	*/
 	public void removeAll()
 	{
     	// Creates a new array; marks old array for
     	// garbage collection.
     	items = (T[]) new Object[3];
     	numItems = 0;
 	} // end removeAll

 	/**
  	* Adds to the array
  	*/
 	public void add(int index, T item) throws IndexOutOfBoundsException
 	{
	 	if(numItems == items.length)
				resize(); //resizes if the array is full
     	if (index >= 0 && index <= numItems)
     	{
         	// make room for new element by shifting all items at
         	// positions >= index toward the end of the
         	// list (no shift if index == numItems+1)
         	for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
         	{
             	items[pos+1] = items[pos];
         	} // end for
         	// insert new item
         	items[index] = item;
         	numItems++;
     	}
 	} //end add

 	/**
  	* Returns an object from the array
  	*/
 	public T get(int index) throws IndexOutOfBoundsException
 	{
     	if (index >= 0 && index < numItems)
     	{
         	return items[index];
     	}
     	else
     	{
         // index out of range
         throw new IndexOutOfBoundsException(
             "IndexOutOfBoundsException on get");
     	}  // end if
 	} // end get

 	/**
  	* Removes an item from the array
  	*/
 	public void remove(int index) throws IndexOutOfBoundsException
 	{
     	if (index >= 0 && index < numItems)
     	{
         	// delete item by shifting all items at
    	 	// positions > index toward the beginning of the list
    	 	// (no shift if index == size)
         	for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
         	{
        	 	items[pos-1] = items[pos];
         	}  // end for
         	items[--numItems] = null; //fixes the memory leak by setting the end value that does not hold a reference back to null, also
     	}
     	else
     	{
         // index out of range
    	 	throw new IndexOutOfBoundsException("IndexOutOfBoundsException on remove");
     	}  // end if
 	} //end remove
 
 	/**
	 * Method for resizing the array if it ever becomes full and more items need to be added
	 */
	private void resize()
	{
		T [] temp =(T[]) new Object[numItems + (numItems/2 + 1)]; //extends the array by about half the existing spaces plus one
		for(int i = 0; i < numItems; i++)
		{
			temp[i] = items[i]; //copies everything in the cells in i to their respective cells in temp
		}
		items = temp; //changes the reference in items to the new resized array
	}
	
	/**
	 * Reverses the list.
	 */
	public void reverse()
	{
		T [] revarr = (T[]) new Object[items.length]; //makes an array of the exact same length as items
		for(int i = 0; i < numItems; i++)
		{
			revarr[i] = items[numItems - 1 - i]; //reverses all the orders of each item in the array
		} 
		items = revarr; //changes the reference in items to the new reversed array	
	}
	
	/**
	 * Returns the string representation of the array
	 */
	public String toString()
	{
		String str = new String();
		if(!isEmpty())
		{			
			for(int i = 0; i < numItems; i++)
				str = str + items[i] + ", ";
		}
		else
			str = "List is Empty.";
		return str;		
	}
}

