// Please note that this code is slightly different from the textbook code 
//to reflect the fact that the Node class is implemented using data encapsulation


// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
/**
 * Purpose: Data Structures and Algorithms
 * Status: Not Completed
 * Last Updated: 09/19/281
 * Submitted: N/A
 * @author Gabriela Hristescu
 * @modified Peter Costantino
 * @version 2018.09.19
 *
 */
public class ListReferenceBased implements ListInterface 
{
  private int size;
  private Node tail; 

  public ListReferenceBased() 
  {
    tail = null;
  }  // end default constructor

  public boolean isEmpty() 
  {
     return tail == null || size == 0;
  }  // end isEmpty

  public int size()
  {
	  return size;
  }
  
  private Node find(int index) //this is the updated find
  {
	  Node curr = null;
	  if(index <= size/2)//moving forwards through the first half
	  {
		  curr = tail.getNext();
		  for(int i = 0; i < index; i ++)
		  {
			  curr = curr.getNext();
		  }
	  }
	  else
	  {
		  curr = tail;
		  for(int i = 0; i > size - index; i++) //we can still move forward in the loop because we are using getPrev which requires no index
		  {
			  curr = curr.getPrev();
		  }
	  }
	  return curr;

  } // end find

  public Object get(int index) 
                throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < size) 
    {
      // get reference to node, then data in node
      Node curr = find(index);
      Object dataItem = curr.getItem();
      return dataItem;
    } 
    else 
    {
      throw new ListIndexOutOfBoundsException(
                     "List index out of bounds exception on get");
    } // end if
  } // end get

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index <= size) 
    {    	
      if (isEmpty()) //checks now if the collection is empty 
      {
        // insert the new node containing item at
        // "tail" of list
        Node newNode = new Node(item);
        tail = newNode;
      } 
      else if(index == 0)
      {
    	  Node newNode = new Node(item);
    	  Node oldhead = tail.getNext();
    	  tail.setNext(newNode);
    	  newNode.setPrev(tail);
    	  newNode.setNext(oldhead);
    	  oldhead.setPrev(newNode);
      }
      else 
      {
    	Node newNode = new Node(item); //this is the node we're going to insert
        Node before = find(index - 1); //this is node we need to insert behind
        Node after = before.getNext(); //this is the node we need to insert in front of
        newNode.setPrev(before); //attaches the previous value for the new
        newNode.setNext(after); //attaches the next value for the new
        before.setNext(newNode); //sets new to be the next for before
        after.setPrev(newNode); //sets new to be the previous for after
        if(index == size)
        	tail = newNode; //we find that shit independantly
      } // end if
      size++; //we increment the size
    } 
    else 
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }  // end add

  
  public void remove(int index) 
                   throws ListIndexOutOfBoundsException 
  {
    if (index >= 0 && index < size) 
    { 
      {
        Node delete = find(index); //find the node we need to delete
        delete.getPrev().setNext(delete.getNext());
        delete.getNext().setPrev(delete.getPrev()); //ties the references of the surrounding nodes together, ultimately dereferencing the current node
      } // end if
      size--;//decrement size
    } // end if
    else 
    {
      throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
    } // end if
  }   // end remove

  public void removeAll() 
  {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage 
    // collection
    tail = null;
  } // end removeAll
  
  public String toString()
  {
	  String str = "";
	  Node curr = tail.getNext();//sets us to the head
	  for(int i = 0; i < size; i++)
	  {
		  str = str + curr.getItem().toString() + ",";
		   curr = curr.getNext();
	  }
	  return str;
  }
  

} // end ListReferenceBased