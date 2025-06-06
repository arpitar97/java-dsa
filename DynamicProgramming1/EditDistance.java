package dp;

public class EditDistance {
	
	//Time complexity : O(3^Minimum(M,N)) where M and N are length of strings
	//Space complexity : O(Minimum(M,N))
	public static int editDistanceRec(String s1, String s2) {
		
		if(s1.length()==0) {
			return s2.length();
		}
		
		if(s2.length()==0) {
			return s1.length();
		}
		
		if(s1.charAt(0)==s2.charAt(0)) {
			
			return editDistanceRec(s1.substring(1), s2.substring(1));
			
		}
		
		else {
			
			int op1 = 1 + editDistanceRec(s1, s2.substring(1)); //Insert.. is like removing character from other string
			
			int op2 = 1 + editDistanceRec(s1.substring(1), s2.substring(1)); //Replace
			
			int op3 = 1 + editDistanceRec(s1.substring(1), s2); //Delete
			
			return Math.min(op1, Math.min(op2, op3));
		}
	}
	
	//Time complexity : O(M*N)
	//Space complexity : O(M*N)
	private static int editDistanceMem(String s1, String s2, int[][] storage) {
		
		if(s1.length()==0) {
			return s2.length();
		}
		
		if(s2.length()==0) {
			return s1.length();
		}
		
	    int m = s1.length();
		
		int n = s2.length();
		
		if(storage[m][n]!=-1) {
			
			return storage[m][n];
			
		}
		
        if(s1.charAt(0)==s2.charAt(0)) {
			
			storage[m][n] = editDistanceMem(s1.substring(1), s2.substring(1), storage);
			
			return storage[m][n];
			
		}
        
        
        else {
			
			int op1 = 1 + editDistanceMem(s1, s2.substring(1), storage); //Insert.. is like removing character from other string
			
			int op2 = 1 + editDistanceMem(s1.substring(1), s2.substring(1), storage); //Replace
			
			int op3 = 1 + editDistanceMem(s1.substring(1), s2, storage); //Delete

			storage[m][n] = Math.min(op1, Math.min(op2, op3));
			
			return storage[m][n];
			
		}
		
	}
	
	public static int editDistanceMem(String s1, String s2) {
		
		if(s1.length()==0) {
			return s2.length();
		}
		
		if(s2.length()==0) {
			return s1.length();
		}
		
		int m = s1.length();
		
		int n = s2.length();
		
		int[][] storage = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			
			for(int j=0; j<=n; j++) {
				
				storage[i][j] = -1;
				
			}
		}
		
		return editDistanceMem(s1, s2, storage);
		
	}
	
	//Time complexity : O(M*N)
	//Space complexity : O(M*N)
	public static int editDistanceDP(String s1, String s2) {
		
		if(s1.length()==0) {
			return s2.length();
		}
		
		if(s2.length()==0) {
			return s1.length();
		}
		
		int m = s1.length();
		
		int n = s2.length();
		
		int[][] storage = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) { //Filling 1st column
			storage[i][0]=i;
		}
		
		for(int i=0; i<=n; i++) { //Filling 1st row
			storage[0][i]=i;
		}
		
		for(int i=1; i<=m; i++) {
			
			for(int j=1; j<=n; j++) {
				
				if(s1.charAt(m-i)==s2.charAt(n-j)) {
					
					storage[i][j] = storage[i-1][j-1];
					
				}
				
				else {
					
					int a = storage[i-1][j-1];
					
					int b = storage[i-1][j];
					
					int c = storage[i][j-1];
					
					storage[i][j] = 1 + Math.min(a, Math.min(c, b));
					
				}
			}
		}
		
		return storage[m][n];
	}

}
