package dynamicProgramming;

public class NoOfBtMemoization {
	
	
	public static long balancedBTs(long n){

		if(n==0l || n==1l) {
			return 1l;
		}
		
	
		long[] storage = new long[(int)(n+1)];
		
		return balancedBTs(storage, n);

	}
	
	
	public static long balancedBTs(long[] storage,long n){

		if(n==0l || n==1l) {
			storage[0]=1l;
			storage[1]=1l;
			return storage[(int) n];
			
		}
		
		if(storage[(int)n]!=0l) {
			return storage[(int)n];
		}
		
		int mod = (int)Math.pow(10,9)+7;
		

		long x = balancedBTs(n-1);
		
		long y = balancedBTs(n-2);
		
		
		long value1 = (x*x)%mod;
	        
	    long value2 = (2*x*y)%mod;

	    long ans = (value1+value2)%mod;
		
	    storage[(int)n]=ans;
	         
	    return storage[(int)n];

	}

	public static void main(String[] args) {

		System.out.println(balancedBTs(7));
	}

}
