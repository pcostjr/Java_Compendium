import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The main Driver of the Program. Handles User-To-Program interface and controls how the user accesses and manipulates all of the underlying ADTs.
 * @author Peter Costantino & Nicholas DiGiovanni
 * @version 2018.12.8
 */
public class Driver 
{
	static int storeTime = 0;
	static int turn = 1;
	static int numOfItems = 0;
	static int itemAmount = 0;
	static BufferedReader rdr = new BufferedReader (new InputStreamReader(System.in));
	static ShoppingCenter center = new ShoppingCenter();
	static ShopInventory inventory;
	
    /**
     * Faciliates a customer entering the store
     * @throws IOException
     */
	public static void enterCenter()throws IOException
    {
	boolean enters = false;
	while(!enters)
	{
    		System.out.println(">>Enter customer name : ");
    		String temp = rdr.readLine();
    		String print = "That customer already exists!";
    		if(center.searchCustomers(temp) == null)
    		{    	
			enters = true;	
    			center.walkIn(new Customer (temp, storeTime));
    			print = "Customer " + temp + " is now in the Shopping Center.";
    		}	
    		System.out.println(print);
	}
    }

	/**
	 * Simulates a customer picking up an Item off of the store shelf.
	 * @throws IOException
	 */
	public static void pickUpItem()throws IOException
	{
		String print = "No one is in the Shopping Center!"; //we set the return string as the case for no one being in the center
		if(center.customersInStore()!=0) //so long as there are people in the store
		{
			System.out.println(">>Enter customer name : ");
			String temp = rdr.readLine();
			Customer cus = center.searchCustomers(temp);//searches for the customer
			if(cus != null) //if the customer exists
			{
				System.out.println(">>What item does " + temp + " want?");
				if(inventory.take(rdr.readLine().trim()))//reduce the shop inventory if we have the item
				{
					storeTime++;
					cus.pickUp();//simulate the pickup
				}
				int inventory = cus.getInventory(); //prevents reevaluation
				print = "Customer " + temp + " has " + inventory + " item" + (inventory <= 1 ? "" : "s") + " in shopping cart.";
				
			}
			else		
				print = "Oops! That customer doesn't exist.";
		}
		System.out.println(print);
	}
	
	/**
	 * Simulates the customer removing an item from their cart.
	 * @throws IOException
	 */
	public static void removeItem()throws IOException
	{
		String print = "No one is in the Shopping Center!"; //return string with empty case to prevent else print
		if(center.customersInStore()!=0)
		{
			System.out.println(">>Enter customer name : ");
			Customer cus = center.searchCustomers(rdr.readLine());
			if(cus != null)
			{
				int inventory = cus.getInventory(); //prevents unnecessary double method call in print statement
				if(inventory != 0) //if the customer has something in their inventory
				{
					cus.putDown(); //simulates the customer putting an item down
					inventory--; //decrements the temporary inventory value, this is still better than dual method calls
					print = "Customer " + cus.getName() + " now has " + inventory + " item" + (inventory <= 1 ? "" : "s") + " in their shopping cart.";
					storeTime++;
				}
				else
					print = "There's nothing to put down!";
				

			}
			else
				print = "Oops! That customer does not exist.";
		}
		System.out.println(print);
	}

	/**
	 * Faciliates when a customer has completed shopping and is ready to enter a check out lane. This will always be the customer who has shopped the longest.
	 */
	public static void doneShopping()
	{
		String print = "No one is in the Shopping Center!"; //we first set the string to display the worst case of a vacant shopping center.
		if(center.customersInStore()!=0)//check to determine if any customers are in store.
		{
			Customer temp = center.walkOut(); //pull a customer out of the shopping center
			int tempItems = temp.getInventory(); //prevents reevaluation
			int lnOneLength = center.lineOneLength();
			int lnTwoLength = center.lineTwoLength();
			String chosenLine = "";
			if(tempItems <= 4 && center.expressLineLength()<(lnOneLength*2) && center.expressLineLength()<(lnTwoLength*2)) //if the customer has <= 4 items, and the express is the most convenient line
			{
				center.enterExpress(temp);
				chosenLine = " express checkout line";
			}
			else if(lnOneLength<=lnTwoLength)//otherwise we place them in the shortest regular checkout line, with line one taking a slightly higher precedence.
			{
					center.enterLineOne(temp);
					chosenLine = " first checkout line";
			}
			else
			{
					center.enterLineTwo(temp);
					chosenLine = " second checkout line";
			}
			print = "After " +(storeTime - temp.getTime())+ " minutes in the Shopping Center customer " + temp.getName() + " with " + tempItems + " items is now in " + chosenLine;
		}
		System.out.println(print);
		
	}
	
