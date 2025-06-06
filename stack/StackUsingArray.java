package stack;

public class StackUsingArray {
	
	//push,pop,top,isEmpty,size
	
	private int[] data;
	private int top; //index of top element of stack
	
	public StackUsingArray() {
		data = new int[10];
		top=-1;
	}
	
	public StackUsingArray(int capacity) {
		data = new int[capacity];
		top=-1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public int top() throws StackEmptyException {
		
		if(size()==0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		return data[top];
	}
	
	public int pop() throws StackEmptyException {
		
		if(size()==0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		int temp = data[top];
		top--;
		return temp;
		
	}
	
	public void push(int element) throws StackFullException {
		
		if(size() == data.length) {
//			StackFullException e = new StackFullException();
//			throw e;
			doubleCapacity();
		}
		
		top++;
		data[top]=element;
	}

	private void doubleCapacity() {
		
		int[] temp = data;
		
		data = new int[data.length*2];
		
		for(int i=0; i<temp.length; i++) {
			data[i]=temp[i];
		}
		
	}
	

}
