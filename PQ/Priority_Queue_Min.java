package priorityQueues;

import java.util.ArrayList;

public class Priority_Queue_Min {
	
	private ArrayList<Integer> heap;
	
	public Priority_Queue_Min() {
		heap=new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return heap.size()==0;
	}
	
	public int getMin() throws PriorityQueueException {
		
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	public int size() {
		return heap.size();
	}
	
	public void insert(int element) {
		
		heap.add(element);
		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;
		
		while(childIndex>0) {
			
			if(heap.get(childIndex)<heap.get(parentIndex)) {
				int swap=heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, swap);
				childIndex=parentIndex;
				parentIndex=(parentIndex-1)/2;
			}
			
			else {
				return;
			}
			
		}
		
	}
	
	public int removeMin() throws PriorityQueueException {
		
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int value = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		
		heap.remove(heap.size()-1);
		

		int leftChildIndex=1;
		int rightChildIndex=2;
		int index=0;
		int minIndex=0;
		
		while(leftChildIndex<heap.size()) {
			
			if(rightChildIndex<heap.size() && heap.get(rightChildIndex)<heap.get(minIndex)) {
				minIndex=rightChildIndex;
			}
			
			if(heap.get(leftChildIndex)<heap.get(minIndex)) {
				minIndex=leftChildIndex;
			}
			
			if(minIndex==index) {
				break;
			}
			
			int swap = heap.get(index);
			heap.set(index, heap.get(minIndex));
			heap.set(minIndex, swap);
			index=minIndex;
			leftChildIndex=index*2+1;
			rightChildIndex=index*2+2;
			
		}
		
		return value;
	}
	

}
