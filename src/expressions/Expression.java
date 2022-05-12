package expressions;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Expression {
	
	//Fields
	
	private String infix;
	private GenericStack<String> stack;
	
	
	//Constructors
	
	Expression(Character[] chars){
		infix = String.valueOf(chars);
		stack = new GenericStack<String>();
	}
	
	Expression(String expression){
		infix = expression;
		stack = new GenericStack<String>();
	}
	
	//Methods
	
	public String getInfix(){
		return this.infix;
	}
	
	public void setInfix(String expression) {
		this.infix = expression.trim();
	}
	
	public String toPostfix() {
		
		StringTokenizer tokens = new StringTokenizer(this.infix, ")(*+-/ ", true); 
		String currentToken;
		String postfix = "";
		
		while(tokens.hasMoreTokens()) {
			
			currentToken = tokens.nextToken();
			if(currentToken.matches("[0-9]")) postfix += currentToken + " ";
			else switch(currentToken) {
				case "(":
					stack.push(currentToken);
					break;
				case "*":
					if(stack.isEmpty()) stack.push(currentToken); else {
						while(!stack.peek().matches("\\(\\+\\-") && !stack.isEmpty()) {
							switch(stack.peek()) {
								case "*":
									postfix += stack.pop() + " ";
									break;
								case "/":
									postfix += stack.pop() + " ";
									break;
							}
						}
						stack.push(currentToken);
					}
					break;
				case ")":
					while(!(stack.peek().matches("\\("))) {
						postfix += stack.pop() + " ";
					}
					if(stack.peek().matches("\\(")) {
						stack.pop();
					}
					break;
				case "/":
					if(stack.isEmpty()) stack.push(currentToken); else {
						while(!stack.peek().matches("\\(\\+\\-") && !stack.isEmpty()) {
							switch(stack.peek()) {
								case "*":
									postfix += stack.pop() + " ";
									break;
								case "/":
									postfix += stack.pop() + " ";
									break;
							}
						}
						stack.push(currentToken);
					}
					break;
				case "+":
					if(stack.isEmpty()) stack.push(currentToken); else {
						while(!(stack.peek().matches("\\(")) && !stack.isEmpty()) {
							switch(stack.peek()) {
								case "*":
									postfix += stack.pop() + " ";
									break;
								case "/":
									postfix += stack.pop() + " ";
									break;
								case "+":
									postfix += stack.pop() + " ";
									break;
								case "-":
									postfix += stack.pop() + " ";
									break;
							}
						}
						stack.push(currentToken);
					}
					break;
				case "-":
					if(stack.isEmpty()) stack.push(currentToken); else {
						while(!stack.peek().matches("\\(") && !stack.isEmpty()) {
							switch(stack.peek()) {
								case "*":
									postfix += stack.pop() + " ";
									break;
								case "/":
									postfix += stack.pop() + " ";
									break;
								case "+":
									postfix += stack.pop() + " ";
									break;
								case "-":
									postfix += stack.pop() + " ";
									break;
							}
						}
						stack.push(currentToken);
					}
					break;
			}
		}
		
		for(int i = 0; i < stack.size(); i++) {
			postfix += stack.pop() + " ";
		}
		
		return postfix;
	}
	
	public double evaluate() {
		
		StringTokenizer tokens = new StringTokenizer(this.toPostfix(), " ", false);
		String currentToken = "";
		GenericStack<String> evalStack = new GenericStack<String>();
		double num1;
		double num2;
		
		while(tokens.hasMoreTokens()) {
			currentToken = tokens.nextToken();
			if(currentToken.matches("[0-9]")) evalStack.push(currentToken);
			else switch(currentToken) {
				case "*":
					num2 = Double.parseDouble(evalStack.pop());
					num1 = Double.parseDouble(evalStack.pop());
					evalStack.push(Double.toString(num1 * num2));
					break;
				case "/":
					num2 = Double.parseDouble(evalStack.pop());
					num1 = Double.parseDouble(evalStack.pop());
					evalStack.push(Double.toString(num1 / num2));
					break;
				case "+":
					num2 = Double.parseDouble(evalStack.pop());
					num1 = Double.parseDouble(evalStack.pop());
					evalStack.push(Double.toString(num1 + num2));
					break;
				case "-":
					num2 = Double.parseDouble(evalStack.pop());
					num1 = Double.parseDouble(evalStack.pop());
					evalStack.push(Double.toString(num1 - num2));
					break;	
			}
		}
		
		return Double.parseDouble(evalStack.peek());

	}
}
