import java.util.*;
/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 11/14/2018
 * Submitted: 11/20/2018
 * Comments: Removed all previous sorting methods that weren't iterative merge sort or recursive Quick sort
 * @author Gabriela Hristescu
 * @modified Peter Costantino
 * @version 2018.11.14
 */
@SuppressWarnings("unchecked")
public class ResizeArray implements ListInterface
{
	protected int[] items;  //an array of list items
	protected int numItems;  //number of items in list
	Random rand;
	
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
	
    public void iMergeSort() 
    { 
        for (int increment = 1; increment <= numItems-1; increment *= 2) 
        { //the increments we'll be using from the smallest array size to the largest, doubling each time
            for (int left = 0; left < numItems-1; left += 2*increment) 
            { //loop for comparing 2 subarrays at one time
                int middle = (left + increment - 1 > numItems - 1 ? numItems - 1 : left + increment - 1); //middle is the last index of the "left" sub array          
                int check = left + 2*increment - 1; //prevents double reevaluation. check is the rightmost end of our comparing arrays. In particular, 2 increments from the left minus one.
                int right = (numItems - 1 < check ? numItems - 1 : check);
                merge(left, middle, right); 
            } 
        } 
    } 
      
    public void merge(int left, int middle, int right) 
    { 
        int ileft = 0, iright = 0, iitems = left;        
        int leftarr[] = new int[middle - left + 1]; //the size of left array is equivalent to the span between the middle and the leftstart
        int rightarr[] = new int[right - middle]; //the right array is equal to the span between the middle and the farthest right
    
        for (int i = 0; i < leftarr.length; i++) 
            leftarr[i] = items[left + i]; //populate both arrays with the items in scope
        for (int i = 0; i < rightarr.length; i++) 
            rightarr[i] = items[middle + i + 1]; 
      
        while (ileft < leftarr.length && iright < rightarr.length) 
        { 
            if (leftarr[ileft] <= rightarr[iright]) //whichever item is less
                items[iitems++] = leftarr[ileft++]; //place it in the array and increment both respective counts
            else
            	items[iitems++] = rightarr[iright++];
        } 
      
        while (ileft < leftarr.length) 
            items[iitems++] = leftarr[ileft++];//if there is anything left in either array, push it back out to items 
        while (iright < rightarr.length) 
        	items[iitems++] = rightarr[iright++];
    } 
    
    /**
     * Utilizes a quicksort using Random pivot generation
     */
    public void quickSort(int low, int high)
    {
    	rand = new Random();  
    	int lowcount = low; //i is the lower bound
    	int highcount = high; //j is the higher bound
    	int pivot = items[rand.nextInt(high)]; //choose a random pivot  	  	
    	while(lowcount <= highcount) //while the lower is less than or equal to the high
    	{
    		while(items[lowcount] < pivot)
    			lowcount++;//increase the lowcount until we find an item greater than pivot
    		while(items[highcount] > pivot)
    			highcount--;//decrease the highcount until we find an item less than
    		if (lowcount <= highcount)
    		{//if the lowcount is less than or equal to the highcount, swap these indices so that a lower number is below the pivot, and the higher number above
               swap(lowcount, highcount);
                lowcount++; //then increase the lowcount and decrease the highcount to move on
                highcount--;
            }
    	 if (low < highcount)//quicksort on a smaller subarray from low to highcount, since at this point highcount will be less than pivot
    	            quickSort(low, highcount);
    	 if (lowcount < high)
    	          quickSort(lowcount, high);//likewise, do the same on a subarray greater than the pivot, because lowcount will have surpassed the pivot
    	}
    }
}