	/**
	 * Faciliates a customer inside of a checkout lane to check out and choose to either continue shopping or to exit the store.
	 * This method is cyclical in the sense that the checkout lane that has been idled the longest, starting with Express>>1>>2 will be emptied of one customer
	 * @throws IOException
	 */
	public static void checkout()throws IOException
	{
		boolean go = true; //loop truth value
		Customer temp = null;
		String print = "No customers in any line.";
		if(center.expressLineLength()+center.lineOneLength()+center.lineTwoLength() >= 1) //so long as there is a person in a line
		{
			while(go)//loop for searching for an available customer.
			{
				if(turn == 1 && center.expressLineLength()>0)
				{
					temp = center.checkoutLineExpress();
					go=false;
				}
				else if (turn == 2 && center.lineOneLength()>0)
				{
					temp = center.checkoutLineOne();
					go=false;
				}
				else if (turn == 3 && center.lineTwoLength()>0)
				{
					temp = center.checkoutLineTwo();
					go=false;
				}
				if(turn<3)
				{
					turn++;
				}
				else
				{
					turn=1;
				}
			}
			System.out.println("Should customer " + temp.getName() + " check out or keep on shopping? Checkout?(Y/N):"); //determines if a customer wants to continue shopping
			String answer = rdr.readLine().trim();
			print = "Customer " + temp.getName();
			print = print + (answer.equals("Y") ? " is leaving the shopping center." : " with " + temp.getInventory() + " items returned to shopping."); //if the answer is anything but a Y, the customer reenters the center
			if(!answer.equals("Y")) 
			{
				temp.setTime(storeTime);
				center.walkIn(temp); //if answer is anything but a Y, the customer reenters the shopping queue
			}
		}
		System.out.println(print);
	}


/**
 * Prints out all information about customers currently shopping in the center.
 */
public static void printShoppingInfo()
{
	if(center.customersInStore()>0){
		System.out.println("The following " + center.customersInStore() + " customers are in the Shopping Center:");
		Customer temp = null;
		for(int i = 0; i < center.customersInStore(); i++){
			temp = center.getCustomerInStore(i);
			System.out.println(temp.getTime());
			System.out.println("\tCustomer " + temp.getName() + " with " + temp.getInventory() + " items present for " + (storeTime - temp.getTime()) + " minutes.");
		}
	}
	else{
		System.out.println("No customers are in the Shopping Center!");
	}
}

/**
 * Prints out all information about customers currently in each checkoutline
 */
public static void printCheckoutInfo(){
	if(center.lineOneLength()>0){
		System.out.println("The following customers are in the first checkout line:");
		Customer temp = null;
		for(int i = 0; i < center.lineOneLength(); i++){
			temp = center.getCustomerInLineOne(i);
			System.out.println("\tCustomer " + temp.getName() + " has " + temp.getInventory() + " items in the shopping basket.");
		}
	}
	else{
		System.out.println("No customers are in the first checkout line!");
	}
	
	if(center.lineTwoLength()>0){
		System.out.println("The following customers are in the second checkout line:");
		Customer temp = null;
		for(int i = 0; i < center.lineTwoLength(); i++){
			temp = center.getCustomerInLineTwo(i);
			System.out.println("\tCustomer " + temp.getName() + " has " + temp.getInventory() + " items in the shopping basket.");
		}
	}
	else{
		System.out.println("No customers are in the second checkout line!");
	}
	
	if(center.expressLineLength()>0){
		System.out.println("The following customers are in the first express line:");
		Customer temp = null;
		for(int i = 0; i < center.expressLineLength(); i++){
			temp = center.getCustomerInExpress(i);
			System.out.println("\tCustomer " + temp.getName() + " has " + temp.getInventory() + " items in the shopping basket.");
		}
	}
	else{
		System.out.println("No customers are in the express checkout line!");
	}
}

/**
 * Prints out all information about items at or below the restocking level.
 */
public static void printRestockInfo(){
	if(inventory.isEmpty()==false){
		System.out.println("Items at restocking level:");
		inventory.showRestock();
	}
	else{
		System.out.println("No items at or below restocking level!");
	}
}

/**
 * Facilitates user reordering items at or below the restocking level.
 * @throws IOException
 */
public static void reorder()throws IOException{
	System.out.println("Enter item to be reordered:");
	String item = rdr.readLine();
	int index = inventory.search(item);
	if(index==-1){
		System.out.println(item + " is not in stock!");
	}
	else{
		System.out.println("Enter number of " + item + "s to be reordered:");
		int amount = Integer.parseInt(rdr.readLine().trim());
		System.out.println("Stock now has " + (inventory.getChild(index)+amount) + " " + item + "s.");
		inventory.setChild(index, (inventory.getChild(index)+amount));
	}
}
	/**
 	* Populates the Shopping inventory, without cluttering up the main method declaration, since these statements will only execute once at the beginning of the program.	
 	* @throws IOException
 	*/
	public static void populate() throws IOException
	{
		System.out.println("Welcome to Shopping Center!!!\nPlease specify how many items to stock.");
		numOfItems = Integer.parseInt(rdr.readLine().trim());
		System.out.println("Please specify restocking amount:");
		inventory = new ShopInventory(Integer.parseInt(rdr.readLine().trim())); //creates a ShopInventory with the restocking level specified by user		
		for(int i = 0; i < numOfItems; i++)//runs these statements until we've stocked all of the items
		{
			System.out.println(">>Enter item name : ");
			String temp = rdr.readLine();
			System.out.println(">>How many " + temp + "s? ");
			inventory.add(temp, Integer.parseInt(rdr.readLine().trim()));
			System.out.println("Item has been stocked.");
		}
		boolean run = true;
		while(run)
		{
			System.out.println("Please enter the checkout lane you'd like to have customers exit first. (regular1/regular2/express)");
			String input = rdr.readLine().trim();
			if(input.equals("express"))
			{
				turn = 1;
				run = false;
			}
			else if(input.equals("regular1"))
			{
				turn = 2;
				run = false;
			}
			else if(input.equals("regular2"))
			{
				turn = 3;
				run = false;
			}
			else
				System.out.println("Please specify one of the three options (regular1/regular2/express)");			
		}
	}

