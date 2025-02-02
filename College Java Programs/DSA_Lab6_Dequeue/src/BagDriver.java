import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

/*
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated 10/10/2018
 * Submitted: N/A
 * Comments: I used a DEQ and a StackSLS in this iteration of the driver to demonstrate how two different systems, one with an array, and one without
 * could be utilized together
 * @author Peter Costantino
 * @version 2018.10.10
 */
@SuppressWarnings("unchecked")
public class BagDriver 
{
	private static BufferedReader br;
	private static double bagweight;
	private static double giftbagweight;
	/**
	 * The main operating system of the program
	 * @param args
	 * @throws IOException
	 */
	public static void main (String args[]) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		bagweight = 0;
		giftbagweight = 0;
		DEQ items = new DEQ(); //the DEQ we'll be manipulating for the packages bag
		StackSLS gifts = new StackSLS(); //the StackSLS we'll be using for the gift bag
		boolean running = true;
		System.out.println("0: Exit Program \n 1: Pick Up Item \n 2: Drop Off Item \n 3: Display packages and bag weight \n 4: Display number of items and weight of bag samples \n 5: Enjoy an item from the sample bag \n 6: Enjoy all the sample items \n 7 Pick Up Priority: Order");
		int input;
		while(running)
		{
			input = Integer.parseInt(br.readLine()); 
			switch(input)
			{
				case 0:
					running = false;
					break;
				case 1:
					pickUpOrder(items, true);
					break;
				case 2:
					dropOffOrder(items, gifts);
					break;
				case 3:
					displayPackageBagItems(items);
					break;
				case 4:
					displayGiftBagItems(gifts); 
					break;
				case 5:
					enjoy(gifts);
					break;
				case 6:
					System.out.println("You enjoy everything in the bag.");
					bagweight = 0;
					gifts.popAll();
					break;
				case 7:
					pickUpOrder(items, false);
					break;
			}
		}
	}
		
		/**
		 * Facilitates adding an order to the bag of packages. Delimeter is used to enqueue at the front or back in case an order is a priority
		 * @throws IOException
		 */
		private static void pickUpOrder(DEQ items, boolean delimeter) throws IOException
		{
			System.out.println("Please enter the name of the item"); //name, individual weight, quantity, sender, receiver
			String name = br.readLine(); //takes the name
			System.out.println("Please enter the weight of each individual item.");
			double weight = Double.parseDouble(br.readLine());
			System.out.println("Please enter the quantity of each item.");
			double quantity = Double.parseDouble(br.readLine());
			System.out.println("Please specify the sender");
			String sender = br.readLine();
			System.out.println("Please specify the recipient");
			String reciever = br.readLine();
			Package pkg = new Package(name, weight, quantity, sender, reciever);
			if(delimeter)
				items.enqueue(pkg); //added regularly to the queue
			else
				items.enqueueFirst(pkg); //queued as the first item.
			System.out.println("A package of name: " + name + " That weighs, " + (weight * quantity) + " has been added to the bag."); 	
			bagweight += (weight * quantity); //adds to the weight
		}
		
		/**
		 * Facilitates dropping an order off
		 * @throws IOException
		 */
		private static void dropOffOrder(DEQ items, StackSLS gifts) throws IOException
		{
			if(!items.isEmpty()) //if the collection is not empty
			{
				Package retrieved = (Package)items.dequeue();
				int numItems = (int)retrieved.getQuantity();
				bagweight -= (retrieved.getWeight() * retrieved.getQuantity());
				System.out.println("Alright " + retrieved.getRecipient() +", here's your package from " + retrieved.getSender() +
							" of " + (int)retrieved.getQuantity() + " " + retrieved.getName() + (numItems > 0 ? "s" : "") + ". May I please keep one? (Y/N)");
				String check = br.readLine();
				if(check.equals("Y"))
				{
					System.out.println("Thank you!");
					gifts.push(new Package(retrieved.getName(),retrieved.getWeight(), 1,null, null));
					giftbagweight += retrieved.getWeight(); //adds to the weight
				}
			} //otherwise it would just pop into the aether and be garbage collected
			else
				System.out.println("This bag is empty.");
		}
		
		/**
		 * Displays the collection, or lack thereof, in this case specific to the QueueRA
		 */
		private static void displayPackageBagItems(DEQ items)
		{
			if(!items.isEmpty())
			{			
				System.out.println("Bag Weight = " + bagweight);
				System.out.println("Bag size = " + items.size() + "\n" + "Contents = " + items.toString());
			}
			else
				System.out.println("Error: Queue is Empty");
		}	
		
		/**
		 * Displays the collection, or lack thereof, in this case, used fo the gift bag
		 */
		private static void displayGiftBagItems(StackSLS items)
		{
			if(!items.isEmpty())
			{			
				System.out.println("Bag Weight = " + giftbagweight + "\n" + "Contents = " + items.toString());
			}
			else
				System.out.println("This bag is empty");
		}	
		
		/**
		 * Enjoy an item from the samples
		 * @param items
		 */
		private static void enjoy(StackSLS items)
		{			
			if(!items.isEmpty())
			{
				Package sample = (Package)items.pop();
				System.out.println("You enjoy a " + sample.getName() + " from the sample bag.");	
				giftbagweight -= sample.getWeight();
			}
			else
				System.out.println("This bag is empty.");
			
		}
}
