package dynamicProgramming;



public class LowestCommonSubsequenceLCSMemoization {
	
	
public static int LCSRec(String a, String b) {
		
		
		if(a.length()==0 || b.length()==0) {
			return 0;
		}
		
		if(a.charAt(0)==b.charAt(0)) {
			return 1+ LCSRec(a.substring(1),b.substring(1));
		}else {
			int opt1 = LCSRec(a,b.substring(1));
			
			int opt2 = LCSRec(a.substring(1),b);
			
			return Math.max(opt1, opt2);
		}
		
	}

    public static int LCSM(String a, String b, int[][] storage) {
    	
    	int m = a.length();
    	
    	int n = b.length();
    	
		
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		
		
		if(m==0 || n==0) {
			 storage[m][n]=0;
			 return storage[m][n];
		}

		
		if(a.charAt(0)==b.charAt(0)) {
			
			storage[m][n] = 1+ LCSM(a.substring(1),b.substring(1),storage);
			return storage[m][n];
			
		}
		
		else {
			int opt1 = LCSM(a,b.substring(1),storage);
			
			int opt2 = LCSM(a.substring(1),b,storage);
			
			storage[m][n] = Math.max(opt1, opt2);
			
			return storage[m][n];
		}
		
	}
    
    
 public static int LCSM(String a, String b) {
	 
	    int[][] storage = new int[a.length()+1][b.length()+1];
	    
	    for(int i=0; i<=a.length(); i++) {
	    	
	    	for(int j=0; j<=b.length(); j++) {
	    		
	    		storage[i][j]=-1;
	    	}
	    	
	    }
		
		return LCSM(a,b,storage);
	
		
	}

	public static void main(String[] args) {
		
		String a = "adgeigeigeigeigeigeigeigeigei";
		
		String b = "abegigeigeivhguigigeigeigeijhhei";
		
		System.out.println(LCSM(a,b));
		
		System.out.println(LCSRec(a,b));
		
		

	}

}