	/**
	 * Runs the program.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)throws IOException
	{
		
			boolean going = true;
			populate();	//populates the shopping center
			System.out.println("\n\t0.  Close the Shopping Center. \n\t1.  Customer enters Shopping Center.\n\t2.  Customer picks an item and places it in the shopping cart."
					+ "\n\t3.  Customer removes an item from the shopping cart.\n\t4.  Customer is done shopping.\n\t5.  Customer checks out.\n\t6.  Print info about customers who are shopping."
					+ "\n\t7.  Print info about customers in checkout lines.\n\t8.  Print info about items at or below re-stocking level.\n\t9.  Reorder an item.");
			while(going)
			{
				try
				{
				System.out.print("Make your menu selection now: ");
				String theselection = rdr.readLine();
				System.out.println(theselection);
				int selection = Integer.parseInt(theselection.substring(0,1));
				switch(selection)
				{
				case 0:
					going = false;
					System.out.println("The Shopping Center is now closed. See you again tomorrow!");
					break;
				case 1:
					enterCenter();
					break;
				case 2:
					pickUpItem();
					break;
				case 3:
					removeItem();
					break;
				case 4:
					doneShopping();
					break;
				case 5:
					checkout();
					break;
				case 6:
					printShoppingInfo();
					break;
				case 7:
					printCheckoutInfo();
					break;
				case 8:
					printRestockInfo();
					break;
				case 9:
					reorder();
					break;
				}
				}
				catch(Exception e)
				{
					System.out.println("Sorry, didn't quite catch that.");
					
				}
			}
		
	}
}
