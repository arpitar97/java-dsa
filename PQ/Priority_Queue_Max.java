package priorityQueues;

import java.util.ArrayList;



public class Priority_Queue_Max {
	
	private ArrayList<Integer> heap;
	
	public Priority_Queue_Max() {
		heap=new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return heap.size()==0;
	}
	
	public int size() {
		return heap.size();
	}
	
	public int getMax() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	public void insert(int element) {
		heap.add(element);
		
		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;
		
		while(childIndex>0) {
			
			if(heap.get(childIndex)>heap.get(parentIndex)) {
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
	
	public int removeMax() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int value = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		
		heap.remove(heap.size()-1);
		
		int index=0;
		int maxIndex=index;
		int leftChildIndex=1;
		int rightChildIndex=2;
		
		while(leftChildIndex<heap.size()) {
			
			if(rightChildIndex<heap.size() && heap.get(rightChildIndex)>heap.get(maxIndex)) {
				maxIndex=rightChildIndex;
			}
			
			if(heap.get(leftChildIndex)>heap.get(maxIndex)) {
				maxIndex=leftChildIndex;
			}
			
			if(maxIndex==index) {
				break;
			}
			
			int swap = heap.get(index);
			heap.set(index, heap.get(maxIndex));
			heap.set(maxIndex, swap);
			index=maxIndex;
			leftChildIndex=index*2+1;
			rightChildIndex=index*2+2;
			
		}
			
		
		return value;
	}

}
