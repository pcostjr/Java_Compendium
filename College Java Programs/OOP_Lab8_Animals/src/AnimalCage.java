
import java.util.HashMap;
/**
 * An array of "Animal Cages" that will assign a given animal to a student's name.
 * @author Peter Costantino
 * @version 02-06-18
 */
public class AnimalCage
{
	private HashMap<String, Animal> cageMap; //the map that will store cage values
	
	/**
	 * Creates an object of type AnimalCage
	 */
	public AnimalCage()
	{
		cageMap = new HashMap<>(); //initializes the map
	}

	/**
	 * Adds a animal to the animalcage, with a corresponding owner's name
	 * @param name the name of the owner
	 * @param animal the name of the animal
	 */
	public void addHare(String contestant,String animal)
	{
		cageMap.put(contestant, new Hare(animal)); //puts a animal with the specified name in the map with the owner's name as a key
	}
	/**
	 * Adds a animal to the animalcage, with a corresponding owner's name
	 * @param name the name of the owner
	 * @param animal the name of the animal
	 */
	public void addTortoise(String contestant,String animal)
	{
		cageMap.put(contestant, new Tortoise(animal)); //puts a animal with the specified name in the map with the owner's name as a key
	}
	
	/**
	 * Returns the corresponding owner's animal
	 * @param name the name of the owner
	 * @return the animal
	 */
	public Animal getAnimal(String name)
	{
		return cageMap.get(name); //returns the animal corresponding to the key		
	}
}
