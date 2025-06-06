package dp;

public class O1Knapsack {
	
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		
		if(maxWeight<=0) {
			return 0;
		}
		
		return knapsack(weights, values, n, maxWeight, 0);
		
		
	}
	
	//Time complexity : O(2^N)
	//Space complexity : O(N)
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight, int i) {
		
		if(i==n || maxWeight==0) {
			return 0;
		}
		
		if(weights[i]>maxWeight) {
			
			return knapsack(weights, values, n, maxWeight, i+1);
			
		}
		
		int including = values[i] + knapsack(weights, values, n, maxWeight - weights[i], i+1);
		
		int excluding = knapsack(weights, values, n, maxWeight, i+1);
		
		return Math.max(including, excluding);
	}
	
	public static int knapsackMem(int[] weights, int[] values, int n, int maxWeight) {
		
		if(maxWeight<=0) {
			return 0;
		}
		
		int[][] storage = new int[n+1][maxWeight+1];
		
		for(int i=0; i<storage.length; i++) {
			
			for(int j=0; j<storage[0].length; j++) {
				
				storage[i][j] = -1;
				
			}
		}
		
		return knapsackMem(weights, values, n, maxWeight, 0, storage);
	}

	//Time complexity : O(M*N)
	//Space complexity : O(M*N)
	private static int knapsackMem(int[] weights, int[] values, int n, int maxWeight, int i, int[][] storage) {
		
		int m = maxWeight;
		
		if(i==n || maxWeight==0) {
			
			storage[i][m] = 0;
			
			return storage[i][m];
			
		}
		
		if(storage[i][m] != -1) {
			
			return storage[i][m];
			
		}
		if( weights[i] > maxWeight ) {
			
			storage[i][m] = knapsackMem(weights, values, n, maxWeight, i+1, storage);
			
			return storage[i][m];
			
		}
		
		int including = values[i] + knapsackMem(weights, values, n, maxWeight - weights[i], i+1, storage);
		
		int excluding = knapsackMem(weights, values, n, maxWeight, i+1, storage);
		
		storage[i][m] = Math.max(including, excluding);
		
		return storage[i][m];
		
	}
	
	
	//Time complexity : O(N*M)
	//Space complexity : O(N*M)
	public static int knapsackDP(int[] weights, int[] values, int n, int maxWeight) {
		
		
		int m = maxWeight;
		
		if(maxWeight<=0) {
			return 0;
		}
		
		int[][] storage = new int[n+1][maxWeight+1];
		
		for(int i=1; i<storage.length; i++) {
			
			for(int w=1; w<storage[0].length; w++) {
				
				if(weights[i-1] > w) {
					
					storage[i][w] = storage[i-1][w];
					
				}
				
				else {
					 
					int opt1 = storage[i-1][w];  //Excluding
					
					int op2 = values[i-1] + storage[i-1][w - weights[i-1]]; //Including
					
					storage[i][w] = Math.max(opt1, op2);
				}
				
			}
			
		}
		
		return storage[n][m];
		
	}

}
