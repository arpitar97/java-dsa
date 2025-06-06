package dynamicProgramming;

public class EditDistanceDP {
	
	
	public static int editDistance(String s1, String s2, int[][] storage){
		  
	    int m = s1.length();
	    
	    int n = s2.length();
     
	    for(int i=0; i<=n; i++) {
	    	storage[0][i]=i;
	    }
	    
	    for(int i=0; i<=m; i++) {
	    	storage[i][0]=i;
	    }
	    
	    
	    for(int i=1; i<=m; i++) {
	    	
	    	for(int j=1; j<=n; j++) {
	    		
	    		if(s1.charAt(m-i)==s2.charAt(n-j)) {
	    			storage[i][j]=storage[i-1][j-1];
	    		}
	    		
	    		else {
	    			storage[i][j]=1+Math.min(storage[i-1][j-1], Math.min(storage[i][j-1], storage[i-1][j]));
	    			
	    		}
	    		
	    	}
	    	
	    }
       
          return storage[m][n];
	}
	
  
  
    public static int editDistance(String s1, String s2){
      
      
    	int[][] storage = new int[s1.length()+1][s2.length()+1];
    	
    	return editDistance(s1,s2,storage);
  

	}

	public static void main(String[] args) {
	
		

	}

}
