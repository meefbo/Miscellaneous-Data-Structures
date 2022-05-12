package classdatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * This class represents a database of class sections. The class sections are stored in both an array list and a binary tree.
 * 
 * @author Cesar Ramos
 */
public class ClassDatabase implements ClassDatabaseInterface{
	//Fields
	
	private BinaryTree<Class> classTree;
	private ArrayList<Class> classes;
	
	//Constructors
	/**
	 * Constructs an empty database
	 */
	public ClassDatabase() {
		classes = new ArrayList<Class>();
	}
	/**
	 * Constructs a database from an array list of class sections
	 * @param classList
	 */
	public ClassDatabase(ArrayList<Class> classList) {
		classes = classList;
		classTree = createTree(classes);
	}
	
	//Methods
	
	public void insert(Class newClass) {
		classTree.attach(newClass);
		classes.add(newClass); //check this
	}
	
	public void delete(Class targetClass) throws ItemNotFoundException{
		
		Class currentClass;
		
		for(int i=0; i < classes.size(); i++) {
			
			currentClass = classes.get(i);
			if(currentClass.compareTo(targetClass) == 0) {
				classes.remove(i);
				classes.trimToSize();
				
				classTree = createTree(classes); //Make new tree with the reduced list
				break; 
			} 
			
			//This runs at the last iteration if the class isn't found
			if(i == classes.size() - 1) throw new ItemNotFoundException("Class [" + targetClass + "] not found");
			
		}
		
		
		
	}
	
	public TreeNode<Class> find(Class targetClass) throws ItemNotFoundException{

		BinaryTree<Class> tree = new BinaryTree<Class>(classTree.getRoot());
		
		return tree.find(targetClass);
		
	}
	
	public boolean isEmpty() {
		return classTree.isEmpty();
	}
	
	public void makeEmpty() {
		classTree.makeEmpty();
	}
	
	public LinkedList<Class> sort(){
		
		BinaryTree<Class> tree = new BinaryTree<Class>(classTree.root);
		TreeIterator<Class> iterator = new TreeIterator<Class>(tree);
		LinkedList<Class> output = new LinkedList<Class>();
		
		iterator.setInorder();
		
		while(iterator.hasNext()) {
			output.add(iterator.next());
		}
		
		
		return output;
	}
	
	public int getTotal() {
		return classes.size();
	}
	
	public Class[] toArray() {
		LinkedList<Class> classList = this.sort();
		Class[] output = new Class[this.getTotal()];
		classList.toArray(output);
		
		return output;
		
	}
	
	//Private Methods
	
	/**
	 * Creates a binary tree from an array list of class sections
	 * @param classes
	 * @return a binary tree of the class sections in the array list
	 */
	private BinaryTree<Class> createTree(ArrayList<Class> classes){
		
		Iterator<Class> iterator = classes.iterator();
		Class currentClass = iterator.next();
		
		BinaryTree<Class> output = new BinaryTree<Class>(currentClass);
		BinaryTree<Class> clone = new BinaryTree<Class>(output.root);
		
		
		while(iterator.hasNext()) {
		
			currentClass = iterator.next();
			clone.attach(currentClass);
		}
		
		return output;
	}

	
}