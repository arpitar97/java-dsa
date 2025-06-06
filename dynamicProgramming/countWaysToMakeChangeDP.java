package dynamicProgramming;

public class countWaysToMakeChangeDP {
	
	
	 public static int countWaysToMakeChange(int denominations[], int value){
		 
		 int n=denominations.length;
        
		 int[][] dp = new int[denominations.length][value+1];
		 
		 for(int i=0; i<n; i++) {
			 dp[i][0]=1;
		 }
	  
		 for(int i=n-1; i>=0; i--) {
			 
			 int count1=0;
			 int count2=0;
			 
			 for(int j=1; j<=value; j++) {
				
				 if(i<n-1) {
					 count1 = dp[i+1][j];
			     }
				 
				 if(j>=denominations[i]) {
				    count2 = dp[i][j-denominations[i]]; 
				 }
				 
				 dp[i][j] = count1+count2;
				 
			 }
		}
		 
		 return dp[0][value];
	         
	    }

		
	

	public static void main(String[] args) {
		

	}

}
