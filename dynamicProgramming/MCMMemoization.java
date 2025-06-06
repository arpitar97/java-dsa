package dynamicProgramming;

public class MCMMemoization {
	
    public static int mcm(int[] p, int sI, int eI, int[][] storage){
		
	    if(sI>=eI-1){
           storage[sI][eI] = 0;
        return storage[sI][eI];
        }
     
        int ans=Integer.MAX_VALUE;
        
        if(storage[sI][eI]!=-1){
            return storage[sI][eI];
        }
        
        for(int k=sI+1 ;k<=eI-1; k++){
            
             int temp = mcm(p,sI,k,storage)+mcm(p,k,eI,storage)+(p[sI]*p[k]*p[eI]);
            
             ans=Math.min(temp,ans);
            
        }
        
        storage[sI][eI]=ans;
        return storage[sI][eI];
	}

	
	public static int mcm(int[] p){
		
     int[][] dp = new int[p.length][p.length];
        
     for(int i=0; i<dp.length; i++){
         for (int j=0; j<dp[0].length; j++){
             dp[i][j]=-1;
         }
     }
        
	    return mcm(p,0,p.length-1,dp);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
