
/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 11/03/2018
 * Submitted 11/03/2018
 * Comments: Dual Truth value for lexicographic search. Holds boolean and an integer position
 * @version 2018.11.03
 * @author Peter Costantino *
 */
public class DualValue 
{
	private boolean bool;
	private int value;
	
	/**
	 * Default constructor for DualValue
	 */
	public DualValue()
	{
		stv(false);
		setValue(0);
	}
	
	/**
	 * Paramaterized constructor for DualValue
	 * @param bool
	 * @param value
	 */
	public DualValue(boolean bool, int value)
	{
		this.stv(bool);
		this.setValue(value);
	}

	/**
	 * Gets the truth value of boolean
	 * @return
	 */
	public boolean gtv() {
		return bool;
	}
	
	/**
	 * sets the truth value of boolean
	 * @param bool
	 */
	public void stv(boolean bool) {
		this.bool = bool;
	}

	/**
	 * gets the int value
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * sets the int value
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
