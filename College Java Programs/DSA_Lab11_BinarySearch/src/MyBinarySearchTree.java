/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Update: 11-28-18
 * Submitted: 12-04-18
 * Comments: N/A
 * @author Grabriela Hristescu
 * @modified Peter Costantino
 * @version 2018.11.28
 * @param <T>
 * @param <KT>
 */
@SuppressWarnings("unchecked")
public class MyBinarySearchTree<T extends KeyedItem<KT>,
                            KT extends Comparable<? super KT>>
       extends BinaryTreeBasis<T> {
  // inherits isEmpty(), makeEmpty(), getRootItem(), and
  // the use of the constructors from BinaryTreeBasis

  public MyBinarySearchTree() {
  }  // end default constructor

  public MyBinarySearchTree(T rootItem) {
    super(rootItem);
  }  // end constructor

  public void setRootItem(T newItem)
              throws UnsupportedOperationException 
  {
    throw new UnsupportedOperationException();
  }  // end setRootItem

  public void insert(T newItem) 
  {
    root = insertItem(root, newItem);
  }  // end insert  
  
  public T retrieve(KT searchKey)
  {
	  TreeNode<T> cursor = root; //start at the root of the tree	  
	  boolean found = false;
	  T finalItem = null;
	  while(found == false && cursor != null)
	  {
		  T item = cursor.getItem();
		  if(searchKey.compareTo(item.getKey()) == 0) //if equal, we've found it
		  {
			  finalItem = item; //set the found item
			  found = true;
		  }
		  else if(searchKey.compareTo(item.getKey()) < 0) //if less than, go left
		  {
			  cursor = cursor.getLeftChild();
		  }
		  else //if greater, go right
			  cursor = cursor.getRightChild();
	  }
	 return finalItem;
  }  // end retrieve  

  public void delete(KT searchKey) throws TreeException {
    root = deleteItem(root, searchKey);
  }  // end delete

  public void delete(T item) throws TreeException {
    root = deleteItem(root, item.getKey());
  }  // end delete

  protected TreeNode<T> insertItem(TreeNode<T> tNode,
                                   T newItem) {
    TreeNode<T> newSubtree;
    if (tNode == null) {
      // position of insertion found; insert after leaf
      // create a new node
      tNode = new TreeNode<T>(newItem, null, null);
      return tNode;
    }  // end if
    T nodeItem = tNode.getItem();

    // search for the insertion position

    if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
      // search the left subtree
      newSubtree = insertItem(tNode.getLeftChild(), newItem);
      tNode.setLeftChild(newSubtree);
      return tNode;
    }
    else { // search the right subtree
      newSubtree = insertItem(tNode.getRightChild(), newItem);
      tNode.setRightChild(newSubtree);
      return tNode;
    }  // end if
  }  // end insertItem

  
  protected TreeNode<T> deleteItem(TreeNode<T> tNode,
                                   KT searchKey) {
    // Calls: deleteNode.
    TreeNode<T> newSubtree;
    if (tNode == null) {
      throw new TreeException("TreeException: Item not found");
    }
    else {
      T nodeItem = tNode.getItem();
      if (searchKey.compareTo(nodeItem.getKey()) == 0) {
        // item is in the root of some subtree
        tNode = deleteNode(tNode);  // delete the item
      }
      // else search for the item
      else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
        // search the left subtree
        newSubtree = deleteItem(tNode.getLeftChild(), searchKey);
        tNode.setLeftChild(newSubtree);
      }
      else { // search the right subtree
        newSubtree = deleteItem(tNode.getRightChild(), searchKey);
        tNode.setRightChild(newSubtree);
      }  // end if
    }  // end if
    return tNode;
  }  // end deleteItem

  protected TreeNode<T> deleteNode(TreeNode<T> tNode) {
    // Algorithm note: There are four cases to consider:
    //   1. The tNode is a leaf.
    //   2. The tNode has no left child.
    //   3. The tNode has no right child.
    //   4. The tNode has two children.
    // Calls: findLeftmost and deleteLeftmost
    T replacementItem;

    // test for a leaf
    if ( (tNode.getLeftChild() == null) &&
         (tNode.getRightChild() == null) ) {
      return null;
    }  // end if leaf

    // test for no left child
    else if (tNode.getLeftChild() == null) {
      return tNode.getRightChild();
    }  // end if no left child

    // test for no right child
    else if (tNode.getRightChild() == null) {
      return tNode.getLeftChild();
    }  // end if no right child

    // there are two children:
    // retrieve and delete the inorder successor
    else {
      replacementItem = findLeftmost(tNode.getRightChild());
      tNode.setItem(replacementItem);
      tNode.setRightChild(deleteLeftmost(tNode.getRightChild()));
      return tNode;
    }  // end if
  }  // end deleteNode


protected T findLeftmost(TreeNode<T> tNode)  
  {
	  TreeNode search = tNode; //temporary variable we'll use as a cursor to iterate through the tree/subtree
	  while(search.getLeftChild() != null)
	  { search = search.getLeftChild(); } //while we can still move left, move left
	  return (T)search.getItem(); //return the item in the leftmost node
  }  // end findLeftmost

  protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode)
  {
	  TreeNode search = tNode; //temporary variable we'll use as a cursor to iterate through the tree/subtree
	  while(search.getLeftChild().getLeftChild() != null)
  { search = search.getLeftChild(); } //while we can still move left with a left child, move left
	  TreeNode returnVal = search.getLeftChild();
	  search.setLeftChild(null);//wipes the left child
	  return returnVal;
  }  // end deleteLeftmost

}  // end MyBinarySearchTree