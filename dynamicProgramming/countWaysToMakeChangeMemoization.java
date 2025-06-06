package dynamicProgramming;

public class countWaysToMakeChangeMemoization {
	
	
	  public static int countWaysToMakeChange(int denominations[], int value, int index, int[][] storage){
	        
		     if(index>=denominations.length || value<0){
		            return 0;
		        }
		        
		        if(value==0){
		        storage[index][value]=1;
		         return storage[index][value];   
		        }
		        
		        if(storage[index][value]!=-1){
		            return storage[index][value];
		        }
		         
		 return storage[index][value]=countWaysToMakeChange(denominations,value,index+1,storage)+
		     countWaysToMakeChange(denominations,value-denominations[index],index,storage);
		   
		    }

			
			public static int countWaysToMakeChange(int denominations[], int value){
		        
		        if(denominations.length==0){
		            return 0;
		        }
		        
		        int[][] dp = new int[denominations.length][value+1];
		        
		        for(int i=0; i<dp.length; i++){
		            
		            for(int j=0; j<dp[0].length; j++){
		                dp[i][j]=-1;
		            }
		        }
		        
		        
		        return countWaysToMakeChange(denominations,value,0,dp);
			}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
