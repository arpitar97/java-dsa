package sortingAlgos;

public class SelectionSort {
	
	//Time Complexity : O(n^2)
	//Space Complexity : O(1)
	
	public static void selectionSort(int[] input) {
		
		int n = input.length;
		
		for(int i=0; i<n-1; i++) {
			
			int min = input[i];
			int minIndex=i;
			
			for(int j=i; j<n ; j++) {
				
				if(input[j]<min) {
					min = input[j];
					minIndex=j;
				}
			}
			
			if(i!=minIndex) {
				input[minIndex]=input[i];
				input[i]=min;
			}
		}
		
	}

	public static void main(String[] args) {
		
		int [] arr = {3,6,1,2,7,4};
		
		selectionSort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}

	}

}
