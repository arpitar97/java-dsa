package sortingAlgos;

public class BinarySearch {
	
	//Time complexity : O(logN)
	//Space Complexity : O(logN)
	
    public static int binarySearchHelper(int[] input, int sI, int eI, int element) {
    	
    	if(sI>eI) {
    		return -1;
    	}
    	
    	int mid=(sI+eI)/2;
    	
    	if(input[mid]==element) {
    		return mid;
    	}
    	
    	if(element>input[mid]) {
    		return binarySearchHelper(input,mid+1,eI,element);
    	}
    	
    	else {
    		return binarySearchHelper(input,sI,mid-1,element);
    	}
		
	}
	
	
	public static int binarySearch(int[] input, int element) {
		
		return binarySearchHelper(input,0,input.length-1,element);
	}
	
	

}
