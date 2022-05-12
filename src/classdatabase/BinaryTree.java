package classdatabase;

import java.util.ArrayList;

/**
 * 
 * This class represents a binary tree. It is limited to storing objects of classes whose instances can be compared to one another.
 * This is done to maintain the structure of the binary tree, which is as follows: The left child of a root node is LESS THAN the 
 * root node. The right child of a root node is GREATER THAN the root node.
 * 
 * @author Cesar Ramos
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> extends BaseBinaryTree<T> implements BinaryTreeInterface<T>{

	//Fields
	
	//Constructors
	/**
	 * Constructs a binary tree whose root's element is the object passed as a parameter
	 * @param item
	 */
	public BinaryTree(T item) {
		super(item);
	}
	/**
	 * Constructs an empty binary tree
	 */
	public BinaryTree() {
		super();
	}
	/**
	 * Constructs a binary tree whose root's element is the object passed as a parameter
	 * A tree passed in as a parameter is attached at the root node's left child node
	 * Another tree passed in as a parameter is attached at the root node's right child node
	 * This results in a binary tree that is effectively the joining of two other trees 
	 * @param item
	 * @param leftTree
	 * @param rightTree
	 */
	public BinaryTree(T item, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
	
		super(item);
		this.attachLeftSubtree(leftTree);
		this.attachRightSubtree(rightTree);
		
	}
	/**
	 * Constructs a binary tree whose root's element is the object passed as a parameter
	 * @param rootNode
	 */
	protected BinaryTree(TreeNode<T> rootNode) {
		this.root = rootNode;
	}
	
	//Methods
	public void setRoot(T item) {
	
		if(this.root == null) {
			this.root = new TreeNode<T>(item, null, null);
		}
		else root.setElement(item);
		
	}
	
	/**
	 * Checks if this binary tree's root has a left element
	 * @return a boolean representing whether this binary tree's root has a left element or not
	 */
	public boolean hasLeft() {
		return !(this.root.getLeft() == null);
	}
	
	public void attach(T item) {
		BinaryTree<T> tree = new BinaryTree<T>(this.root);
		addToTree(item, tree);
	}
	
	public void attachLeft(T item) {
	
		if(!isEmpty() && this.root.getLeft() == null) {
			this.root.setLeft(new TreeNode<T>(item));
		} else if(isEmpty()) {
			//Tree is empty, can't attach
		} else if(this.root.getLeft() == null) {
			//Left child already exists
		}
		
	}
	/**
	 * Checks if this binary tree's root has a right element
	 * @return a boolean representing whether this binary tree's root has a right element or not
	 */
	public boolean hasRight() {
		return !(this.root.getRight() == null);
	}
	
	public void attachRight(T item) {
		
		if(!isEmpty() && this.root.getRight() == null) {
			this.root.setRight(new TreeNode<T>(item));
		} else if(isEmpty()) {
			//Tree is empty, can't attach
		} else if(this.root.getRight() == null) {
			//Left child already exists
		}
		
	}
	
		//Subtree fun!
	
	public void attachLeftSubtree(BinaryTree<T> leftTree) {
	
		if(isEmpty()) {
			//Empty tree, no good
		}else if (this.root.getLeft() != null) {
			//Left tree here already, can't overwrite
			
			//BEWARE:
			this.detachLeftSubtree().attachLeftSubtree(leftTree);
			this.root.setLeft(leftTree.root);
			
		}else {
			this.root.setLeft(leftTree.root); //attach subtree
			leftTree.makeEmpty(); //nulls out old reference, prevents weird stuff
		}
		
	}
	
	public void attachRightSubtree(BinaryTree<T> rightTree) {
		
		if(isEmpty()) {
			//Empty tree, no good
		}else if (this.root.getRight() != null) {
			//Left tree here already, can't overwrite
			
			//BEWARE:
			this.detachLeftSubtree().attachLeftSubtree(rightTree);
			this.root.setLeft(rightTree.root);
			
		}else {
			this.root.setRight(rightTree.root); //attach subtree
			rightTree.makeEmpty(); //nulls out old reference, prevents weird stuff
		}
		
	}
	
	public BinaryTree<T> detachLeftSubtree() throws TreeException{
		
		BinaryTree<T> leftTree; //output tree
		
		if(isEmpty()) {
			
			throw new TreeException("Tree is empty");
			
		}else if(this.root.getLeft() == null) {
			
			throw new TreeException("No left subtree to detach");
			
		}else {
			leftTree = new BinaryTree<T>(this.root.getLeft());
			this.root.setLeft(null);
			return leftTree;
		}
	}
	
	public BinaryTree<T> detachRightSubtree() throws TreeException{
		
		BinaryTree<T> rightTree; //output tree
		
		if(isEmpty()) {
			
			throw new TreeException("Tree is empty");
			
		}else if(this.root.getRight() == null) {
			
			throw new TreeException("No right subtree to detach");
			
		}else {
			rightTree = new BinaryTree<T>(this.root.getRight());
			this.root.setLeft(null);
			return rightTree;
		}
	}
	/**
	 * Searches the tree for a node containing the sought after item
	 * 
	 * This binary tree is cloned to prevent erroneously changing it's root node.
	 * @param item
	 * @return the node containing the sought after item
	 */
	public TreeNode<T> find(T item){
		BinaryTree<T> tree = new BinaryTree<T>(this.root);
		return search(item, tree);
	}
	
	//Private Methods
	/**
	 * Adds a node containing a specified item to a binary tree. It's position in the tree follows the previously defined structure.
	 * 
	 * To restate that structure: The left child of a root node is LESS THAN that root node. The right child of a root node is 
	 * GREATER THAN that root node
	 * 
	 * This WILL change the tree's root node in the process, it is recommended to pass in a clone of the tree you
	 * wish to alter to prevent unintended data loss. 
	 * 
	 * @param item 
	 * @param tree
	 */
	private void addToTree(T item, BinaryTree<T> tree) {
		
		
		switch(item.compareTo(this.getRoot())) {
		case -1: //Less than
			
			if(tree.hasLeft()) {
				tree.root = tree.getLeft();
				addToTree(item, tree); //recursion here
			}
			else {
				tree.attachLeft(item);
				//FREE TO GO
			}
				
			break;
		case 0: //Equal to
			
			System.out.println("WARNING: Duplicate item not added to tree");
			
			break;
		case 1: //Greater than
			
			if(tree.hasRight()) {
				tree.root = tree.getRight();
				addToTree(item, tree); //recursion here
			}
			else {
				tree.attachRight(item);
				//FREE TO GO
			}
			
			break;
		}
		
	}
	
	
	/**
	 * Seeks a node in a specified binary tree whose element is equal to a specified item. Navigates the tree using the previously
	 * defined structure, with the specified item as the point of comparison.
	 * 
	 * To restate that structure: The left child of a root node is LESS THAN that root node. The right child of a root node is 
	 * GREATER THAN that root node
	 * 
	 * This WILL change the tree's root in the process of this navigation, it is recommended to pass in a clone of the tree you
	 * wish to search to prevent unintended data loss. 
	 * 
	 * Throws an ItemNotFoundException if such a node does not exist.
	 * @param item
	 * @param tree
	 * @return
	 * @throws ItemNotFoundException
	 */
	private TreeNode<T> search(T item, BinaryTree<T> tree) throws ItemNotFoundException{

		TreeNode<T> output;
		
		switch(item.compareTo(tree.getRoot())) {
			case -1: //Less than
				
				if(tree.hasLeft()) {
					tree.root = tree.getLeft();
					output = search(item, tree); //recursion here
				}
				else {
					
					throw new ItemNotFoundException("Item [" + item.toString() + "] not found in tree");
					
				}
					
				break;
				
			case 0: //Equal to
				
				output = tree.root;
				
				break;
				
			case 1: //Greater than
				
				if(tree.hasRight()) {
					tree.root = tree.getRight();
					output = search(item, tree); //recursion here
				}
				else {
					
					throw new ItemNotFoundException("Item [" + item.toString() + "] not found in tree");
					
				}
				
				break;
				
			default: 	
				throw new RuntimeException();
			
		}
		
		return output;
		
	}

	
}
