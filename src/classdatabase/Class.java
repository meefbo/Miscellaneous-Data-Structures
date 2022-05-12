package classdatabase;

/**
 * This class represents a class section. A class section has a class number, a subject, a catalog number, a title, and a level.
 * 
 * Yes, the name of the class is a little careless. I'll admit, some refactoring is in order.
 * 
 * @author Cesar Ramos
 */
public class Class implements Comparable<Class>{
	
	//Fields
	
	private final int classNum;
	private final String subject;
	private final int catalogNum;
	private final String title;
	private final String level;
	
	//Constructors
	/**
	 * Creates a class with a specified class number, subject, catalog number, title, and level
	 * @param classNum
	 * @param subject
	 * @param catalogNum
	 * @param title
	 * @param level
	 */
	public Class(int classNum, String subject, int catalogNum, String title, String level) {
		this.classNum = classNum;
		this.subject = subject;
		this.catalogNum = catalogNum;
		this.title = title;
		this.level = level;
	}

	//Methods
	
	/**
	 * Gets this class section's class number
	 * @return this class section's class number
	 */
	public int getClassNum() {
		return classNum;
	}
	/**
	 * Gets this class section's subject
	 * @return this class section's subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * Gets this class section's catalog number
	 * @return this class section's catalog number
	 */
	public int getCatalogNum() {
		return catalogNum;
	}
	/**
	 * Gets this class section's title
	 * @return this class section's title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Gets this class section's level
	 * @return this class section's level
	 */
	public String getLevel() {
		return level;
	}
	
	public String toString() {
		return Integer.toString(classNum) + " " + subject + " " + Integer.toString(catalogNum) + " " + title + " " + level;
	}

	public int compareTo(Class other) {
		//-1 means less than
		//0 means equals
		//1 means greater than
		if(this.classNum < other.getClassNum()) return -1;
		else if(this.classNum == other.getClassNum()) return 0;
		else if(this.classNum > other.getClassNum()) return 1;
		else throw new RuntimeException("Classes could not be compared");
	}
	
	
}
