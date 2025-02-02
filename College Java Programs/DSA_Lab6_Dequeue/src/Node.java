//please note that this code is different from the textbook code, because the data is encapsulated!
 
public class Node<T> 
{
  private T item;
  private Node next;

  public Node(T newItem) 
  {
    item = newItem;
    next = null;
  } // end constructor

  public Node(T newItem, Node nextNode) 
  {
    item = newItem;
    next = nextNode;
  } // end constructor

  public void setItem(T newItem) 
  {
    item = newItem;
  } // end setItem

  public T getItem() 
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
} // end class Node
