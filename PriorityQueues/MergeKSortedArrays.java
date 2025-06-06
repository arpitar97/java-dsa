package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class TripletComparator implements Comparator<Triplet>{

	@Override
	public int compare(Triplet o1, Triplet o2) {
		
		if(o1.value<o2.value) {
			return -1;
		}
		
		else {
			return 1;
		}
	}
	
}

class Triplet{
	
	int value;
	int arrayNumber;
	int index;
	
	Triplet(int value, int arrayNumber, int index){
		this.value=value;
		this.arrayNumber=arrayNumber;
		this.index=index;
	}
	
}

public class MergeKSortedArrays {
	
	//Time complexity : O(N*K*logK)
	//Space complexity : O(N*K)
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
		
		if(input.size()==0) {
			return null;
		}
		
		TripletComparator comparator = new TripletComparator();
		
		PriorityQueue<Triplet> minHeap = new PriorityQueue<>(input.size(),comparator);
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=0; i<input.size(); i++) {
			int value = input.get(i).get(0);
			Triplet element = new Triplet(value,i,0);
			minHeap.add(element);
		}
		
		
		while(!minHeap.isEmpty()) {
			Triplet element = minHeap.remove();
			ans.add(element.value);
			int index = element.index;
			int arrayNumber = element.arrayNumber;
			index++;
			if(index<input.get(arrayNumber).size()) {
				Triplet triplet = new Triplet(input.get(arrayNumber).get(index),arrayNumber,index);
				minHeap.add(triplet);
			}
			
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
