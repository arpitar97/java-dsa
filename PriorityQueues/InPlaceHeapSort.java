package priorityQueue;

public class InPlaceHeapSort {


	//Time complexity : O(NlogN)
	//Space complexity : O(1)
	public static void heapSort(int[] arr) {
		
		//Insertion or heapFormation
		for(int i=1; i<arr.length; i++) {
			
			int childIndex = i;
			int parentIndex = (childIndex-1)/2;
			
			while(childIndex>0) {
				
				if(arr[childIndex]<arr[parentIndex]) {
					int swap = arr[childIndex];
					arr[childIndex]=arr[parentIndex];
					arr[parentIndex]=swap;
					childIndex=parentIndex;
					parentIndex=(childIndex-1)/2;
				}
				
				else {
					break;
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {

	}

}
