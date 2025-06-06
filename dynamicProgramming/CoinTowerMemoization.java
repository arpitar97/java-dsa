package dynamicProgramming;

public class CoinTowerMemoization {
	
	public static boolean findWinnerNew(int n, int x, int y, boolean[] dp) {
		
		   if(dp[n]) {
	    	   return dp[n];
	       }
		
	       if(n==0){
	    	   return dp[n]=false;
	       }
	       
 
	       boolean ans = false;
	        
	       if(n-y>=0 && ans==false  ) {
	    	   ans = !findWinnerNew(n-y,x,y,dp);
	       }
	       
	       if(n-x>=0 && ans==false) {
	    	   ans = !findWinnerNew(n-x,x,y,dp);
	    	  
	       }
	       
	       if(n-1>=0 && ans==false) {
	    	   ans = !findWinnerNew(n-1,x,y,dp);
	    
	       }
	      
	       return dp[n]=ans;
	       
		}
	    
	  public static String findWinner(int n, int x, int y) {
		  
		  
		    if(x>y){
	             int temp=x;
	             x=y;
	             y=temp;
	         }
		  
		     boolean[] dp = new boolean[n+1];
			
		    boolean ans = findWinnerNew(n,x,y,dp);
		  
	        if(ans) {
	        	return "Beerus";
	        }
	        
	        else {
	        	return "Whis";
	        }
	        
		}

	public static void main(String[] args) {
		

	}

}
