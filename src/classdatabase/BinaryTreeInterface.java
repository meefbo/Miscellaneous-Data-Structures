package classdatabase;

/**
 * 
 * This interface contains fundamental methods for classes representing a binary tree.
 * 
 * @author Cesar Ramos
 * @param <T>
 */
public interface BinaryTreeInterface<T extends Comparable<T>> {
	
	/**
	 * Sets the root node's element of this binary tree
	 * @param element
	 */
	public void setRoot(T element);
	/**
	 * Sets the root's right child node to a new node whose element is an object passed in as a parameter 
	 * @param element
	 */
	public void attachRight(T element);
	/**
	 * Sets the root's left child node to a new node whose element is an object passed in as a parameter 
	 * @param element
	 */
	public void attachLeft(T element);
	/**
	 * Sets the root's right child node to the root of another binary tree
	 * @param tree
	 */
	public void attachRightSubtree(BinaryTree<T> tree);
	/**
	 * Sets the root's left child node to the root of another binary tree
	 * @param tree
	 */
	public void attachLeftSubtree(BinaryTree<T> tree);
	/**
	 * Returns a binary tree whose root node is the right child node of this binary tree's root.
	 * Sets this binary tree's root's right child node to null, removing the subtree
	 * @return the right subtree of this binary tree
	 */
	public BinaryTree<T> detachRightSubtree();
	/**
	 * Returns a binary tree whose root node is the left child node of this binary tree's root.
	 * Sets this binary tree's root's left child node to null, removing the subtree
	 * @return the left subtree of this binary tree
	 */
	public BinaryTree<T> detachLeftSubtree();

}

