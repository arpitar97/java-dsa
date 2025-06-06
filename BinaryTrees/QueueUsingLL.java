

public class QueueUsingLL<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public QueueUsingLL(){
		head=null;
		tail=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public T front() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		
		return head.data;
	}
	
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		size++;
		
		if(size==1) {
			head=newNode;
			tail=newNode;
			return;
		}
		
		tail.next=newNode;
		tail=newNode;
	}
	
	public T dequeue() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();	
		}
		
		T temp=head.data;
		head=head.next;
		size--;
		if(size==0) {
			tail=null;
		}
		return temp;
	}
	
	

}
