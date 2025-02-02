/**
 * A class that contains two arrays, the parent and child, for use as the inventory for the shopping center.
 * The parent array is a collection of Strings that store the names of each product in the center.
 * The child array is a collection of ints that store the quantities of the respective parent items
 * Both arrays are parallel to one another, so they will always be of the same length.
 * The name stored in the parent corresponds with the quantity stored in the child.
 * @author Peter Costantino & Nicholas DiGiovanni
 * @version 2018.12.8
 */
public class ShopInventory
{
	private String [] parent;
	private int[] child;
	private int numItems;
	private int restock;
	
	/**
	 * Creates a new parallel array. 
	 */
	public ShopInventory(int restock)
	{
		parent = new String[5];
		child = new int[5];
		numItems = 0;		
		this.restock = restock; //sets the restock level of all items
	}
	
	 /**
	 * Determines if both arrays are empty.
	 * @return The boolean value determining if the number of items is zero.
	 */
	 public boolean isEmpty()
	 {
	     return numItems == 0;
	 }

	 /**
	  * Returns the size of the parallel array
	  * @return An int value representing the size of the array
	  */
	 public int size()
	 {
	     return numItems;
	 }
	 
	 /**
	  * Resizes both arrays, preallocating more memory available for use.
	  */
	 private void resize()
	 {
		 String[] strTemp = new String[numItems + (numItems/2 + 1)];//extends the array by about half the existing spaces plus one
		 int[] intTemp = new int[numItems + (numItems/2 + 1)];//extends the array by about half the existing spaces plus one
		 for(int i = 0; i < numItems; i++)
		 {
			 strTemp[i] = parent[i]; //copies everything in the cells in i to their respective cells in temp
		 }
		 parent = strTemp;//changes the reference in items to the new resized array
		 for(int i = 0; i < numItems; i++)
		 {
			 intTemp[i] = child[i]; //copies everything in the cells in i to their respective cells in temp
		 }
		 child = intTemp;//changes the reference in items to the new resized array
	 }
	 
	 /**
	  * Returns the index of the child corresponding to the key in the parent
	  * @param obj the object to be searched in the parent array
	  * @return An int value representing the index of the child array. Returns -1 if that item does not exist
	  */
	 public int search(String obj)
	 {
	 	int i = 0;
		boolean success = false;
		while(success != true && i < numItems) //while loop allows us DIA but can also have us stop at any time
		{
			if(obj.equalsIgnoreCase(parent[i]))//if both objects are strings
				success = true; //then we set success
			i++;
		}
		return (success == true ? i - 1 : -1); //returns -1 if we can't find it, otherwise will return the index		
	 }

	 /**
	  * Adds the specific parent-child combination to the array
	  * @param parentobj The String representing the parent object in the first array, that will be the item name.
	  * @param childobj An int value representing the quantity of the parent object, stored in the child array.
	  * @throws IndexOutOfBoundsException
	  */
	 public void add(String parentobj, int childobj) throws IndexOutOfBoundsException
	 {
		 if(numItems == parent.length)
				resize(); //resizes if the array is full, we only need to check one because both arrays will run parallel with one another
		 parent[numItems] = parentobj;
		 child[numItems++] = childobj; //increment the array once we're done using the specified index
	 }

     /**
      * Simulates a customer taking an item from the shopping center
      * @param obj The object in particular the customer wants
      * @throws IndexOutOfBoundsException
      */
	 public boolean take(String obj) throws IndexOutOfBoundsException
	 {
		 String print = "It seems we don't have anything like that in our store."; //prevents else bracket
		 boolean taken = false;
		 int search = search(obj);
	     if(search(obj) != -1) //if we do have an index pointing to the inventory
	     {
	    	if(child[search] > 0)
	    	{
	    		child[search] = (child[search] - 1 == 0 ? 0 : child[search] - 1);//decrement the count of that item, if it's already 0, leave it at 0
	    		taken = true;	
	    		print = "Item Taken!";
	    	}
	    	else
	    		print = "We don't seem to have any more of that item in stock.";
	     }
	    	 System.out.println(print);     
	     return taken;
	 }
		
	 /**
	  * Displays all of the items in the shop's inventory that shows the current restock level
	  */
	 public void showRestock()
	 {
		 String str = "";
		 for(int i = 0; i < numItems; i++)
		 {
			 if(child[i] <= restock)//if the quantity of the item is less than the restock level
				 str = str + parent[i] + " quantity: " + child[i] + "\n"; //add it to the status display
		 }
		 System.out.println(str);
	 }
	 
	 public int getChild(int index){
		 return child[index];
	 }
	 public void setChild(int index, int amount){
		 child[index] = amount;
	 }
}
