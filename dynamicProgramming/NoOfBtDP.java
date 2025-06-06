package dynamicProgramming;

public class NoOfBtDP {
	
	
	public static long balancedBTs(long n){

		if(n==0l || n==1l) {
			return 1l;
		}
		
	
		long[] storage = new long[(int)(n+1)];
		
		return balancedBTs(storage, n);

	}
	
	
	public static long balancedBTs(long[] storage,long n){
		
     	int mod = (int)Math.pow(10,9)+7;

		
		storage[0]=1l;
		storage[1]=1l;

		for(int i=2; i<storage.length; i++) {
			
			long x = storage[i-1];
			
			long y = storage[i-2];
			
			long value1 = (x*x)%mod;
		        
		    long value2 = (2*x*y)%mod;
		    
		    long ans = (value1+value2)%mod;
			
		     storage[i]=ans;
			
		}

	        return storage[(int)n];

	}

	public static void main(String[] args) {
	
		System.out.println(balancedBTs(7));
	
		
		
		
		

	}

}
