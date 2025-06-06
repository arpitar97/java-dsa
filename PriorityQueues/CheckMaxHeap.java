package priorityQueue;

public class CheckMaxHeap {
	
	//Time complexity : O(N)
	//Space complexity : O(1)
	public static boolean checkMaxHeap(int arr[]) {
		
		for(int i=0; i<arr.length; i++) {
			
			int leftChild = 2*i+1;
			int rightChild=2*i+2;
			
			if(leftChild<arr.length && arr[leftChild]>arr[i] ) {
				return false;
			}
			
            if(rightChild<arr.length && arr[rightChild]>arr[i] ) {
				return false;
				
			}
		}
		
		return true;
	}

}
