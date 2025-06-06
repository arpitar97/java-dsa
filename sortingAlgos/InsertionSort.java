package sortingAlgos;

public class InsertionSort {
	
	//Time Complexity : O(n^2)
	//Space Complexity : O(1)
	
	public static void insertionSort(int[] input) {
		
		int n = input.length;
		
		
		for(int i=1; i<n; i++) {
			
			int j = i-1;
			int temp=input[i];
			
			while(j>=0 && temp < input[j]) {
				input[j+1]=input[j];
				j--;
			}
			
			input[j+1]=temp;
		}
	}
	
	
    public static void main(String[] args) {
		
		int [] arr = {3,6,1,0,2,7,4};
		
		insertionSort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}

	}
	
	
	
	
}
