package dynamicProgramming;

public class MCMRecursion {
	
	
   public static int mcm(int[] p, int sI, int eI){
		
	    if(sI>=eI-1){
        return 0;
        }
     
        int ans=Integer.MIN_VALUE;
   
        for(int k=sI+1 ;k<=eI-1; k++){
            
             int temp = mcm(p,sI,k)+mcm(p,k,eI)+(p[sI]*p[k]*p[eI]);
            
             ans=Math.max(temp,ans);
            
        }
        
        return ans;
	}

	
	public static int mcm(int[] p) {
        
	    return mcm(p,0,p.length-1);

	}

	public static void main(String[] args) {

		int[] arr = {40,20,30,10,30};
		
		System.out.println(mcm(arr));
		
		
	}

}
