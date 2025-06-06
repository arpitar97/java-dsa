package pack1;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class StackUse {

	public static void main(String[] args) {
		
		
		Stack<Integer> s1 = new Stack<>();
		
		s1.push(6);
		
		s1.push(1);
		
		s1.push(10);
		
		s1.push(100);
		
		Stack<Integer> s2 = new Stack<>();
		
		while(!s1.isEmpty()) {
			
			int temp = s1.pop();
			
			s2.push(temp);
			
		}
		
		while(!s2.isEmpty()) {
			
			System.out.println(s2.pop());
			
			
		}
		
		Queue<Integer> q1 = new LinkedList<>();
		
		System.out.println(q1.size());
		
	
		
		

	}

}
