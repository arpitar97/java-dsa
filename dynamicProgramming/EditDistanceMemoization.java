package dynamicProgramming;

public class EditDistanceMemoization {
	
  public static int editDistance(String s1, String s2, int[][] storage){
	  
	    int m = s1.length();
	    
	    int n = s2.length();
        
        if(m==0){
        	
        	storage[m][n]=n;
        	
            return storage[m][n];
        }
        
        if(n==0){
            
        	storage[m][n]=m;
        	
            return storage[m][n];
        }
        
        if(storage[m][n]!=-1) {
        	return storage[m][n];
        }
        
        if(s1.charAt(0)==s2.charAt(0)){
           storage[m][n]=editDistance(s1.substring(1),s2.substring(1));
           return storage[m][n];
        }
        
        else{
            
            int opt1 = editDistance(s1,s2.substring(1));
            
            int opt2 = editDistance(s1.substring(1),s2);
            
            int opt3 = editDistance(s1.substring(1),s2.substring(1));
            
            storage[m][n] = 1 + Math.min(opt1,Math.min(opt2,opt3));
            
            return storage[m][n];

            
        }

	}
  
  
    public static int editDistance(String s1, String s2){
      
      
    	int[][] storage = new int[s1.length()+1][s2.length()+1];
    	
    	for(int i=0; i<storage.length; i++) {
    		
    		for(int j=0; j<storage[0].length; j++) {
    			
    			storage[i][j]=-1;
    		}
    	}
    	
    	return editDistance(s1,s2,storage);
  

	}

	public static void main(String[] args) {
		
		System.out.println(editDistance("Zeil","trial"));

		
	}

}
