import java.util.*;

/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 11/03/2018
 * Submitted: 11/03/2018
 * Comments: For searching and ordering, I added the functionality of a LexBoolean class, which stores a truth value and an index
 * @version 2018.11.03
 * @author Peter Costantino
 *
 */
public class AscendinglyOrderedStringList
{
	protected String[] items;  //an array of Strings 
	protected int numItems;  // number of items in list

	/**
	 * Creates a new AOSL
	 */
	public AscendinglyOrderedStringList()
	{
		items = new String[3];
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
     	items = new String[3];
     	numItems = 0;
 	} // end removeAll

 	/**
  	* Adds to the array
  	*/
 	public void add(String item) throws IndexOutOfBoundsException
 	{
	 	if(numItems == items.length)
				resize(); //resizes if the array is full
	 	DualValue point = search(item);
     	if (point.gtv() == false)
     	{
     		int index = point.getValue();
         	// make room for new element by shifting all items at
         	// positions >= index toward the end of the
         	// list (no shift if index == numItems+1)
         	for (int pos = numItems-1; pos >= index; pos--)
         	{
             	items[pos+1] = items[pos];
         	} // end for
         	// insert new item
         	items[index] = item;
         	numItems++;
         	System.out.println("Successfully inserted item");
     	}
     	else
     		System.out.println("Cannot insert item: Item already exists.");
 	} //end add
 	
 	/**
 	 * Searches for the specified String in the collection
 	 * @param key
 	 * @return
 	 */
 	public DualValue search(String key)
 	{
 		DualValue dualvalue;//creates a new lexicographic boolean object
 		int high = numItems;//the location that is just within the array
 		int low = 0;//the very beginning of the array
 		int mid = 0;
 		if(isEmpty()) //default case for empty array
 		{
 			dualvalue = new DualValue(false, 0); //just returns false and index 0 since there is nothing in the array.
 		}
 		else
 		{
 			while(high > low) //runs for as long as high is greater than low
 			{
 				mid = (low + high)/2; //sets the midpoint of our current "sub array"
 				if(0 < key.compareTo(items[mid]))
 					low = mid + 1; //narrow the search to 1 index above the mid
 				else  
 					high = mid; //otherwise, narrow the search to mid and lower values		
 			} 	
 			System.out.println("Mid = " + mid + " Low = " + low + " High " + high);
 			System.out.println(key.equalsIgnoreCase(items[low]));
 			dualvalue = new DualValue(key.equalsIgnoreCase(items[low]), (key.compareTo(items[mid]) > 0 ? low : mid));
 		} //we use low in this case because high will be lesser than low, which is what allows us to break out of the loop
 		return dualvalue;
 	}

 	/**
  	* Returns an object from the specified index in the array
  	*/
 	public String get (int index) throws IndexOutOfBoundsException
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
  	* Removes an item from the specified index of the array
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
		String[] temp = new String[numItems + (numItems/2 + 1)]; //extends the array by about half the existing spaces plus one
		for(int i = 0; i < numItems; i++)
		{
			temp[i] = items[i]; //copies everything in the cells in i to their respective cells in temp
		}
		items = temp; //changes the reference in items to the new resized array
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
