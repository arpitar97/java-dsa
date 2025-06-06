package stacksAndQueuesAss;

import java.util.Stack; 

public class MinimumBracketReversal {
	
	public static int countBracketReversals(String input) {
		
		if(input.length()==0) {
			return 0;
		}
		
		if(input.length()%2!=0) {
			return -1;
		}
		
		Stack<Character> st = new Stack<>();
		
		for(int i=0; i<input.length(); i++) {
			
			char currentChar = input.charAt(i);
			
			if(currentChar=='{') {
				st.push(currentChar);
			}
			
			else {
				if(!st.isEmpty() && st.peek()=='{') {
					st.pop();
				}
				
				else {
					st.push(currentChar);
				}
			}
		}
		
		int count=0;
		
		while(!st.isEmpty()) {
			
			char c1 = st.pop();
			char c2 = st.pop();
			
			if(c1==c2) {
				count+=1;
			}
			
			else {
				count+=2;
			}
		}
		return count;
	}

}
