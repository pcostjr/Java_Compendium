import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; //imports arraylist functionality from java.util

/**
 * Controller Unit for the Hare and Tortoise classes *
 */
public class Controller 
{
	public static RaceCourse viewCourse = new RaceCourse(); //sets up the course
	public static void main(String [] args)//main method declaration
	{
		ArrayList<String> contestants = new ArrayList<>(); //creates an arraylist for all contestants
		
		AnimalCage animalcage = new AnimalCage(); //sets up the animal cage
		animalcage.addHare("Jerry", "Speedy");
		animalcage.addTortoise("Jimbo", "Greg");
		contestants.add("Jerry");
		contestants.add("Jimbo");
		run(contestants.get(0), contestants.get(1), animalcage);
	}
	
	/**
	 * Facilitates our race between the hare and the tortoise, and displays appropriate win conditions
	 */
	private static void run(String contest1, String contest2, AnimalCage animalcage)
	{
		System.out.println("BANG!"); //beginning message
		System.out.println("Uh Oh Spaghetti-O, they're off!"); //embedded dank meme
		while(animalcage.getAnimal(contest1).getPosition() < 70 && animalcage.getAnimal(contest2).getPosition() < 70) //so long as neither creature has one the race yet
		{
			animalcage.getAnimal(contest1).act(); //call the act method of the first contestant's animal
			animalcage.getAnimal(contest2).act(); //then the act method of the second contestant's animal
			viewCourse.display(animalcage.getAnimal(contest1).getPosition(), animalcage.getAnimal(contest2).getPosition()); //then display their positions
		}
		System.out.println(animalcage.getAnimal(contest1).getPosition() == 70 ? contest1 + " has won!" : contest2 + " has won!"); //determines the winner
	}
}
