package dynamicProgramming;

public class O1KnapsackDP {
	
	   public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

	        int[][] storage = new int[n+1][maxWeight+1];
	        
	        for(int i=0; i<=n; i++) {
	        	storage[i][0]=0;
	        }
	        
	        for(int i=0; i<=maxWeight; i++) {
	        	storage[n][i]=0;
	        }
	            
	        return knapsack(weight,value,n,maxWeight,storage);
	            
	        }
	      
	     public static int knapsack(int[] weight,int[] value,int n,int maxWeight,int[][] storage){
	          
	          int m = maxWeight;
	          
	          for(int i=n-1; i>=0; i--) {
	        	  
	        	  for(int w=1; w<=m; w++ ) {
	        		  
	        		  if(weight[i]>w) {
	        			  storage[i][w]=storage[i+1][w];
	        		  }
	        		  
	        		  else {
	        			  storage[i][w]=Math.max(storage[i+1][w], value[i]+storage[i+1][w-weight[i]]);
	        		  }
	        	  }
	        	  
	          }
	          
	          return storage[0][m];
	      
	      }


	public static void main(String[] args) {
		

	}

}
