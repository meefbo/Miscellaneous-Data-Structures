package classdatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Helper {
	public static ClassDatabase create(ArrayList<Class> list) throws FileNotFoundException {
		
		File file = new File("testClassDb.txt");
		Scanner fileScan = new Scanner(file);
		String currentLine;
		String[] holder = new String[5];
		
		while(fileScan.hasNextLine()) {
			
			currentLine = fileScan.nextLine();
			holder = currentLine.split(",");
			list.add(new Class(Integer.parseInt(holder[0]), holder[1], Integer.parseInt(holder[2]), holder[3], holder [4]));
			
			
		}
		
		return new ClassDatabase(list);
			
		}
	
	public static void displayAndMore(ClassDatabase database) {
		
		
		System.out.println("The database's contents:");
		System.out.println("-------------------BEGIN-------------------");
		displayDatabase(database);
		System.out.println("------------------- END -------------------");
		
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		
		System.out.println("(!) Testing insert:");
		System.out.println();
		System.out.println("Inserting class '1234 ABCD 123 Title Level' ");
		database.insert(new Class(1234, "ABCD", 123, "Title", "Level"));
		
		System.out.println("The database's new contents:");
		System.out.println("-------------------BEGIN-------------------");
		displayDatabase(database);
		System.out.println("------------------- END -------------------");
		
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		
		System.out.println("(!) Testing delete:");
		System.out.println();
		System.out.println("Removing class '1234 ABCD 123 Title Level' ");
		database.delete(new Class(1234, "ABCD", 123, "Title", "Level"));
		
		System.out.println("The database's new contents:");
		System.out.println("-------------------BEGIN-------------------");
		displayDatabase(database);
		System.out.println("------------------- END -------------------");
		
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		
		System.out.println("(!) Testing find:");
		System.out.println();
		System.out.println("Looking for class '0000 AAAA 000 Test Undergraduate' ");
		Class desiredClass = new Class(0, "AAAA", 0, "", "");
		System.out.println("Class found: ");
		System.out.println(database.find(desiredClass).getElement().toString());
		
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		
		System.out.println("(!) Testing sort:");
		System.out.println();
		System.out.println("Sorted list:");
		
		Iterator<Class> sortedIterator = database.sort().iterator();
		while(sortedIterator.hasNext()) {
			System.out.println(sortedIterator.next());
		}
		
		System.out.println();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println();
		
		System.out.println("(!) Testing emtpy:");
		System.out.println();
		System.out.println("is database empty?: " + database.isEmpty());
		System.out.println("emptying...");
		database.makeEmpty();
		System.out.println("is database empty?: " + database.isEmpty());
		
		
	}
	
	public static void start() throws FileNotFoundException {
		ArrayList<Class> list = new ArrayList<Class>();
		displayAndMore(create(list));
	}
	
	private static void displayDatabase(ClassDatabase database) {
		
		for(Class currentClass: database.sort()) {
			System.out.println(currentClass.toString());
		}
		
		
	}
	
	}
	