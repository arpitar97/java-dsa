package sortingAlgos;

public class QuickSort {
	
	//Time Complexity: Best Case-O(NlogN), Worst Case-O(N^2)
	//Space Complexity : O(1)
	
   public static void quickSort(int[] input, int sI, int eI){
        
        if(sI>=eI){
            return;
        }
        
        int pivot = partition(input,sI,eI);
        quickSort(input,sI,pivot-1);
        quickSort(input,pivot+1,eI);
        
    }
    
    public static int partition(int[] input, int sI, int eI){
        
        int pivotElement = input[sI];
        int count=0;
        
        for(int i= sI+1; i<=eI; i++){
            if(input[i]<pivotElement){
                count++;
            }
        }
        
        if(count!=0){
            int temp=input[sI+count];
            input[sI+count]=input[sI];
            input[sI]=temp;
        }
        
        int i=sI;
        int j=eI;
        int k=sI+count;
        
        
        while(i<k){
            
            if(input[i]<input[k]){
                i++;
            }
            
            else if(input[j]>=input[k]){
                j--;
            }
            
            else{
                int temp=input[i];
                input[i]=input[j];
                input[j]=temp;
                i++;
                j--;
            }
            
        }
        
        return k;
    }
	
	public static void quickSort(int[] input) {
		
        quickSort(input,0,input.length-1);
		
	}

	public static void main(String[] args) {
		
       int [] arr = {3,6,1,0,2,-1,100,7,4};
		
		quickSort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}

	}

}
