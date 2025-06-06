package pack1;

public class StackUsingLL<T> {
	
	private Node<T> head;
	
	private int size;
	
	public StackUsingLL() {
		this.head=null;
		this.size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public T peek() throws StackEmptyException {
		
		if(size==0) {
			throw new StackEmptyException();
		}
		
		return head.data;
		
	}
	
	public void push(T elem) {
		
		Node<T> newNode = new Node<>(elem);
		newNode.next=head;
		head=newNode;
		size++;
			
	}
	
	public T pop() throws StackEmptyException {
		
		if(size==0) {
			throw new StackEmptyException();
		}
		
		T temp = head.data;
		head=head.next;
		size--;
		return temp;
		
	}
	
	

}
