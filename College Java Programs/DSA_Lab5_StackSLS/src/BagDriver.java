import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		StackSLS items = new StackSLS(); //the LRB that we'll be manipulating
		StackSLS gifts = new StackSLS(); //the LRB for the sample bag
		boolean running = true;
		System.out.println("0: Exit Program \n 1: Pick Up Item \n 2: Drop Off Item \n 3: Display packages and bag weight \n 4: Display number of items and weight of bag samples \n 5: Enjoy an item from the sample bag \n 6: Enjoy all the sample items");
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
					pickUpOrder(items);
					break;
				case 2:
					dropOffOrder(items, gifts);
					break;
				case 3:
					displayItems(items);
					break;
				case 4:
					displayItems(gifts); 
					break;
				case 5:
					enjoy(gifts);
					break;
				case 6:
					System.out.println("You enjoy everything in the bag.");
					bagweight = 0;
					gifts.popAll();
					break;
			}
		}
	}
	
	/**
	 * Facilitates pushing an item onto the stack
	 * @throws IOException
	 */
	private static void pickUpOrder(StackSLS items) throws IOException
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
		items.push(new Package(name, weight, quantity, sender, reciever)); //pushed directly into the stack
		System.out.println("A package of name: " + name + " That weighs, " + (weight * quantity) + " has been added to the bag."); 	
		bagweight += (weight * quantity); //adds to the weight
	}
	
	
	/**
	 * Facilitates popping a single item off of the stack
	 * @throws IOException
	 */
	private static void dropOffOrder(StackSLS items, StackSLS gifts) throws IOException
	{
		if(!items.isEmpty()) //if the collection is not empty
		{
			Package retrieved = (Package)items.pop();
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
	 * Enjoy an item from the samples
	 * @param items
	 */
	private static void enjoy(StackSLS items)
	{
		Package sample = (Package)items.pop();
		if(sample != null)
		{
			System.out.println("You enjoy a " + sample.getName() + " from the sample bag.");	
			giftbagweight -= sample.getWeight();
		}
		else
			System.out.println("This bag is empty.");
		
	}
	
	/**
	 * Displays the collection, or lack thereof
	 */
	private static void displayItems(StackSLS items)
	{
		if(!items.isEmpty())
		{			
			System.out.println("Bag Weight = " + bagweight + "\n" + "Contents = " + items.toString());
		}
		else
			System.out.println("This bag is empty");
	}	
}
