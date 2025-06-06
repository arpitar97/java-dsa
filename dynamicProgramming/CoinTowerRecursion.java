package dynamicProgramming;

public class CoinTowerRecursion {
	
	public static boolean findWinnerNew(int n, int x, int y) {
		
	       if(n==0){
	    	   return false;
	       }
	       
	       boolean ans = false;

	       if(n-y>=0 && ans==false) {
	    	   ans = !findWinnerNew(n-y,x,y);
	       }
 
           if(n-x>=0 && ans==false) {
	    	   ans = !findWinnerNew(n-x,x,y);
	       }
     
          if(n-1>=0 && ans==false) {
	    	   ans = !findWinnerNew(n-1,x,y);
	        }
 
	       return ans;
	       
   }
	    
	  public static String findWinner(int n, int x, int y) {
       
       
         if(x>y){
             int temp=x;
             x=y;
             y=temp;
         }
			
		    boolean ans = findWinnerNew(n,x,y);
		  
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
