package dynamicProgramming;

public class LowestCommonSubsequenceLCSDP {
	
	
	 public static int LCSDP(String a, String b, int[][] storage) {
		 
		 	int m = a.length();
	    	
	    	int n = b.length();
	    	
	    	for(int i=0; i<=n; i++) {
	    		storage[0][i]=0;
	    	}
	    	
	    	for(int i=0; i<=m; i++) {
	    		storage[i][0]=0;
	    	}
	    	
            for(int i=1; i<=m; i++) {
            	
            	for(int j=1; j<=n; j++) {
            		
            		if(storage[i][j]!=-1) {
            			continue;
            		}
            		
            		if(a.charAt(m-i)==b.charAt(n-j)) {
            			storage[i][j]=1+storage[i-1][j-1];
            		}
            		
            		else {
            			storage[i][j]=Math.max(storage[i][j-1], storage[i-1][j]);
            		}
            		
            	}
            	
            }
			
                  return storage[m][n];   
			
		}
	    
	    
	 public static int LCSDP(String a, String b) {
		 
		    int[][] storage = new int[a.length()+1][b.length()+1];
		    
		    for(int i=0; i<=a.length(); i++) {
		    	
		    	for(int j=0; j<=b.length(); j++) {
		    		
		    		storage[i][j]=-1;
		    	}
		    	
		    }
		    
		    return LCSDP(a,b,storage);
			
			
		}

	public static void main(String[] args) {
		
	    String a = "adgeigeigeigeigeigeigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeiigeigeigeigeigeigeigeiggeigeigeigeiggeigeigeigeiggeigeigeigeig";
		
		String b = "abegigeigeivhguigigeigeigeijbeubdkebcksnxiwndwihdjxojxiwhduwhwbciejcihcoiwefhdjqidhjiowhljxoqwjdociwhkjcnncjckhiuwehfiohfiefhhfjebcdcnshjksdbckvbkjdsvbsvbsbjhhegeigeigeigeiggeigeigeigeiggeigeigeigeigi";
		
		System.out.println(LCSDP(a,b));
		
		System.out.println(LowestCommonSubsequenceLCSMemoization.LCSM(a,b));
		
//		System.out.println(LowestCommonSubsequenceLCSMemoization.LCSRec(a,b));
		

	}

}
