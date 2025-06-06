package dynamicProgramming;

public class Min_Steps {
	
	public static int min_steps(int a) {
		if (a==1) {
			return 0;
		}
		
		return min_steps(a,0);
	}

	private static int min_steps(int a, int count) {
		
		if(a==1) {
			return count;
		}
		
		int ans1 = Integer.MAX_VALUE;
		int ans2 = Integer.MAX_VALUE;
		int ans3 = Integer.MAX_VALUE;
		
		if(a%3==0) {
			ans1 = min_steps(a/3,count+1);
		}
		
		if(a%2==0) {
			ans2 = min_steps(a/2,count+1);
		}
		
		ans3 = min_steps(a-1,count+1);
		    
		    
		return Math.min(ans1, Math.min(ans2, ans3));
	
	}

	public static void main(String[] args) {
		
       System.out.println(min_steps(10));
		
		
	}

}
