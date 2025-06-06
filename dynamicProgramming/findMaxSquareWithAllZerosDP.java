package dynamicProgramming;

public class findMaxSquareWithAllZerosDP {
	
	
     public static int findMaxSquareWithAllZeros(int[][] input){
        
	    if(input==null || input.length==0 ){
            return 0;
        }
    
        int[][] dp = new int[input.length][input[0].length];
        
        int ans=0;
        
        for(int i=input.length-1; i>=0; i--){
            
            
            for(int j=input[0].length-1; j>=0; j--){
                
                if(i==input.length-1){
                    
                    if(input[i][j]==0){
                        dp[i][j]=1;
                    }
                    
                    else{
                        dp[i][j]=0;
                    }
                    
                }
                
                else if(j==input[0].length-1){
                     if(input[i][j]==0){
                        dp[i][j]=1;
                    }
                    
                    else{
                        dp[i][j]=0;
                    } 
                }
                
                else{
                    if(input[i][j]==1){
                        dp[i][j]=0;
                    }
                    
                    else{
                        dp[i][j]=Math.min(dp[i+1][j],Math.min(dp[i][j+1],dp[i+1][j+1]))+1;
                    }
                }
                
                 if(dp[i][j]>ans){
                   ans=dp[i][j];
                 }
      
            }
       
        }
        
        return ans;
	
	}

	public static void main(String[] args) {
		

	}

}
