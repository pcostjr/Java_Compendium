
import java.util.Random; //imports RNG functionality

public abstract class Animal implements Actor
{
	abstract protected int getTen(); //returns the 10 percentile of the animal
	abstract protected int getTwenty(); //returns the 20 percentile of the animal
	abstract protected int getTwenty2(); //returns the 20 percentile of the animal
	abstract protected int getTwenty3(); //returns the 20 percentile of the animal
	abstract protected int getThirty(); //returns the 30 percentile of the animal
	
	private static Random rand = new Random(); //random number generator declaration
	private int position;
	private String name;
	
	/**
	 * Creates a new object of type animal
	 */
	public Animal()
	{
		position = 1;
	}
	
	public Animal(String name)
	{
		position = 1;
		this.name = name;
	}
	
	/**
	 * Returns the current position of the hare
	 */
	public int getPosition()
	{
		return position; //returns the position
	}	
	/**
	 * sets the position of the hare
	 * @param position
	 */
	public void setPosition(int position)
	{
		this.position = position;
	}
	/**
	 * returns the name of the animal
	 * @return the name of the animal
	 */
	public String getName()
	{
		return name; //returns the name of the animal
	}
	/**
	 * Changes or sets the name of the animal
	 * @param name the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}	
	/**
	 * Causes the hare to randomly change position
	 * @param value the value accessed from the random number generator
	 */
	public void act()
	{
		{
		int rng = rand.nextInt(10) + 1; //sets rng to a random number between 1 and 70
		switch (rng)
		{
		case 1: setPosition(getPosition() + getTen()); //10% of the time, the animal falls back 12
				break;
		case 2:
		case 3: setPosition(getPosition() + getTwenty()); //20% of the time, the animal advances 9
				break;
		case 4:
		case 5: setPosition(getPosition() + getTwenty2());
				break; //20% of the time, the animal falls back 2
		case 6:
		case 7: setPosition(getPosition() + getTwenty3());; //20% of the time, the hare does nothing
				break;
		case 8:
		case 9:
		case 10: setPosition(getPosition() + getThirty());; //30% of the time, the hare advances 1
				break;
		default: break;
		}
		if(getPosition() < 1)
			setPosition(1);//ensures no illegal movement
		else if(getPosition() > 70)
			setPosition(70);//ensures no illegal movement
		}			
	}	
}
