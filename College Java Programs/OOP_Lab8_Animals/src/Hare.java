

/**
 * A basic Hare class involving an RNG and the ability to return the "position" of the Hare 
 * @author Peter Costantino
 * @version 01-30-18
 */
public class Hare extends Animal
{
	private int TEN_PERCENTILE; //value for what the hare does 10% of the time
	private int TWENTY_PERCENTILE; //value for what the hare does 20% of the time
	private int TWENTY_PERCENTILE_2; //value for what the hare does 20% of the time
	private int TWENTY_PERCENTILE_3; //value for what the hare does 20% of the time
	private int THIRTY_PERCENTILE; //value for what the hare does 30% of the time
	/**
	 * Creates a generic object of type Hare
	 */
	public Hare()
	{
		super();
		TEN_PERCENTILE = -12; //sets the ten to negative twelve
		TWENTY_PERCENTILE = 9; //sets the first twenty to nine
		TWENTY_PERCENTILE_2 = -2; //sets the second twenty to negative 2
		TWENTY_PERCENTILE_3 = 0; //sets the third twenty to zero
		THIRTY_PERCENTILE = 1; //sets the thirty to one
	}
	
	public Hare(String name)
	{
		super(name);
		TEN_PERCENTILE = -12; //sets the ten to negative twelve
		TWENTY_PERCENTILE = 9; //sets the first twenty to nine
		TWENTY_PERCENTILE_2 = -2; //sets the second twenty to negative 2
		TWENTY_PERCENTILE_3 = 0; //sets the third twenty to zero
		THIRTY_PERCENTILE = 1; //sets the thirty to one
		
	}
	
	/**
	 * Returns the ten percentile value of the hare
	 * @return the value that occurs 10 percent of the time the hare moves
	 */
	public int getTen()
	{
		return TEN_PERCENTILE;
	}
	
	/**
	 * Returns the twenty percentile value of the hare
	 * @return the value that occurs 20 percent of the time the hare moves
	 */
	public int getTwenty()
	{
		return TWENTY_PERCENTILE;
	}
	
	/**
	 * Returns the twenty percentile value of the hare
	 * @return the value that occurs 20 percent of the time the hare moves
	 */
	public int getTwenty2()
	{
		return TWENTY_PERCENTILE_2;
	}
	/**
	 * Returns the twenty percentile value of the hare
	 * @return the value that occurs 20 percent of the time the hare moves
	 */
	public int getTwenty3()
	{
		return TWENTY_PERCENTILE_3;
	}
	
	/**
	 * Returns the thirty percentile value of the hare
	 * @return the value that occurs 30 percent of the time the hare moves
	 */
	public int getThirty()
	{
		return THIRTY_PERCENTILE;
	}
	
	public void act()
	{
		super.act();
	}

	
}
