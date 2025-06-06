package recursion2;

public class PrintSubsetsSumToK {
	
	//Time Complexity : 0(N^2)
	
	public static void printSubsetsSumTok(int input[], int k) {
        
		printSubsetsSumTok(input, k, 0, new int[0]); 
	}
    
    
    private static void printSubsetsSumTok(int input[], int k, int sI, int[] output) {
		
		if(sI==input.length){
            
            if(k==0){
                
                for(int i=0; i<output.length; i++){
                    
                    System.out.print(output[i]+" ");
                }
                
                System.out.println();   
            }
            
            return;
        }
        
        
        int[] smallAns = output;
        
        output=new int[output.length+1];
        
        for(int i=0; i<smallAns.length; i++){
            output[i]=smallAns[i];
        }
        
        output[output.length-1]=input[sI];
        
        printSubsetsSumTok(input, k-input[sI], sI+1, output);
        
        printSubsetsSumTok(input, k, sI+1, smallAns);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
