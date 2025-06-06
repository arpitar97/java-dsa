package dp;

public class MinCountOfSquares {
	
	//Time complexity : O(Math.pow(n,0.5)^N)
	//Space complexity : O(N)
	public static int minCountRecursion(int n) {
		
		if(n==0) {
			return 0;
		}
		
		int max = Integer.MAX_VALUE;
		
		for(int i=1; i<=(int)Math.pow(n, 0.5); i++) {
			
			//Recursively finding lowest number of squares
			max =  Math.min(max, 1 + minCountRecursion(n - (int)Math.pow(i, 2)));
			
		}
		
		return max;
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	private static int minCountMem(int n, int[] storage) {
		
		if(n==0) {
			return 0;
		}
		
		if(storage[n]!=0) {
			return storage[n];
		}
		
	    int max = Integer.MAX_VALUE;
		
		for(int i=1; i<=(int)Math.pow(n, 0.5); i++) {
			
			//Recursively finding lowest number of squares
			max =  Math.min(max, 1 + minCountMem(n - (int)Math.pow(i, 2),storage));
			
		}
		
		storage[n] = max;
		
		return storage[n];
		
	}
	
	//Time complexity : O(N * sqrt(N))
	//Space complexity : O(N)
	public static int minCountDP(int n) {
		
		if(n==0) {
			return 0;
		}
		
		int[] storage = new int[n+1];
		
		storage[0] = 0;
		
		storage[1] = 1;
		
		for(int i=2; i<=n; i++) {
			
			storage[i] = Integer.MAX_VALUE;
			
			for(int j=1; i - (j*j)>=0; j++) {
				
				storage[i] = Math.min( storage[i], 1 + storage[i - (j*j)] );
				
			}
			
		}
		
		return storage[n];
	}
	
	public static int minCountMem(int n) {
		
		if(n==0) {
			return 0;
		}
		
		int[] storage = new int[n+1];
		
		return minCountMem(n, storage);
	}
	
	public static void main(String[] args) {
	}

}
