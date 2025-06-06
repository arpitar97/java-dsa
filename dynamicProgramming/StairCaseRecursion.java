package dynamicProgramming;

public class StairCaseRecursion {
	
	  
   public static long Staircase(int n){
        
        if(n==0){
            return 1l;
        }
        
        long ans1=0l;
        long ans2=0l;
        long ans3=0l;
        
        if(n>=3){
            ans1 = Staircase(n-3);
        }
        
        if(n>=2){
            ans2 = Staircase(n-2);
        }
        
        if(n>=1){
            ans3 = Staircase(n-1);
        }
        
        return ans1+ans2+ans3;
        
    }

	public static long staircase(int n) {
        
          if(n==0){
            return 0l;
        }
        

        return Staircase(n);
        
	}

	public static void main(String[] args) {
		

		System.out.println(staircase(10));

	}

}
