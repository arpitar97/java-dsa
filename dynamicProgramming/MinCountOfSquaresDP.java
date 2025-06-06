package dynamicProgramming;

public class MinCountOfSquaresDP {
	
	
	public static int minCount(int n) {
		 
		 if(n==0) {
			 return 0;
		 }
		 
		 int[] storage = new int[n+1];
		 
		 return minCount(storage,n);
		 
	 }
		
		
	private static int minCount(int[] storage,int n) {

		
		storage[1]=1;

		for(int i=2; i<=n; i++) {

			int max = Integer.MAX_VALUE;

			for(int j=1; j<=(int)Math.pow(i,0.5); j++ ){

				int ans = 1 + storage[(i-(int)Math.pow(j,2))];

				if(ans<max){
					max=ans;
				}

			}

           storage[i]=max;

		}
	        
	        return storage[n];
		}

	public static void main(String[] args) {
	
		System.out.println(minCount(700));

	}

}
