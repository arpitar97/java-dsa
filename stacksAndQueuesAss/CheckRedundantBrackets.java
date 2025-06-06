package stacksAndQueuesAss;

import java.util.Stack;

public class CheckRedundantBrackets {
	
	//Time Complexity : O(N)
	//Space Complexity : O(N)
	public static boolean checkRedundantBrackets(String expression) {
		
		Stack<Character> st = new Stack<>();
		
		int count=0;
		
		if(expression.length()<=1) {
			return false;
		}
		
		for(int i=0; i<expression.length(); i++) {
			
		    count=0;
			
			if(expression.charAt(i)==')') {
				
				while(st.peek()!='(') {
					st.pop();
					count++;
				}
				
				if(count<=1) {
					return true;
				}
				
				st.pop();
				
			}
			
			st.push(expression.charAt(i));
			
		}
		
		return false;
	}

}
