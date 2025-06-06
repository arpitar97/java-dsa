package dynamicProgramming;

public class Min_Steps_Memoization {
	
	
	public static int countMinStepsToOne(int n) {
		
        int[] storage = new int[n+1];
        
        return countMinStepsToOne(storage,n);
        
	}
    
    public static int countMinStepsToOne(int[] storage,int n){
        
        if(n==1){
            storage[n]=0;
            return storage[n];
        }
        
        if(storage[n]!=0){
            return storage[n];
        }
        
        
        int ans1 = Integer.MAX_VALUE;
		int ans2 = Integer.MAX_VALUE;
		int ans3 = Integer.MAX_VALUE;
		
		if(n%3==0) {
			ans1 = countMinStepsToOne(storage,n/3);
		}
		
		if(n%2==0) {
			ans2 = countMinStepsToOne(storage,n/2);
		}
		
		ans3 = countMinStepsToOne(storage,n-1);
		    
	   storage[n]=1+Math.min(ans1, Math.min(ans2, ans3));
        
       return storage[n];
          
    }

}
