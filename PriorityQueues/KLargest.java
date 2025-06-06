package priorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargest {
	
	//Time complexity : O(NlogK)
	//Space complexity : O(K)
	public static ArrayList<Integer> kLargest(int input[], int k) {
		
		int i=0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(; i<k; i++) {
			pq.add(input[i]);
		}
		
		for(; i<input.length; i++) {
			if(pq.peek()<input[i]) {
				pq.remove();
				pq.add(input[i]);
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(!pq.isEmpty()){
			ans.add(pq.remove());
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
