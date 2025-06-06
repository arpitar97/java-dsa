package stack;
import java.util.Stack;

public class BalancedParenthesis {
	
	//Checking only for () this type of brackets
	//Time complexity : O(N)
	
	public static boolean isBalanced(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			
			if(input.charAt(i)=='(') {
				stack.push(input.charAt(i));
			}
			
			else if(input.charAt(i)==')') {
				if(stack.isEmpty()) {
					return false;
				}
				
				stack.pop();
			}
		}
		
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double a = 10.0/20.5;
		
		double c = 3;
		
		boolean h = c==3;
		
		System.out.println(h);
		
		System.out.println(a);

	}

}
