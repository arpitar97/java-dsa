package dynamicProgramming;

public class countWaysToMakeChangeDPBetter {
	
	
	public static int countWaysToMakeChange(int denominations[], int value){
        
	
		
		int[] dp = new int[value+1];
		
		dp[0]=1;
		
		
		for(int i=0; i<dp.length; i++) {
				
			for(int j=denominations[i]; j<=value; j++) {
				
	            dp[j]+=dp[j-denominations[i]];   			
				
			}
		}
		
		return dp[value];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
