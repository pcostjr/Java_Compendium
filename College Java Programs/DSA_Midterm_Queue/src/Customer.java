/**
 * Stores the name of the customer, number of items the customer contains in their cart, and the time they have remained in the center for. 
 * The customer's time value stores a single point that was the time when they entered the store.
 * Upon leaving, the customer's time stamp will be subtracted from the center's current time stamp, producing the total time spent in the store. 
 * When the customer chooses not to leave, their time stamp is set to the current center time.
 * @author Peter Costantino & Nicholas DiGiovanni
 * @version 2018.12.8
 */
public class Customer
{
	private String name;
	private int time;
	private int inventory;
	
	/**
	 * Generates a customer with the given parameters. A new customer's inventory is always 0.
	 * @param name The name of the customer.
	 * @param time The time stamp that records when the customer entered the shopping center.
	 */
	public Customer(String name, int time)
	{
		this.name = name;
		this.time = time;
		inventory = 0;
	}
	

	/**
	 * Gets the name of the customer.
	 * @return String value representing the name.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Gets the customer's time stamp from when they first entered.
	 * @return An int value representing the time stamp
	 */
	public int getTime()
	{
		return time;
	}

	/**
	 * Sets the customer's time stamp for when they enter the store.
	 * @param time An int value representing the current minute since the shopping center opened.
	 */
	public void setTime(int time) 
	{
		this.time = time;
	}
	
	
	/**
	 * Gets the customer's current inventory size
	 * @return An int value representing the inventory size of the customer's cart. 
	 */
	public int getInventory()
	{
		return inventory;
	}
	
	/**
	 * Simulates the customer picking up an item. Increments the inventory, but it is not necessary to store information about that specific item.
	 */
	public void pickUp()
	{
		inventory++;
	}
	
	/**
	 * Simulates the customer putting an item down from their cart. Decrements the inventory, but it is not necessary to store information about that specific item.
	 */
	public void putDown()
	{
		inventory = (inventory - 1 == 0 ? 0 : inventory - 1); //a customer cannot have negative items in their cart
	}
}
