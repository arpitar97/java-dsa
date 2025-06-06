package pack1;

public class QueueUsingLL<T> {
	
	private Node<T> front;
	
	private Node<T> rear;
	
	private int size;
	
	
	public QueueUsingLL() {
		
		front = null;
		
		rear = null;
		
		size = 0;
		
		
	}
	
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		
		return (size==0);
		
	}
	
	public T front() throws QueueEmptyException {
		
		
    if(size==0) {
			
		throw new QueueEmptyException();
			
		}
		
		return front.data;
		
		
	}
	
	public void enqueue(T element) {
		
		Node<T> n1= new Node<>(element);
		
		size++;
		
		if(rear==null) {
			
			front=n1;
			rear=n1;
			return;
		}
		
		rear.next=n1;
		rear=n1;
		
		
	}
	
	public T dequeue() throws QueueEmptyException {
		
		if(size==0) {
			
			throw new QueueEmptyException();
			
		}
		
		T temp = front.data;
		
		front = front.next;
		
		size--;
		
		if(size==0) {
			rear=null;
		}
		
		return temp;
		
		
		
	}
	

}
