package expressions;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
	public static void create(ArrayList<Expression> list) throws FileNotFoundException {
		
		File file = new File("testExp.txt");
		Scanner fileScan = new Scanner(file);
		
		while(fileScan.hasNextLine()) {
			list.add(new Expression(fileScan.nextLine()));
		}
	}
	
	public static void displayAndMore(ArrayList<Expression> list) throws FileNotFoundException {
		
		create(list);
		for(Expression exp: list) {
			System.out.println("Testing toPostfix");
			System.out.println("[" + exp.getInfix() + "] as a postfix is [" + exp.toPostfix() + "]");
			System.out.println("Testing evaluate");
			System.out.println("[" + exp.getInfix() + "] evaluates to [" + exp.evaluate() + "]");
		}
		
	}
	
	public static void start() throws FileNotFoundException {
		
		ArrayList<Expression> list = new ArrayList<Expression>();
		create(list);
		displayAndMore(list);
		
	}
	
	
}
