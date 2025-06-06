package dynamicProgramming;

public class StairCaseDP {
	
	
	 public static long Staircase(long[] storage,int n){
		 
		    storage[0]=1l;
	        
	        for(int i=1; i<storage.length; i++) {
	        	
	            long ans1=0l;
		        long ans2=0l;
		        long ans3=0l;
	        	
	        	
	            if(i>=3){
		            ans1 = storage[i-3];
		        }
		        
		        if(i>=2){
		            ans2 = storage[i-2];
		        }
		        
		        if(i>=1){
		            ans3 = storage[i-1];
		        }
		        
		        storage[i]=ans1+ans2+ans3;
	        	
	        }

	        return storage[n]; 
	        
	    }

		public static long staircase(int n) {
	        
	        if(n==0){
	            return 1l;
	        }
	        
	        long[] storage = new long[n+1];
	        

	        return Staircase(storage,n);
	        
		}

	public static void main(String[] args) {

		System.out.println(staircase(100));
	}

}
