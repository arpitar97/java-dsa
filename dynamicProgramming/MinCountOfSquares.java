package dynamicProgramming;

public class MinCountOfSquares {
	
	public static int minCount(int n) {
		
        if(n==0){
            return 0;
        }
        
        int max = Integer.MAX_VALUE;
        
        for(int i=1; i<=(int)Math.pow(n,0.5); i++ ){
        
           int ans = 1 + (int)minCount(n-(int)Math.pow(i,2));
            
           if(ans<max){
               max=ans;
           }
            
        }
        
        return max;
	}

	public static void main(String[] args) {
		
		System.out.println(minCount(43));

	}

}
