package recursion2;

public class ReturnSubsequencesOfString {
	
	//Time Complexity : O(N^2)
	
	public static String[] returnSubsequences(String input) {
		
		if(input.length()==0) {
			String[] smallAns = {""};
			return smallAns;
		}
		
		String[] smallAns = returnSubsequences(input.substring(1));
		
		String[] ans = new String[smallAns.length*2];
		
		int k=0;
		
		for(int i=0; i<smallAns.length; i++) {
			ans[k]=smallAns[i];
			k++;
		}
		
		for(int i=0; i<smallAns.length; i++) {
			ans[k]=input.charAt(0)+smallAns[i];
			k++;
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		String[] ans = returnSubsequences("xyz");
		
		for(String i : ans) {
			System.out.println(i);
		}
		
		

	}

}
