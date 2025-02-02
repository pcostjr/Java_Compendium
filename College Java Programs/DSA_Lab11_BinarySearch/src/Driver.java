import java.io.*;
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
	private static MyBinarySearchTreePlus<Item, String> items;
	private static BufferedReader br;
	@SuppressWarnings("unchecked")
	public static void main(String [] args) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		boolean run = true;
		System.out.println("1. Insert key in BST\n2. Delete key from BST\n3. Search for key in BST\n4. Display height of BST\n"
				+ "5. Display size of BST\n6. Display content of BST in inorder\n7. Display content of BST in preorder\n"
				+ "8. Display content of BST in postorder\n9. Build copy of the tree, and test it\n10. Exit program");
		while(run)
		{
			int input = Integer.parseInt(br.readLine().trim());
			switch(input)
			{
				case 1:
					System.out.println("Please enter the item you'd like to insert.");
					Item item = new Item(br.readLine().trim());					
					if(items == null)
					{
						items = new MyBinarySearchTreePlus(item);
						System.out.println("Inserted.");
					}
					else
					{
						System.out.println("Key = " + item.getKey());
						System.out.println("retrieve value = " + items.retrieve(item.getKey()));
				
						if(items.retrieve(item.getKey()) == null)			
						{
							items.insert(item);
							System.out.println("Inserted.");
						}
						else
							System.out.println("Error: that is a duplicate of an existing item.");	
					}
					break;
				case 2:
					System.out.println("Please enter the item you'd like to remove.");
					String remove = br.readLine().trim();
					if(items.retrieve(remove) != null)
					{
						items.delete(remove);
						System.out.println("removed");
					}
					else
						System.out.println("Error: that item doesn't exist.");
					break;
				case 3:
					System.out.println("Please enter the item you'd like to search for.");
					String retrieve = br.readLine().trim();
					Item item1 = items.retrieve(retrieve);
					System.out.println((item1 == null ? "Not found." : "Found " + item1));					
					break;
				case 4:
					System.out.println("Height = " + items.getHeight(items.root));
					break;
				case 5:
					System.out.println("Size = " + items.getSize(items.root));
					break;
				case 6:
					System.out.println("In order representation = " +items.toStringInorder(items.root));
					break;
				case 7:
					System.out.println("Pre order representation = " +items.toStringPreorder(items.root));
					break;
				case 8: 
					System.out.println("Post order representation = " + items.toStringPostorder(items.root));
					break;
				case 9:
					System.out.println("Uncopied Tree:");
					System.out.println("In order representation = " +items.toStringInorder(items.root));
					System.out.println("Pre order representation = " +items.toStringPreorder(items.root));
					System.out.println("Post order representation = " + items.toStringPostorder(items.root));
					System.out.println("Copied!");
					items = items.getCopyOfTree();
					System.out.println("Copied Tree:");
					System.out.println("In order representation = " +items.toStringInorder(items.root));
					System.out.println("Pre order representation = " +items.toStringPreorder(items.root));
					System.out.println("Post order representation = " + items.toStringPostorder(items.root));
					break;
				case 10:
					System.out.println("End of Line.");
					run = false;
					break;
			}
		}
	}
}
