package sortingAlgos;

public class QuickSortBetter {
	
    public static void quickSort(int[] input) {
		
		quickSort(input,0,input.length-1);
	}
    
    private static void quickSort(int[] input, int sI, int eI){
        
        if(sI>=eI){
            return;
        }
        
        int pivotPos = partition(input,sI,eI);
        
        quickSort(input,sI,pivotPos-1);
        
        quickSort(input,pivotPos+1,eI);
         
        
    }
    
    private static int partition(int[] input, int sI, int eI){
        
        int pivot=input[eI];
        
        int i=sI-1;
        
        for(int j=sI; j<eI; j++){
        
            if(input[j]<=pivot){
                i++;
                swap(input,i,j);
            }
            
        }

        swap(input,i+1,eI);
        
        return i+1;
        
    }
    
    private static void swap(int[] input , int i, int j){
        
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        
    }

}
