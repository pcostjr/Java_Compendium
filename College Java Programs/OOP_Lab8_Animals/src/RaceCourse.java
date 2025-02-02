

/**
 * The race course for the Tortoise and the Hare
 * @author Peter Costantino
 * @version 02-05-18
 *
 */
public class RaceCourse 
{
	/**
	 * Displays a single, 70 character line determining the position of the hare and the tortoise
	 * @param hPos the position of the hare
	 * @param tPos the position of the tortoise
	 */
	public void display(int hPos, int tPos)
	{
		for(int count = 1; count <=70; count++)
		{
			if(count == hPos && count == tPos)
				System.out.print("Ooof!");//prints out a message if the hare and tortoise have "collided"
			else if(count == tPos)
				System.out.print("1"); //prints out the symbolic notation for the tortoise
			else 
				if(count == hPos)
					System.out.print("2"); //prints out the symbolic notation for the rabbit
			else
				System.out.print(" ");//otherwise, prints out an empty space
		}
		System.out.println(""); //indents to split up display lines
	}

}
