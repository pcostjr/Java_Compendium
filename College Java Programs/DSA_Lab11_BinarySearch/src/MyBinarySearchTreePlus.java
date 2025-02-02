

/**
 * Purpose: Data Structures and Algorithms
 * Status: Completed
 * Last Updated: 11-28-18
 * Submitted: 12-04-18
 * Comments: N/A
 * @author Peter Costantino
 * @version 2018.11.28
 * @param <T>
 * @param <KT>
 */
public class MyBinarySearchTreePlus <T extends KeyedItem<KT>,KT extends Comparable<? super KT>> extends MyBinarySearchTree<T,KT> implements BSTPInterface<T,KT>
{
	public MyBinarySearchTreePlus()
	{
		super();
	}
	
	public MyBinarySearchTreePlus(T rootItem) 
	{
	    super(rootItem);
	}  // end constructor
	
	public void setRootNode(TreeNode<T> node)
	{
		root = node;
	}

	/**
	 * Returns the height of the tree by following several recursive paths until we break off at a null pointer. Then we compare going back up until we find the max
	 * @param node
	 * @return
	 */
	public int getHeight(TreeNode<T> node)
	{
		int sum = 0;
		if(node == null)
			sum = 0;
		else
			sum = Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1;
		return sum;
	}

	
	/**
	 * Returns the size of the tree, adding up every path that we get to similar to getHeight
	 * @param node
	 * @return
	 */
	public int getSize(TreeNode<T> node) 
	{
		int sum = 0;
		if(node == null)
			sum = 0;
		else
			sum += getHeight(node.getLeftChild()) + getHeight(node.getRightChild()) + 1;
		return sum;
	}

	/**
	 * Returns a string representing the tree in order
	 * @param node
	 * @return
	 */
	public String toStringInorder(TreeNode<T> node) 
	{
		String print = "";
		if(node == null)
			print = "";
		else
			print = toStringInorder(node.getLeftChild()) + node.toString() + toStringInorder(node.getRightChild()).toString();
		return print;
	}

	/**
	 * Returns a string representing the tree in preorder
	 */
	public String toStringPreorder(TreeNode<T> node)
	{
		String print = "";
		if(node == null)
			print = "";
		else
			print = node.toString() + toStringPreorder(node.getLeftChild()).toString() + toStringPreorder(node.getRightChild()).toString();
		return print;
	}

	/**
	 * Returns a string representing the tree in post order
	 */
	public String toStringPostorder(TreeNode<T> node) 
	{
		String print = "";
		if(node == null)
			print = "";
		else
			print = toStringPostorder(node.getLeftChild()).toString() + toStringPostorder(node.getRightChild()).toString() + node.toString();
		return print;
	}

	/**
	 * Returns an exact copy of the binary search tree
	 */
	public MyBinarySearchTreePlus<T, KT> getCopyOfTree() 
	{
		MyBinarySearchTreePlus<T, KT> copy = new MyBinarySearchTreePlus<>();
		root = copy(root);
		copy.setRootNode(root);
		return copy;
	}
	
	public TreeNode<T> copy(TreeNode<T> root)
	{
		if(root == null)
			return null;
		else
		{
			TreeNode<T> newRoot = new TreeNode<T>(root.getItem());
			newRoot.setLeftChild(copy(root.getLeftChild()));
			newRoot.setRightChild(copy(root.getRightChild()));
			return newRoot;
		}
	}
	
	
}