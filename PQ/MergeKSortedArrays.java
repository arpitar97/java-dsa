//package priorityQueues;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.ArrayList;
//import java.util.Collections;
//
//class PairComparator implements Comparator<Pair>{
//
//	@Override
//	public int compare(Pair p1, Pair p2) {
//		
//		if(p1.value<=p2.value) {
//			return 1;
//		}
//		
//		else {
//			return -1;
//		}
//	}
//
//
//}
//
//class Pair{
//	
//	int value;
//	int arrayNumber;
//	
//	Pair(int v, int n){
//		value=v;
//		arrayNumber=n;
//	}
//	
//}
//
//public class MergeKSortedArrays {
//	
//	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input){
//		
//		if(input.size()==0) {
//			return null;
//		}
//		
//	PairComparator compare = new PairComparator();	
//		
//	PriorityQueue<Pair> maxHeap = new PriorityQueue<>(input.size(),compare);
//	
//	for(int i=0; i<input.size(); i++) {
//		
//		int index = input.get(i).size()-1;
//		Pair p = new Pair(input.get(i).get(index),i);
//		maxHeap.add(p);
//		input.get(i).remove(index);
//		
//	}
//	
//	ArrayList<Integer> output = new ArrayList<>();
//	
//	while(!maxHeap.isEmpty()) {
//		
//		Pair max = maxHeap.remove();
//		int i = max.arrayNumber;
//		output.add(max.value);
//		
//		if(input.get(i).size()>0) {
//			
//			int index=input.get(i).size()-1;
//			int value=input.get(i).get(index);
//			Pair current = new Pair(value,i);
//			maxHeap.add(current);
//			input.get(i).remove(index);
//			
//		}
//		
//	}
//	
//	Collections.reverse(output);
//	return output;
//		
//	}
//
//	public static void main(String[] args) {
//
//	}
//
//}
