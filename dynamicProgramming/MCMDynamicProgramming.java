package dynamicProgramming;

public class MCMDynamicProgramming {
	

    public static int mcm(int[] p, int sI, int eI, int[][] storage){
        
        
        for(int i=eI-2; i>=0 ;i--){
            
            for(int j=i+2; j<=eI; j++){
                  
            int minCost = Integer.MAX_VALUE;
                
                for(int k=i+1; k<=j-1; k++){
                    
                    int cost = storage[i][k]+storage[k][j]+p[i]*p[k]*p[j];
                    
                    if(cost<minCost){
                        minCost=cost;
                    }
                }
                
                storage[i][j] = minCost;
            }
        }
        
         return storage[0][eI];

	}

	
	public static int mcm(int[] p){
		
     int[][] dp = new int[p.length][p.length];
 
	    return mcm(p,0,p.length-1,dp);

	}

	public static void main(String[] args) {

	}

}
