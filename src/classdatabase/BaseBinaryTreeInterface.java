package classdatabase;


public interface BaseBinaryTreeInterface<T> {
	
	/**
	 * Checks if the binary tree is empty
	 * @return a boolean representing whether the tree is empty or not
	 */
	public boolean isEmpty();
	/**
	 * Makes the binary tree empty
	 */
	public void makeEmpty();
	/**
	 * Returns the element stored in the root
	 * @return the element stored in the root
	 */
	public T getRoot();
	/**
	 * Sets the element stored in the root
	 * @param item
	 */
	public void setRoot(T item);

}
