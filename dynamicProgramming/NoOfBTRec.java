package dynamicProgramming;

public class NoOfBTRec {
	
	
	
	public static long balancedBTs(long n){

		if(n==0l || n==1l) {
			return 1l;
		}
	
        int mod = (int)Math.pow(10,9)+7;
		
		long x = balancedBTs(n-1);
		
		long y = balancedBTs(n-2);
		
	    long value1 = (x*x)%mod;
        
        long value2 = (2*x*y)%mod;

        long ans = (value1+value2)%mod;
        
        return ans;

	}

	public static void main(String[] args) {
		

		System.out.println(balancedBTs(7l));
		
	}

}
