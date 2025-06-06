package recursion2;

public class PrintSubsetsOfAnArray {
	
	//Time Complexity : O(2^N)
	public static void printSubsets(int input[]) {
	    printSubsets( input,0, new int[0] );
    }
    
    
    public static void printSubsets(int[] input, int sI, int[] ans){
        
        if(sI==input.length){
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }
        
        int[] arr = new int[ans.length+1];

        arr[arr.length-1]=input[sI];
        
        for(int i=0; i<ans.length; i++){
            arr[i]=ans[i];
        }
        
        printSubsets(input,sI+1,ans);
        
        printSubsets(input,sI+1,arr);
        
    }

	public static void main(String[] args) {
		

	}

}
