import java.util.*;
/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 11/07/2018
 * Submitted: 11/07/2018
 * Comments: Removed reverse since we haven't used that for a few labs, converted ResizeArray back to an int primitive class, removed methods that didn't pertain to this project
 * @author Gabriela Hristescu
 * @modified Peter Costantino
 * @version 2018.11.07
 */
@SuppressWarnings("unchecked")
public class ResizeArray implements ListInterface
{
	protected int[] items;  //an array of list items
	protected int numItems;  //number of items in list
	
	/**
	 * Creates a new ResizeArray object
	 */
	public ResizeArray()
	{
		items = new int[10];
		numItems = 0;
 	}

	/**
	 * Determines whether or not the list is empty 
	 */
 	public boolean isEmpty()
 	{
     	return numItems == 0;
 	}

 	/**
  	* Returns the size of the array
  	*/
 	public int size()
 	{
     	return numItems;
 	}

 	/**
  	* Empties the collection
  	*/
 	public void removeAll()
 	{
     	items = new int[10]; //creates a new, empty array, marking the previous for garbage collection
     	numItems = 0;
 	}
 	
 	/**
  	* Adds an item to the array at the specified index
  	*/
 	public void add(int index, int item) throws IndexOutOfBoundsException
 	{
	 	if(numItems == items.length)
				resize(); //resizes if the array is full
     	if (index >= 0 && index <= numItems)
     	{
         	for (int pos = numItems-1; pos >= index; pos--) 
         	{
             	items[pos+1] = items[pos]; //shifts everything down to make room for the new item in the array.
         	} 
         	items[index] = item;
         	numItems++;
     	}
 	}
 	
 	/**
 	 * Adds an item to the last available index in the array
 	 * @param item
 	 */
 	public void add(int item)
 	{
 		if(numItems == items.length)
			resize(); //resizes if the array is full
     	items[numItems++] = item;
 	}

 	/**
  	* Returns an object at the specified index in the array
  	*/
 	public int get(int index) throws IndexOutOfBoundsException
 	{
     	if (index >= 0 && index < numItems)
     	{
         	return items[index];
     	}
     	else
     	{
         throw new IndexOutOfBoundsException(
             "IndexOutOfBoundsException on get");
     	}  
 	}
 
 	/**
	 * Method for resizing the array if it ever becomes full and more items need to be added
	 */
	private void resize()
	{
		int [] temp = new int[numItems + (numItems/2 + 1)]; //extends the array by about half the existing spaces plus one
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
	
	/**
	 * Swaps the two specified indices
	 * @param i the first index
	 * @param j the second index
	 */
	public void swap(int i, int j)
	{
		int temp = items[i]; //swap them
		items[i] = items[j];
		items[j] = temp;
	}
	
	/**
	 * Sorts integer primitives in an array using a bubble sort type of method
	 * Each pass of the loop should shorten the array by 1, because each pass of the inner loop will place the greatest number of that sub-array on the end
	 */
	public void bubbleSort()
	{
		int comparisons = 0, swaps = 0;
		for(int i = numItems - 1; i > 0; i--)//continues the loop, running us through the array
		{
			for(int j = 0; j < i; j++) //focuses on the "sub-array" after each subsequent sort
			{
				comparisons++;
				if(items[j] > items[j + 1]) //if the current is greater than the next
				{
					swaps++;
					swap(j + 1, j);
				}
			}
		}
		System.out.println("Bubble Sort completed with " + comparisons + " comparisons and " + swaps + " swaps.");
	}
	
	/**
	 * An improved bubble sort that allows us to lower the number of comparisons, but not swaps
	 */
	public void improvedBubbleSort()
	{ 
		boolean sorted = false;
		int comparisons = 0, swaps = 0;
		for(int i = numItems - 1; i > 0 && !sorted; i--)//continues the loop, running us through the array
		{
			sorted = true;
			for(int j = 0; j < i; j++) //focuses on the "sub-array" after each subsequent sort
			{
				comparisons++;
				if(items[j] > items[j + 1]) //if the current is greater than the next
				{
					swaps++;
					swap(j + 1, j);
					sorted = false;
				}
			}
		}
		System.out.println("Bubble Sort completed with " + comparisons + " comparisons and " + swaps + " swaps.");
	}
	
	/**
	 * Sorts integers using a selection sort
	 */
	public void selectionSort()
	{
		int min, comparisons = 0, swaps = 0; //minimum for checking the next smallest
		for(int i = 0; i < numItems - 1; i++) //moves us through the array
		{
			min = i;
			for(int j = i  + 1; j < numItems; j++) //our check index for finding a minimum
			{
				comparisons++;
				if(items[j] < items[min])//continue to select a minimum if one exists
					min = j;
			}
			swaps++;
			swap(min, i); //swap that minimum			
		}
		System.out.println("Selection sort completed with " + comparisons + " comparisons and " + swaps + " swaps.");
	}
	/**
	 * Sorts integers using a selection sort
	 */
	public void improvedSelectionSort()
	{
		int min, comparisons = 0, swaps = 0; //minimum for checking the next smallest
		for(int i = 0; i < numItems - 1; i++) //moves us through the array
		{
			min = i;
			for(int j = i  + 1; j < numItems; j++) //our check index for finding a minimum
			{
				comparisons++;
				if(items[j] < items[min])//continue to select a minimum if one exists
					min = j;
			}
			if(items[min] != items[i])
			{
				swaps++;
				swap(min, i); //swap that minimum
			}
		
		}
		System.out.println("Improved selection sort completed with " + comparisons + " comparisons and " + swaps + " swaps.");
	}
	
	public void insertionSort()
	{
		int j, comparisons = 0, inserts = 0, x;
		for(int i = 1; i < numItems; i++)
		{
			j = i - 1; //j starts at the previos index to include it in the comparison
			x = items[i]; //x is the item we'll be reinserting
			comparisons++;
			while(j >= 0 && items[j] > x) //while j is not zero and x is greater than the item
			{
				items[j + 1] = items[j]; //move everything to the side
				j--;
			}	
			inserts++;
			items[j + 1] = x; //after, insert
		}
		System.out.println("Insertion sort completed with " + comparisons + " comparisons and " + inserts + " inserts");
	}
	
}



