/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Update: 10/13/2018
 * Submitted: 10/13/2018
 * Comments: N/A
 * @author Gabriela Hristescu
 * @version 2018.10.13
 * @modified Peter Costantino
 */
public interface ListInterface 
{
	boolean isEmpty();
	int size();
	void add(int index, int item) 
               throws IndexOutOfBoundsException;
int get(int index) 
                 throws IndexOutOfBoundsException;
void removeAll();
}  // end ListInterface
