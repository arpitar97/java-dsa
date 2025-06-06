package priorityQueues;
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueUse {
	
	
public static int removeMinFromVirtualHeap(int[] arr, int heapSize) {
		
		int swap = arr[0];
		arr[0] = arr[heapSize-1];
		arr[heapSize-1]=swap;
		heapSize--;
		 
	    int index=0;
	    int leftChildIndex=2*index+1;
	    int rightChildIndex=2*index+2;
	    int minIndex=index;
	    
	    while(leftChildIndex<heapSize) {
	    	
	    	if(arr[leftChildIndex]<arr[minIndex]) {
	    		minIndex=leftChildIndex;
	    	}
	    	
	    	if(rightChildIndex<heapSize && arr[rightChildIndex]<arr[minIndex]) {
	    		minIndex=rightChildIndex;
	    	}
	    	
	    	if(minIndex==index) {
	    		break;
	    	}
	    	
	    	int temp = arr[index];
	    	arr[index]=arr[minIndex];
	    	arr[minIndex]=temp;
	    	index=minIndex;
	        leftChildIndex=2*index+1;
		    rightChildIndex=2*index+2;
	    }
		
		
		return swap;
	}

	public static void insertIntoVirtualHeap(int[] arr, int i) {
		
		int childIndex = i;
		int parentIndex = (i-1)/2;
		
		while(childIndex>0) {
			
			if(arr[childIndex]<arr[parentIndex]) {
				int swap = arr[childIndex];
				arr[childIndex]=arr[parentIndex];
				arr[parentIndex]=swap;
				childIndex=parentIndex;
				parentIndex=(parentIndex-1)/2;
			}
			
			else {
				return;
			}
			
		}
		
	}
	
	public static void sortKSorted(int[] arr, int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int i=0;
		
		for(; i<k; i++) {
			pq.add(arr[i]);
		}
		
		for(; i<arr.length; i++) {
			arr[i-k]=pq.remove();
			pq.add(arr[i]);
		}
		
		for(int j=arr.length-k ; j<arr.length ; j++) {
			arr[j]=pq.remove();
		}
		
		
		
		
	}

	public static void main(String[] args) throws PriorityQueueException  {
		
//	
//		int arr[] = {5,1,9,2,0,6};
//		
//		for(int i=0; i<arr.length; i++) {
//			insertIntoVirtualHeap(arr,i);
//		}
//		
//		for(int i = 0; i < arr.length; i++){
//			System.out.print(arr[i] + " ");
//		}
//		
//		System.out.println();
//		
//		for(int i = 0; i < arr.length; i++){
//			arr[arr.length - 1 - i] = removeMinFromVirtualHeap(arr, arr.length - i);
//		}
//		
//		for(int i = 0; i < arr.length; i++){
//			System.out.print(arr[i] + " ");
//		}
//		
//		Priority_Queue_Min pq = new Priority_Queue_Min();
//		
//		for(int i=0; i<arr.length; i++) {
//			pq.insert(arr[i]);
//		}
//
//		while(!pq.isEmpty()) {
//			System.out.print(pq.removeMin()+" ");
//		}
		
		int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6};
		
		sortKSorted(arr,4);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
	
	
       
		
}

	
	
	
	
	
	
}