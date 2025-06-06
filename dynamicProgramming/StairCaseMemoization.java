package dynamicProgramming;

public class StairCaseMemoization {
	
	
  public static long Staircase(long[] storage,int n){
        
        if(n==0){
        	storage[0]=1l;
            return storage[0];
        }
        
        if(storage[n]!=0l) {
        	return storage[n];
        }
        
        long ans1=0l;
        long ans2=0l;
        long ans3=0l;
        
        if(n>=3){
            ans1 = Staircase(storage,n-3);
        }
        
        if(n>=2){
            ans2 = Staircase(storage,n-2);
        }
        
        if(n>=1){
            ans3 = Staircase(storage,n-1);
        }
        
        storage[n]=ans1+ans2+ans3;
        
        return storage[n]; 
        
    }

	public static long staircase(int n) {
        
        if(n==0){
            return 0l;
        }
        
        long[] storage = new long[n+1];
        

        return Staircase(storage,n);
        
	}

	public static void main(String[] args) {
		
      System.out.println(staircase(10));
	}

}
