
public class ShoppingCenter {

	private Queue<Customer> lineOne;
	private Queue<Customer> lineTwo;
	private Queue<Customer> express;
	private Queue<Customer> customersInStore;
	public ShoppingCenter() {
		lineOne = new Queue<Customer>();
		lineTwo = new Queue<Customer>();
		express = new Queue<Customer>();
		customersInStore = new Queue<Customer>();
	}
	
	/**
	 * Add a customer to the Queue of customers in store.
	 * @param name - variable name of the customers
	 */
	public void walkIn(Customer name)
	{
		Customer cus = new Customer(name.getName())
		customersInStore.enqueue(name);
	}
	
	/**
	 * Add a customer to the Queue representing the first checkout line.
	 * @param name - variable name of the customers
	 */
	public void enterLineOne(Customer name){
		lineOne.enqueue(name);
	}
	/**
	 * Add a customer to the Queue representing the second checkout line.
	 * @param name - variable name of the customers
	 */
	public void enterLineTwo(Customer name){
		lineTwo.enqueue(name);
	}
	/**
	 * Add a customer to the Queue representing the express checkout line.
	 * @param name - variable name of the customers
	 */
	public void enterExpress(Customer name){
		express.enqueue(name);
	}
	/**
	 * Dequeue the customer at the front of the queue of customers in store.
	 * @return - variable name of the customer leaving the store
	 */
	public Customer walkOut()
	{
		return customersInStore.dequeue();
	}
	/**
	 * Dequeue the customer at the front of the queue of customers in the first checkout line.
	 * @return - variable name of the customer leaving the store
	 */
	public Customer checkoutLineOne(){
		return lineOne.dequeue();
	}
	/**
	 * Dequeue the customer at the front of the queue of customers in the second checkout line.
	 * @return - variable name of the customer leaving the store
	 */
	public Customer checkoutLineTwo(){
		return lineTwo.dequeue();
	}
	/**
	 * Dequeue the customer at the front of the queue of customers in the express checkout line.
	 * @return - variable name of the customer leaving the store
	 */
	public Customer checkoutLineExpress(){
		return express.dequeue();
	}
	/**
	 * Returns the numbers of customers in the shopping center.
	 * @return - number of customers in customersInStore Queue.
	 */
	public int customersInStore()
	{
		return customersInStore.size();
	}
	/**
	 * Returns the numbers of customers in the first line.
	 * @return - number of customers in lineOne Queue.
	 */
	public int lineOneLength(){
		return lineOne.size();
	}
	/**
	 * Returns the numbers of customers in the second line.
	 * @return - number of customers in lineTwo Queue.
	 */
	public int lineTwoLength(){
		return lineTwo.size();
	}
	/**
	 * Returns the numbers of customers in the express line.
	 * @return - number of customers in express Queue.
	 */
	public int expressLineLength(){
		return express.size();
	}
	
	/**
	 * Searches the customers list for a specific customer
	 * @param cus
	 * @return A matching customer, if there is one in the array
	 */
	public Customer searchCustomers(String cus)
	{
		return customersInStore.search(cus);
	}
	
	/**
	 * Return the amount of customers in the shopping center
	 * @param i
	 * @return All customers in the store not in a checkout line
	 */
	public Customer getCustomerInStore(int i)
	{
		return customersInStore.getCustomer(i);
	}
	/**
	 * Returns the number of customers in the first checkout lane
	 */
	public Customer getCustomerInLineOne(int i)
	{
		return lineOne.getCustomer(i);
	}
	/**
	 * Returns the number of customers in the second checkout lane
	 */
	public Customer getCustomerInLineTwo(int i)
	{
		return lineTwo.getCustomer(i);
	}
	/**
	 * Returns the number of customers in the express lane
	 */
	public Customer getCustomerInExpress(int i)
	{
		return express.getCustomer(i);
	}
	
}
