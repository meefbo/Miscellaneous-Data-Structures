package expressions;
import java.util.ArrayList;

public class GenericStack<E> implements GenericStackInterface<E> {

	//Fields
	
	private ArrayList<E> storage;
	private int leadingIndex;
	
	//Constructors
	
	/**
	 * Constructs an empty stack populated by a single object passed in
	 * @param item
	 */
	GenericStack(E item){
		
		storage = new ArrayList<E>();
		this.push(item);
		leadingIndex = -1;
		
	}
	/**
	 * Constructs an empty stack populated by the contents of an array
	 * @param items
	 */
	GenericStack(E[] items){
		
		storage = new ArrayList<E>();
		for(E item: items) {
			this.push(item);
		}
		leadingIndex = -1;
		
	}
	/**
	 * Constructs an empty stack
	 */
	GenericStack(){
		storage = new ArrayList<E>();
		leadingIndex = -1;
	}
	
	//Methods
	
	@Override
	public void push(E entry) {
		
		this.storage.add(entry);
		this.leadingIndex++;
		
	}

	@Override
	public E pop() {
		
		E output = this.storage.get(leadingIndex);
		this.storage.remove(leadingIndex);
		this.leadingIndex--;
		
		return output;
	}

	@Override
	public void popAll() {
		
		this.storage.clear();
		this.leadingIndex = -1;

	}

	@Override
	public E peek() {
		
		return this.storage.get(leadingIndex);
		
	}

	@Override
	public boolean isEmpty() {
		
		return this.leadingIndex == -1;
		
	}

	@Override
	public int size() {
		
		return this.leadingIndex + 1;
		
	}

}
