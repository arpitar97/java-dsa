package stack;

public class StackUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		
		for(int i=1; i<11; i++) {
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			try {
				System.out.print(stack.pop()+" ");
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
