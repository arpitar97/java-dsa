package priorityQueue;
import java.util.PriorityQueue;

public class KthLargestElement {
	
	//Time complexity : O(NlogK)
	//Space complexity : O(K)
	public static int kthLargest(int n, int[] input, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int i=0;
		
		for(; i<k; i++) {
			pq.add(input[i]);
		}
		
		for(; i<input.length; i++) {
			if(input[i]>pq.peek()) {
				pq.remove();
				pq.add(input[i]);
			}
		}
		
		return pq.peek();
	}

}
