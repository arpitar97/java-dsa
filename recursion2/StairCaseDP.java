package recursion2;

public class StairCaseDP {
	
	//Time Complexity : O(N)
	//Space Complexity : O(N)
	
	public static int staircase(int n) {
		
		int[] ans = new int[n+1];
		
		ans[0]=1;
		ans[1]=1;
		ans[2]=2;
		ans[3]=4;
		
		for(int i=4; i<n+1; i++) {
			ans[i]=ans[i-1]+ans[i-2]+ans[i-3];
		}
		
		return ans[n];
		
	}

	public static void main(String[] args) {
		System.out.println(staircase(35));
}

}
