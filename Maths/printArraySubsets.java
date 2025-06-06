package pack1;

public class printArraySubsets {
	
	public static void printSubsets(int input[]) {
		// Write your code here
        printSubsets(input,new int[0],0);

	}
    
    private static void printSubsets(int[] input, int[] fAns, int sI){
        
        if(sI==input.length){
            
            for(int i=0; i<fAns.length; i++){
                System.out.print(fAns[i]+" ");
            }
            
            System.out.println();
            return;
        }
     
        
        int[] smallAns = fAns;
        
        fAns = new int[fAns.length+1];
        
        for(int i=0; i<smallAns.length; i++){
            fAns[i]=smallAns[i];
        }
        
        fAns[fAns.length-1]=input[sI];
        
        printSubsets(input,smallAns,sI+1);
        
        printSubsets(input,fAns,sI+1);
        
        
    }

	public static void main(String[] args) {
		

	}

}
