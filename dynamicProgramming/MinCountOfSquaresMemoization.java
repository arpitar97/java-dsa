package dynamicProgramming;

public class MinCountOfSquaresMemoization {
	
	
 public static int minCount(int n) {
	 
	 if(n==0) {
		 return 0;
	 }
	 
	 int[] storage = new int[n+1];
	 
	 return minCount(storage,n);
	 
 }
	
	
  private static int minCount(int[] storage,int n) {
		
        if(n==0){
            return storage[0];
        }
        
        if(storage[n]!=0) {
        	return storage[n];
        }
        
        
        int max = Integer.MAX_VALUE;
        
        for(int i=1; i<=(int)Math.pow(n,0.5); i++ ){
        
           int ans = 1 + (int)minCount(n-(int)Math.pow(i,2));
            
           if(ans<max){
               max=ans;
           }
            
        }
        
        storage[n]=max;
        
        return storage[n];
	}

	public static void main(String[] args) {
		
		System.out.println(minCount(70));

	}

}
