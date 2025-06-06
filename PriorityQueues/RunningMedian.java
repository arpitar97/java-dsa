package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
	
	//Time complexity : O(NlogN)
	//Space complexity : O(N)
	public static void findMedian(int arr[]) {
		
		if(arr.length==0) {
			return;
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<arr.length; i++) {
			
			if(maxHeap.size()==0 && minHeap.size()==0) {
				maxHeap.add(arr[i]);
				System.out.print(arr[i] + " ");
				continue;
			}
			
			if(arr[i]<maxHeap.peek()) {
				maxHeap.add(arr[i]);
			}
			
			else {
				minHeap.add(arr[i]);
			}
			
			if(maxHeap.size()-minHeap.size()>1) {
				minHeap.add(maxHeap.remove());
			}
			
			else if(minHeap.size()-maxHeap.size()>1) {
				maxHeap.add(minHeap.remove());
			}
			
			if((minHeap.size()+maxHeap.size())%2==0) {
				int ans = (minHeap.peek()+maxHeap.peek())/2;
				System.out.print(ans+" ");
			}
			
			else if(minHeap.size()>maxHeap.size()) {
				System.out.print(minHeap.peek()+" ");
			}
			
			else if(maxHeap.size()>minHeap.size()) {
				System.out.print(maxHeap.peek()+" ");
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
