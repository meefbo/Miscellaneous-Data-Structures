package classdatabase;

/**
 * 
 * This class represents a node that holds one element and references to two other nodes; its left and right nodes 
 * 
 * @author Cesar Ramos
 * @param <T>
 */
public class TreeNode<T> {
	//Fields
	
	private T element;
	
	private TreeNode<T> left;
	
	private TreeNode<T> right;
	
	//Constructors
	
	/**
	 * Constructs an empty tree node
	 */
	TreeNode(){
		this(null, null, null);
	}
	/**
	 * Constructs a node whose element is occupied by an object passed in as a parameter. Its left and right nodes are empty
	 * @param item
	 */
	TreeNode(T item){
		this(item, null, null);
	}
	/**
	 * Constructs a node whose element is occupied by an object passed in as a parameter. Its left node is passed in as a parameter.
	 * It's right node is empty.
	 * @param item
	 * @param left
	 */
	TreeNode(T item, TreeNode<T> left){
		this(item, left, null);
	}
	/**
	 * Constructs a node whose element is occupied by an object passed in as a parameter. Its left and right nodes are passed in as 
	 * parameters.
	 * @param item
	 * @param left
	 * @param right
	 */
	TreeNode(T item, TreeNode<T> left, TreeNode<T> right){
		this.element = item;
		this.left = left;
		this.right = right;
	}
	
	//Methods
	
	/**
	 * Get the element of the node
	 * @return the element of the node
	 */
	public T getElement() {
		return element;
	}
	/**
	 * Sets the element of the node
	 * @param item
	 */
	public void setElement(T item) {
		element = item;
	}
	/**
	 * Get a reference to the right child node
	 * @return a reference to the right child node
	 */
	public TreeNode<T> getRight() {
		return right;
	}
	/**
	 * Sets the right child node
	 * @param node
	 */
	public void setRight(TreeNode<T> node) {
		right = node;
	}
	/**
	 * Get a reference to the left child node
	 * @return a reference to the left child node
	 */
	public TreeNode<T> getLeft() {
		return left;
	}
	/**
	 * Sets the left child node
	 * @param node
	 */
	public void setLeft(TreeNode<T> node) {
		left = node;
	}
}
