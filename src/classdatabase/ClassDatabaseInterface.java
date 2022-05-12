package classdatabase;

import java.util.LinkedList;
/**
 * This interface contains methods to be used by implementations of the ADT class database. 
 * The ADT class database utilizes the following data structures:
 * 
 * - A list 
 * - A binary tree 
 * 
 * @author Cesar Ramos
 */
public interface ClassDatabaseInterface {
	
	/**
	 * Inserts a class passed in as parameter into the class database
	 * @param newClass
	 */
	public void insert(Class newClass);
	/**
	 * Removes a class from this database's list of classes and reconstructs it's binary tree to reflect this change,
	 * resulting in said class being deleted from the database
	 * 
	 * @param targetClass
	 */
	public void delete(Class targetClass);
	/**
	 * Searches this database's binary tree for a node containing a specified class
	 * @param targetClass
	 * @return the found node 
	 */
	public TreeNode<Class> find(Class targetClass);
	/**
	 * Check if the database is empty
	 * @return a boolean describing whether the database is empty or not
	 */
	public boolean isEmpty();
	/**
	 * Make the database empty
	 * 
	 */
	public void makeEmpty();
	/**
	 * Create a linked list containing the classes in the database in the order they are sorted in the database's binary tree
	 * @return a sorted linked list containing the classes in the database
	 */
	public LinkedList<Class> sort();
	/**
	 * Get the total count of all classes in the database
	 * @return the amount of classes in the database
	 */
	public int getTotal();
	/**
	 * Create an array containing the classes in the database stored in the order they are sorted in the database's binary tree
	 * @return a sorted array containing the classes in the database
	 */
	public Class[] toArray();
}
