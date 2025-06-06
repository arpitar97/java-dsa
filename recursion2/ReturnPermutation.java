package recursion2;

public class ReturnPermutation {
	
	//Time Complexity : 0(N!)
	//Space Complexity : O(N!)
	
	public static String[] permutationOfString(String input){
		
		if(input.length()==1) {
			String[] smallAns = {input};
			return smallAns;
		}
		
		String[] smallAns = permutationOfString(input.substring(1));
		
		String[] ans = new String[smallAns.length*input.length()];
		
		int index=0;
		
		for(int i=0; i<=smallAns[0].length(); i++) {
			
			for(int j=0; j<smallAns.length; j++) {
				
				ans[index] = smallAns[j].substring(0,i)+input.charAt(0)+smallAns[j].substring(i);
				
				index++;
				
			}
			
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		String[] ans = permutationOfString("abc");
		
		for(String i : ans) {
			System.out.println(i);
		}

	}

}
