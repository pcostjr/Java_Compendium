//please note that this code is different from the textbook code, because the data is encapsulated!
 
public class Node 
{
  private Object item;
  private Node prev;
  private Node next;

  public Node(Object newItem) 
  {
	  item = newItem;
	  next = this; //we initialize it as circular in case the node is ever placed into a single object array
	  prev = this; //we can easily have it reference the front and back, which is itself.
  } // end constructor

  public void setItem(Object newItem) 
  {
    item = newItem;
  } // end setItem

  public Object getItem() 
  {
    return item;
  } // end getItem

  public void setNext(Node nextNode) 
  {
    next = nextNode;
  } // end setNext

  public Node getNext() 
  {
    return next;
  } // end getNext
  
  public void setPrev(Node prevNode)
  {
	  prev = prevNode;
  }
  
  public Node getPrev()
  {
	  return prev;
  }
} // end class Node