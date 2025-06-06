package dp;

public class CoinTower {
	
	
	//dp[i] represents whether Beerus will win provided that "i" coins are remaining and it is Beerus' turn.
    //If Beerus will win in that scenario, dp[i] will be true otherwise it will be false.
	
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static String findWinnerDP(int n, int x, int y) {
		
		boolean[] dp = new boolean[n+1];
		
		dp[0] = false;
		
		// for i>1 && i<x
		for(int i=1; i<=n; i++) {
			
			if(i==1 || i==x || i==y) {
				dp[i] = true;	
			}
			
			else if(i<x){
				dp[i] =  !dp[i-1];
			}
			
			else if(i>x && i<y) {
				dp[i] = !(dp[i-1] && dp[i-x]);
			}
			
			else {
				dp[i] = !(dp[i-1] && dp[i-x] && dp[i-y]);
			}
			
		}
		
		boolean result = dp[n];
		
		if(result) {
			return "Beerus";
		}
		
		else {
			return "Whis";
		}
	}
	
	//Memoization
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static int findWinnerMem(int n, int x, int y, int[] dp) {
		
		if(n==0) {
			dp[n] = 0;
			return dp[n];
		}
        
        if(n==1 || n==x || n==y) {
			dp[n] = 1;
			return dp[n];
		}
		
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		int ans = 1;
	
		if(n-y>=0 && ans==1) {
			
			ans = findWinnerMem(n-y, x, y, dp);
			
			if(ans == 0) {
				dp[n] = 1;
			}
		}
		
		if(n-x>=0 && ans==1) {
			
            ans = findWinnerMem(n-x, x, y, dp);
			
			if(ans == 0) {
				dp[n] = 1;
			}
		}
		
        if(n-1>=0 && ans==1) {
			
            ans = findWinnerMem(n-1, x, y, dp);
			
			if(ans == 0) {
				dp[n] = 1;
			}
		}
		
		if(ans==1){
            dp[n]=0;
		}
        
        return dp[n];
	}
	
	//Recursive
	//Time complexity : O(3^N)
	//Space complexity : O(N)
	public static boolean findWinnerRecHelper(int n, int x, int y) {
		
		if(n==0) {
			return false;
		}
        
        if(n==1 || n==x || n==y) {
			return true;
		}
		

		boolean ans = false;
	
		if(n-y>=0 && !ans) {
			
			ans = !findWinnerRecHelper(n-y, x, y);
			
		}
		
		if(n-x>=0 && !ans) {
			
            ans = !findWinnerRecHelper(n-x, x, y);
			
		}
		
        if(n-1>=0 && !ans) {
			
            ans = !findWinnerRecHelper(n-1, x, y);
			
		}
        
        return ans;
	}
	
    public static String findWinnerRec(int n, int x, int y) {
		
    	if(n==0) {
    		return null;
    	}

    	boolean ans = findWinnerRecHelper(n, x, y);

    	if(ans) {
    		return "Beerus";
    	}

    	if(!ans) {
    		return "Whis";
    	}

    	return "Not correct";

    }
	
	
    public static String findWinnerMem(int n, int x, int y) {
		
    	if(n==0) {
    		return null;
    	}

    	int[] dp = new int[n+1];

    	for(int i=0; i<=n; i++) {
    		dp[i]=-1;
    	}

    	int ans = findWinnerMem(n, x, y, dp);

    	if(ans==1) {
    		return "Beerus";
    	}

    	if(ans==0) {
    		return "Whis";
    	}

    	return "Not correct";

    }

}
