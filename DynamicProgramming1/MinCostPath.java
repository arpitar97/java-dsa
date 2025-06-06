package dp;

public class MinCostPath {
	
	public static int minCostPath(int[][] input) {
		
		if(input.length==0) {
			return Integer.MAX_VALUE;
		}
		
		return minCostPathHelperRec(input,0,0);
		
	}

	//Time complexity : O(3^P) where P=(M*N)
	//Space complexity : O(max(M,N))
	//where M and N are rows and columns of matrix
	private static int minCostPathHelperRec(int[][] input, int i, int j) {
		
		int m = input.length-1;
		
		int n = input[0].length-1;
		
		//Base case
		if(i==m && j==n) {
			return input[i][j];
		}
		
		if(i>m || j>n) {
			return Integer.MAX_VALUE;
		}
		
		int path1 = minCostPathHelperRec(input, i+1, j);
		
		int path2 = minCostPathHelperRec(input, i+1, j+1);
		
		int path3 = minCostPathHelperRec(input, i, j+1);
		
		return input[i][j] + Math.min(path1, Math.min(path2, path3));
		
	}
	
	//Time complexity : O(M*N)
	//Space complexity : O(max(M,N))
	//where M and N are rows and columns of matrix
	private static int minCostPathMem(int[][] input, int i, int j, int[][] storage) {
		
		int m = input.length-1;
		
		int n = input[0].length-1;
		
		//Base case
		if(i==m && j==n) {
			storage[i][j] = input[i][j];
			return storage[i][j];
		}
		
		if(i>m || j>n) {
			return Integer.MAX_VALUE;
		}
		
		if(storage[i][j]!=Integer.MAX_VALUE) {
			return storage[i][j];
		}
		
		int path1 = minCostPathMem(input, i+1, j, storage);
		
		int path2 = minCostPathMem(input, i+1, j+1, storage);
		
		int path3 = minCostPathMem(input, i, j+1, storage);
		
		storage[i][j] = input[i][j] + Math.min(path1, Math.min(path2, path3));
		
		return storage[i][j];
	}
	
	
	//Time complexity : O(M*N)
	//Space complexity : O(max(M,N))
	//where M and N are rows and columns of matrix
	public static int minCostPathDP(int[][] input) {
		
		if(input.length==0) {
			return Integer.MAX_VALUE;
		}
		
		int[][] storage = new int[input.length][input[0].length];
		
		int m = input.length-1;
		
		int n = input[0].length-1;
		
		storage[m][n] = input[m][n];
		
		//Last row fill
		for(int i=n-1; i>=0; i--) {
			storage[m][i]=input[m][i]+storage[m][i+1];
		}
		
		//Last column fill
		for(int i=m-1; i>=0; i--) {
			storage[i][n]=input[i][n]+storage[i+1][n];
		}
		
		for(int i=m-1; i>=0; i--) {
			
			for(int j=n-1; j>=0; j--) {
				
				storage[i][j] = input[i][j] + Math.min(storage[i+1][j], Math.min(storage[i][j+1], storage[i+1][j+1]));
				
			}
		}
		
		return storage[0][0];
	}
	
	public static int minCostPathMem(int[][] input) {
		
		if(input.length==0) {
			return Integer.MAX_VALUE;
		}
		
		int[][] storage = new int[input.length][input[0].length];
		
		for(int i=0; i<storage.length; i++) {
			
			for(int j=0; j<storage[0].length; j++) {
				
				storage[i][j] = Integer.MAX_VALUE;
				
			}
		}
		
		return minCostPathMem(input, 0, 0, storage);
	}

}
