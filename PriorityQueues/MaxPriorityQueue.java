package priorityQueue;

import java.util.ArrayList;

public class MaxPriorityQueue {
	
	private ArrayList<Integer> maxHeap;
	
	public MaxPriorityQueue() {
		maxHeap=new ArrayList<>();
	}
	
	public int size() {
		return maxHeap.size();
	}
	
	public boolean isEmpty() {
		return maxHeap.size()==0;
	}
	
	//Time complexity : O(1)
	int getMax() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return maxHeap.get(0);
	}
	
	//Upward heapify
	//Time complexity : O(logN)
	void insert(int element) {
		
		maxHeap.add(element);
		int childIndex = maxHeap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex>0) {
			
			if(maxHeap.get(childIndex)>maxHeap.get(parentIndex)) {
				int swap = maxHeap.get(childIndex);
				maxHeap.set(childIndex, maxHeap.get(parentIndex));
				maxHeap.set(parentIndex, swap);
				childIndex=parentIndex;
				parentIndex=(childIndex-1)/2;
			}
			
			else {
				return;
			}
			
		}
	}
	
	//Down heapify
	//Time complexity : O(logN)
	int removeMax() throws PriorityQueueException {
		
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		
		int ans = maxHeap.get(0);
		maxHeap.set(0, maxHeap.get(maxHeap.size()-1));
		maxHeap.remove(maxHeap.size()-1);
		
		int index = 0;
		int maxIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;
		
		while(leftChildIndex<maxHeap.size()) {
			
			
			if(maxHeap.get(leftChildIndex)>maxHeap.get(maxIndex)) {
				maxIndex = leftChildIndex;
			}
			
			if(rightChildIndex<maxHeap.size() && maxHeap.get(rightChildIndex)>maxHeap.get(maxIndex)) {
				maxIndex=rightChildIndex;
			}
			
			if(maxIndex==index) {
				break;
			}
			
			else {
				int value = maxHeap.get(index);
				maxHeap.set(index, maxHeap.get(maxIndex));
				maxHeap.set(maxIndex, value);
				index=maxIndex;
				leftChildIndex = 2*index+1;
				rightChildIndex = 2*index+2;
				
			}
		}
		
		return ans;
	}

}
