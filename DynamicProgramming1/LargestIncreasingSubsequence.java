package dp;

public class LargestIncreasingSubsequence {
	
	//Time complexity : O(N^2)
	//Space complexity : O(N)
	public static int lcsDP(int[] arr) {
		
		if(arr.length == 0) {
			return 0;
		}
		
		int omax = 0;
		
		int[] dp = new int[arr.length];
		
		dp[0] = 1;
		
		for(int i=0; i<dp.length; i++) {
			
			int max = 0;
			
			for(int j=0; j<i; j++) {
				
				if(arr[i] > arr[j]) {
					
					if(max < dp[j]) {
						
						max = dp[j];
						
					}
					
				}
				
			}
			
			dp[i] = 1 + max;
			
			if(dp[i] > omax) {
				
				omax = dp[i];
				
			}
		}
		
		return omax;
	}

}
