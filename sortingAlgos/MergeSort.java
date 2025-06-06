package sortingAlgos;

public class MergeSort {
	
	//Time Complexity : O(NlogN)
	//Space Complexity : O(N)
	
	public static void mergeSort(int[] input, int sI, int eI) {
		
		//Base Case
		if(sI>=eI) {
			return;
		}
		
		int mid = (sI+eI)/2;
		
		mergeSort(input,sI,mid);
		
		mergeSort(input,mid+1,eI);
		
		merge(input,sI,eI);
		
	}
	
	private static void merge(int[] input, int sI, int eI) {
		
		
		int[] ans = new int[eI-sI+1];
		
		int mid = (sI+eI)/2;
		
		int i=sI;
		int j=mid+1;
		int k=0;
		
		while(i<=mid && j<=eI) {
			
			if(input[i]<input[j]) {
				ans[k]=input[i];
				i++;
			}
			
			else {
				ans[k]=input[j];
				j++;
			}
			
			k++;
			
		}
		
		while(i<=mid) {
			ans[k]=input[i];
			i++;
			k++;
		}
		
		while(j<=eI) {
			ans[k]=input[j];
			j++;
			k++;
		}
		
		for(int index=0; index<ans.length; index++) {
			input[sI+index]=ans[index];
		}
		
	}
	
	  public static void main(String[] args) {
			
			int [] arr = {3,6,1,0,2,7,4,-1,100};
			
			mergeSort(arr,0,arr.length-1);
			
			for(int i : arr) {
				System.out.println(i);
			}

		}
	
	

}
