package queue;

public class QueueUsingArray {
	
	private int[] data;
	private int front;
	private int rear;
	private int size;
	
	public QueueUsingArray() {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public int front() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		
		return data[front];
	}
	
	void enqueue(int element) throws QueueFullException {
		
		if(size==data.length) {
//			throw new QueueFullException();
			doubleCapacity();
		}
		
		if(size==0) {
			front=0;
		}
		
		size++;
		rear=(rear+1)%data.length;
		data[rear]=element;
		
	}
	
	private void doubleCapacity() {
		
		int[] temp = data;
		data = new int[data.length*2];
		int index=0;
		
		for(int i=front; i<temp.length; i++) {
			data[index]=temp[i];
			index++;
		}
		
		for(int i=0; i<front; i++) {
			data[index]=temp[i];
			index++;
		}
		
		front=0;
		rear=temp.length-1;
		
	}

	int dequeue() throws QueueEmptyException {
		
		if(size==0) {
			throw new QueueEmptyException();
		}
		
		int temp = data[front];
		size--;
		front=(front+1)%data.length;
		
		if(size==0) {
			rear=-1;
			front=-1;
		}
		
		return temp;
		
	}

}
