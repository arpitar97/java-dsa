package sortingAlgos;

//Time Complexity ; O(N^2)
//Space Complexity : O(1)

public class BubbleSort {
	
    public static void bubbleSort(int[] input) {
    	
    	for(int i=0; i<input.length-1; i++) {
    		
    		for(int j=0; j<input.length-1-i; j++) {
    			
    			if(input[j]>input[j+1]) {
    				
    				int temp = input[j];
    				input[j] = input[j+1];
    				input[j+1] = temp;
    				
    			}
    			
    		}
    		
    	}
		
	}
    
    
 public static void main(String[] args) {
		
		int [] arr = {3,6,1,0,2,-1,100,7,4};
		
		bubbleSort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}

	}

}
