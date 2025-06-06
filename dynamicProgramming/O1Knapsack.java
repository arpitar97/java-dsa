package dynamicProgramming;

public class O1Knapsack {
	
	
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
	       
        if(maxWeight==0){
            return 0;
        }
        
        return knapsack(weights,values,n,maxWeight,0);
		
	}
    
     public static int knapsack(int[] weights, int[] values, int n, int maxWeight, int i) {
       
       if(maxWeight==0 || i==n){
            return 0;
        }
         
        
       if(weights[i]>maxWeight){
           return knapsack(weights,values,n,maxWeight,i+1);
       }
         
       else{
             
            int opt2 = values[i] + knapsack(weights,values,n,maxWeight-weights[i],i+1);
             
            int opt3 = knapsack(weights,values,n,maxWeight,i+1);
             
            int ans = Math.max(opt2,opt3);
             
            return ans;
             
         }
         
	}

	public static void main(String[] args) {
		

	}

}
