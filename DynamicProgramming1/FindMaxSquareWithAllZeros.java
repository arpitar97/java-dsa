package dp;

public class FindMaxSquareWithAllZeros {
	
	//Time complexity : M*N
	//Space complexity : M*N
	public static int findMaxSquareWithAllZeros(int[][] input) {
		
		 if(input==null || input.length == 0 || input[0].length == 0) {	
				return 0;
			}
			
			int max = 0;
			
			int[][] dp = new int[input.length][input[0].length]; //It stores the size of max square ending at i,j with all 0's
			
			for(int i=0; i<input.length; i++) {
				
				if(input[i][0]==1) {	
					dp[i][0]=0;			
				}
				
				else {
					dp[i][0]=1;
					max = 1;
				}
					
			}
			
	        for(int i=0; i<input[0].length; i++) {
	        	
	        	if(input[0][i]==1) {
					dp[0][i]=0;	
				}
				
				else {	
					dp[0][i]=1;
	                max = 1;
				}
				
			}
	        
			for(int i=1; i<dp.length; i++) {
				
				for(int j=1; j<dp[0].length; j++) {
					
					if(input[i][j]==1) {
						dp[i][j]=0;		
					}
					
					else {
						dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));	
						
						if(dp[i][j]>max) {
							max=dp[i][j];
						}
					}	
				}
			}
			
			return max;
		
	}

}
