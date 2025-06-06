package pack1;

public class findIntersection {
	
	
	
	public static void intersection(int[] arr1, int[] arr2) {
	    //Your code goes here
    
        mergeSort(arr1,0,arr1.length-1);
        
        
        mergeSort(arr2,0,arr2.length-1);
        
        int i=0;
        
        int j=0;
        
        for(int n=0; n<arr1.length; n++) {
        	
        	 System.out.print(arr1[n] + " ");
        	 
        }
        
        System.out.println();
        
        for(int n=0; n<arr2.length; n++) {
        	
       	 System.out.print(arr2[n] + " ");
  
       }
        
    	 System.out.println();
        
        
        while(i<arr1.length && j<arr2.length){
            
            
           if(arr1[i]==arr2[j]){
               
               System.out.print(arr1[i] + " ");
               
               i++;
               j++;
               
           }
            
           else if(arr1[i]<arr2[j]){
              
               i++;
           }
            
          
           else if(arr1[i]>arr2[j]){
              
               j++;
           }
       
            
        }
        
        
        
	}
    
    
    
    private static void mergeSort(int[] input, int sI, int eI){
        
        if(sI>=eI){           
            return;
        }
        
        int mid=(eI+sI)/2;
        
        mergeSort(input,sI,mid);
        
        mergeSort(input,mid+1,eI);
        
        merge(input,sI,eI);
        
    }
    
    
    private static void merge(int[] input, int sI, int eI){
        
        int mid=(sI+eI)/2;
        
        int[] ans = new int[eI-sI+1];
        
        int i=sI;
        
        int j=mid+1;
        
        int k=0;
        
        while(i<=mid && j<=eI){
            
           if(input[i]<=input[j]){
               
               ans[k]=input[i];
               
               i++;
           }
            
            else{
                
                ans[k]=input[j];
                j++;
                
            }
            
            k++;
        }
        
        while(i<=mid){
            
            ans[k]=input[i];
            i++;
            k++;
            
        }
        
        while(j<=eI){
            
            ans[k]=input[j];
            j++;
            k++;
            
        }
        
        for(int a=0; a<ans.length; a++){
            
            input[a+sI]=ans[a];
            
            
        }
        

        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1, 1, 3, 3, 5, 5};
		
		int[] b = {1, 1, 1, 3, 3, 3, 5, 5};
		
		intersection(a,b);

	}

}
