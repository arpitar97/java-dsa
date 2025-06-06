package dynamicProgramming;

public class O1KnapsackMemoization {
	
	public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][] storage = new int[n+1][maxWeight+1];
      
        for(int i=0; i<=n; i++){
            for(int j=0; j<=maxWeight; j++){
                storage[i][j]=-1;
            }
            
        }
            
            return knapsack(weight,value,n,maxWeight,0,storage);
            
        }
      
     public static int knapsack(int[] weight,int[] value,int n,int maxWeight,int i,int[][] storage){
          
          int m = maxWeight;
          
          if(i==n || m==0){
              storage[i][m]=0;
              return storage[i][m];
          }
          
          if(storage[i][m]!=-1){
              return storage[i][m];
          }
          
          if(weight[i]>maxWeight){
         storage[i][m] = knapsack(weight,value,n,maxWeight,i+1,storage);
              return storage[i][m];
         }
       
     else{
           
         int opt2 = value[i] + knapsack(weight,value,n,maxWeight-weight[i],i+1,storage);
    
         int opt3 = knapsack(weight,value,n,maxWeight,i+1,storage);
           
         storage[i][m] = Math.max(opt2,opt3);
           
              return storage[i][m];
           
        }
          
          
          
      }

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
