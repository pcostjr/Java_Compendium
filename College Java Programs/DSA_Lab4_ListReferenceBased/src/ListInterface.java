// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
public interface ListInterface 
{
  boolean isEmpty();
  void add(int index, Object item) 
                  throws ListIndexOutOfBoundsException;
  Object get(int index) 
                    throws ListIndexOutOfBoundsException;
 // void remove(int index) 
   //                  throws ListIndexOutOfBoundsException;
  void removeAll();
}  // end ListInterface