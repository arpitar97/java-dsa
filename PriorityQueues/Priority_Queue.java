package priorityQueue;
import java.util.ArrayList;


//Minimum Priority Queue
//Time complexity for insert, delete is O(logN), Space complexity : O(1)
public class Priority_Queue {
	
	private ArrayList<Integer> heap;
	
	public Priority_Queue() {
		heap = new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return heap.size()==0;
	}
	
	public int size() {
		return heap.size();
	}
	
	//Time complexity : O(1)
	int getMin() throws PriorityQueueException {
		
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		return heap.get(0);
	}
	
	//Time complexity : O(logN)
	void insert(int element) {
		
		heap.add(element);
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex>0) {
			
			if(heap.get(childIndex)<heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			
			else {
				return;
			}
		}
		
	}
	
	
	//Time complexity : O(logN)
	int removeMin() throws PriorityQueueException {
		
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int ans = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		
		heap.remove(heap.size()-1);
		
		//Heapify-Down
		
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		int index = 0;
		int minIndex = index;
		
		while(leftChildIndex<heap.size()) {
			
			if(heap.get(minIndex)>heap.get(leftChildIndex)) {
				minIndex=leftChildIndex;
			}
			
			if( rightChildIndex<heap.size() && heap.get(rightChildIndex)<heap.get(minIndex)) {
				minIndex = rightChildIndex;
			}
			
			if(minIndex==index) {
				break;
			}
			
			else {
				int value = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, value);
				index = minIndex;
				leftChildIndex = 2*index+1;
				rightChildIndex = 2*index+2;
			}
			
		}
		
		return ans;
		
	}
	
	
	
	

}
