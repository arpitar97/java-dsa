package dynamicProgramming;

public class Min_Steps_DP {
	
	
   public static int countMinStepsToOne(int n) {
        
        if(n==1){
            return 0;
        }
	
        int[] storage = new int[n+1];
        
        return countMinStepsToOne(storage,n);
        
	}
    
    public static int countMinStepsToOne(int[] storage,int n){
        
        int ans1 = Integer.MAX_VALUE;
		int ans2 = Integer.MAX_VALUE;
		int ans3 = Integer.MAX_VALUE;
        
        for(int i=2; i<storage.length; i++){
            
        if(i%3==0) {
			ans1 = storage[i/3];
		}
		
		if(i%2==0) {
			ans2 = storage[i/2];
		}
		
	   ans3 = storage[i-1]; 
            
       storage[i]=1+Math.min(ans1, Math.min(ans2, ans3));
            
         ans1 = Integer.MAX_VALUE;
         ans2 = Integer.MAX_VALUE;
		 ans3 = Integer.MAX_VALUE;
            
        }
	  
       return storage[n];
          
    }

}
