package stacksAndQueuesAss;
import java.util.Stack;

public class ReverseAStack {
	
	//Time Complexity : O(N^2)
	//Space Complexity : O(N)
	
	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		
		if(input.size()<=1) {
			return;
		}
		
		int element = input.pop();
		
		reverseStack(input,extra);
		
		while(!input.isEmpty()) {
			extra.push(input.pop());
		}
		
		input.push(element);
		
		while(!extra.isEmpty()) {
			input.push(extra.pop());
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
