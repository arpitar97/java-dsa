package stack;

public class StackUsingLL<T> {

	private Node<T> head;
	private int size;
	
	public StackUsingLL() {
		head=null;
		size=0;
	}
	
	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.next=head;
		head=newNode;
		size++;
	}
	
	public T top() throws StackEmptyException {
		
		if(head==null) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		return head.data;
	}
	
	public T pop() throws StackEmptyException {
		
		if(head==null) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		
		T temp = head.data;
		head=head.next;
		size--;
		return temp;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
}
