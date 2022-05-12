package expressions;
/**
 * 
 * @author Cesar Ramos
 *
 * This is the interface for classes that utilize the functions of the ADT generic stack
 * @param <E>
 */
public interface GenericStackInterface<E> {
	
	/**
	 * This method will add the object passed in to the top of the stack
	 * @param entry
	 */
	public void push(E entry);
	
	/**
	 * This method will remove the object at the top of the stack and return it
	 * @return The object at the top of the stack
	 */
	public E pop();
	
	/**
	 * Empties the stack
	 */
	public void popAll();
	
	/**
	 * This method returns the object at the top of the stack
	 * @return The object at the top of the stack
	 */
	public E peek();
	
	/**
	 * Returns a boolean describing whether the stack is empty or not
	 * @return a boolean describing whether the stack is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the size of the stack
	 * @return the size of the stack
	 */
	public int size();
	
	//Exceptions
	
	public class StackException extends RuntimeException{
		
		StackException(String msg){
			super(msg);
		}
		
	}
	
}
