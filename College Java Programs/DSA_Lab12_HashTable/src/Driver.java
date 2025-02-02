import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 11-28-18
 * Submitted: 12-04-18
 * Comments: N/A
 * @author Peter Costantino
 * @version 2018.11.28
 */
public class Driver 
{
	private static HashTable items;
	private static BufferedReader br;
	@SuppressWarnings("unchecked")
	public static void main(String [] args) throws IOException
	{
		items = new HashTable();
		br = new BufferedReader(new InputStreamReader(System.in));
		boolean run = true;
		System.out.println("1. Insert a symbol key with an associated value in the table.\n2. Delete a symbol from the table.\n" + 
		"3. Retrieve and display the value associated with a symbol key in the table.\n4. Display the hash index of a symbol key.\n5. Display String,\n6.Exit Program.");
		while(run)
		{
			int input = Integer.parseInt(br.readLine().trim());
			switch(input)
			{
				case 1:
					insertShell();
					break;
				case 2:
					deleteShell();
					break;
				case 3:
					retrieveShell();
					break;
				case 4:
					hashIndexShell();
					break;
				case 5:
					System.out.println(items.toString());
					break;
				case 6:
					run = false;
					break;
				
			}
		}
	}
	
	public static void insertShell() throws IOException
	{
		System.out.println("Please enter the value you'd like to insert");
		int input = Integer.parseInt(br.readLine().trim());
		System.out.println("Please enter the key you'd like to insert this value under.");
		String stringer = br.readLine().trim();
		System.out.println(items.tableInsert(stringer.substring(0, stringer.length() > 6 ? 6 : stringer.length()), input) == true ? "Value has been inserted." : "Value has not been inserted.");
	}
	
	public static void deleteShell() throws IOException
	{
		System.out.println("Please enter the key of the value you'd like to delete");
		System.out.println(items.tableDelete(br.readLine().trim()) == true ? "Value has been deleted." : "Value does not exist.");
	}
	
	public static void retrieveShell() throws IOException
	{
		System.out.println("Please enter the key of the value you'd like to retrieve");
		Integer value = (Integer)items.tableRetrieve(br.readLine().trim());
		System.out.println(value == null ? "Item not found." : "Value returned: " + value);
	}
	
	public static void hashIndexShell() throws IOException
	{
		System.out.println("Please enter the key you'd like to hash");
		System.out.println("Hash index for key returned = " + items.hashIndex(br.readLine().trim()));
	}
	
	
}
