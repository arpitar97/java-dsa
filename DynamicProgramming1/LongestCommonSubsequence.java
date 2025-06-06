package dp;

public class LongestCommonSubsequence {
	
	
	//Time complexity : O(2^P) where P = M+N where M =length of string s & N = length of string t
	//Space complexity : O(Max(M,N))
	public static int lcs(String s, String t) {
		
		//Base case
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			return 1 + lcs(s.substring(1), t.substring(1));
		}
		
		else {
			
			int a = lcs( s.substring(1), t ); //Discarding 1st character of string s
			
			int b = lcs( s, t.substring(1) ); //Discarding 1st character of string t
			
			return Math.max(a, b ); //Small calculation
		}
		
	}
	
	//Time complexity : O(M*N)
	//Space complexity  : O(M*N)
	private static int lcsMem(String s, String t, int[][] output) {
		
		int m = s.length();
		
		int n = t.length();
		
		if(m==0|| n==0) {
			return 0;
		}
		
		if(output[m][n]!=-1) {
			return output[m][n];
		}
		
		if(s.charAt(0)==t.charAt(0)) {
			
			output[m][n] = 1 + lcsMem(s.substring(1), t.substring(1), output);
			
			return output[m][n];
		}
		
		else {
			
			int a = lcsMem( s.substring(1), t, output); //Discarding 1st character of string s
			
		    int b = lcsMem( s, t.substring(1), output ); //Discarding 1st character of string t
			
		    output[m][n] = Math.max(a, b); //Small calculation
		
		    return output[m][n];
		 	
		}
		
	}
	
	//Time complexity : O(M*N)
	//Space complexity  : O(M*N)
	//Here the 2-d array stores the lcs and the indexes represent the length of string of s & t
	public static int lcsDP(String s, String t) {
		
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		
        int[][] storage = new int[s.length()+1][t.length()+1];
        
        int m = s.length();
        
        int n = t.length();
		
		for(int i=0; i<=m; i++) {
			storage[i][0] = 0;
		}
		
       for(int i=0; i<=n; i++) {
			storage[0][i] = 0;
	   }
       
       for(int i=1; i<=m; i++) {
    	   
    	   for(int j=1; j<=n; j++) {
    		   
    		   if(s.charAt(i-1) == t.charAt(j-1)) {
    			   
    			   storage[i][j] = 1 + storage[i-1][j-1];
    			   
    		   }
    		   
    		   else {
    			   
    			   int a = storage[i-1][j];
    			   
    			   int b = storage[i][j-1];
    			   
    			   storage[i][j] = Math.max(a, b);
    			   
    		   }
    		   
    	   }
    	   
       }
       
       return storage[m][n];
       
	}
	
	public static int lcsMem(String s, String t) {
		
		if(s.length()==0 || t.length()==0) {
			return 0;
		}
		
		int[][] storage = new int[s.length()+1][t.length()+1];
		
		for(int i=0; i<storage.length; i++) {
			
			for(int j=0; j<storage[0].length; j++) {
				
				storage[i][j]=-1;
				
			}
		}
		
		return lcsMem(s, t, storage);
	}

}
