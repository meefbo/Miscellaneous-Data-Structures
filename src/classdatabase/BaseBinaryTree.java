package classdatabase;

/**
 * 
 * This class represents the base of a binary tree. Unlike its child class, the binary tree, this class' methods can only
 * alter the data stored in the binary tree by emptying the entire tree. This provides a limited access that may be useful
 * 
 * @author Cesar Ramos
 * @param <T>
 */
public abstract class BaseBinaryTree<T> implements BaseBinaryTreeInterface<T> {

	//Fields
	
	protected TreeNode<T> root;
	
	//Constructors
	/**
	 * Constructs a base binary tree whose root's element is the passed in object
	 * @param item
	 */
	BaseBinaryTree(T item){
		root = new TreeNode<T>(item, null, null);
	}
	/**
	 * Constructs an empty base binary tree
	 */
	BaseBinaryTree(){
		this(null);
	}
	
	//Methods
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void makeEmpty() {
		root = null;
	}

	@Override
	public T getRoot() {
		
		if(root == null) throw new TreeException("Tree is empty");
		return root.getElement();
	}
	
	/**
	 * Returns the left child node of the binary tree's root node.
	 * The binary tree cannot be empty.
	 * @return the left child node of the binary tree's root node
	 */
	public TreeNode<T> getLeft() {
		
		if(root == null) throw new TreeException("Tree is empty");
		return root.getLeft();
	}
	/**
	 * Returns the right child node of the binary tree's root node.
	 * The binary tree cannot be empty.
	 * @return the right child node of the binary tree's root node
	 */
	public TreeNode<T> getRight() {
		
		if(root == null) throw new TreeException("Tree is empty");
		return root.getRight();
	}

	//Abstracts
	/**
	 * Would change the binary tree's root's element, but this isn't supported for base binary trees. 
	 */
	public abstract void setRoot(T newItem) throws UnsupportedOperationException;
}
