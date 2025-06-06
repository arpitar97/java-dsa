package dp;

public class BalancedBinaryTrees {
	
	//Time complexity : O(2^N)
	//Space complexity : O(N)
	public static long balancedBTsRec(long n) {
		
		if(n<=1) {
			return 1;
		}
		
		int mod = (int)Math.pow(10,9)+7;
		
		long x = balancedBTsRec(n-1);
		
		long y = balancedBTsRec(n-2);
		
		long temp1 = (x * x) % mod;
		
		long temp2 = (2 * x * y) % mod;
		
		long ans = (temp1 + temp2) % mod;
		
		return ans;
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	private static long balancedBTsMem(long n, long[] storage) {
		
		
		if(n<=1) {
			storage[(int)n]=1;
			return 1;
		}
		
		if(storage[(int)n]!=-1) {
			return storage[(int)n];
		}
		
		int mod = (int)Math.pow(10,9)+7;
		
		long x = balancedBTsMem(n-1,storage);
		
		long y = balancedBTsMem(n-2,storage);
		
		long temp1 = (x * x) % mod;
		
		long temp2 = (2 * x * y) % mod;
		
		long ans = (temp1 + temp2) % mod;
		
		storage[(int)n] = ans;
		
		return storage[(int)n];
		
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static long balancedBTsDP(long n) {
		
		if(n<=1) {
			return 1;
		}
		
	    long[] storage = new long[(int) n + 1];
	    
	    storage[0] = 1;
	   
	    storage[1] = 1;
	    
	    int mod = (int)Math.pow(10,9)+7;
		
		for(int i=2; i<=n; i++) {
			
			long x = storage[i-1];
			
			long y = storage[i-2];
			
			long temp1 = (x * x) % mod;
			
			long temp2 = (2 * x * y) % mod;
			
			long ans = (temp1 + temp2) % mod;
			
			storage[i] = ans;
		}
		
		return storage[(int)n];
	}
	
	public static long balancedBTsMem(long n) {
		
		if(n<=1) {
			return 1;
		}
		
		long[] storage = new long[(int) n + 1];
		
		for(int i=1; i<=n; i++) {
			storage[i]=-1;
		}
		
		return balancedBTsMem(n, storage);
				
	}

}
