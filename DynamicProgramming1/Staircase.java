package dp;

public class Staircase {
	
	//Time complexity : O(3^N)
	//Space complexity : O(N)
	public static long staircaseR(int n) {
		
		if(n==0) {
			return 1;
		}
		
		long first=0;
		long second=0;
		long third=0;
		
		if(n>=1) {
			first = staircaseR(n-1);
		}
		
		if(n>=2) {
			second = staircaseR(n-2);
		}
		
		if(n>=3) {
			third = staircaseR(n-3);
		}
		
		return first+second+third;
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	private static long staircaseM(int n, long[] storage) {
		
		if(n==0) {
			storage[n]=1;
			return storage[n];
		}
		
		if(storage[n]!=0) {
			return storage[n];
		}
		
		long first=0;
		
		long second=0;
		
		long third=0;
		
		if(n>=1) {
			first = staircaseM(n-1,storage);
		}
		
		if(n>=2) {
			second = staircaseM(n-2,storage);
		}
		
		if(n>=3) {
			third = staircaseM(n-3, storage);
		}
		
		storage[n] = first+second+third;
		
		return storage[n];
		
	}
	
	public static long staircaseM(int n) {
		
		if(n==0) {
			return 1;
		}
		
		long[] storage = new long[n+1];
		
		return staircaseM(n,storage);
	}
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static long staircaseDP(int n) {
		
		long[] storage = new long[n+1];
		
		if(n==0) {
			return 1;
		}
		
		if(n==1 || n==1) {
			return n;
		}
		
		storage[0] = 1;
		
		storage[1] = 1;
		
		storage[2] = 2;
		
		for(int i=3; i<=n; i++) {
			
			storage[i] = storage[i-1]+storage[i-2]+storage[i-3];
			
		}
			return storage[n];
	}

	public static void main(String[] args) {
		
		long a = Long.MAX_VALUE;
		System.out.println(a);

	}

}
