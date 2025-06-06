package dynamicProgramming;

public class TestNoOfBinRec {
	

	public static long balancedBTs(long n){

		if(n==0l || n==1l) {
			return 1l;
		}
	
        int mod = (int)Math.pow(10,9)+7;
		
		long ans1 = (balancedBTs(n-1)*balancedBTs(n-1))%mod;
		
		long ans2 = (balancedBTs(n-1)*balancedBTs(n-2))%mod;
        
        long ans3 = (balancedBTs(n-2)*balancedBTs(n-1))%mod;
		
	    long ans = (ans1+ans2+ans3)%mod;
        
        return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(balancedBTs(9));

	}

}
