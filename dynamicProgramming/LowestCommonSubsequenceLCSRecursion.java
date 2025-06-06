package dynamicProgramming;

public class LowestCommonSubsequenceLCSRecursion {
	
	
	public static int LCS(String a, String b) {
		
		
		if(a.length()==0 || b.length()==0) {
			return 0;
		}
		
		if(a.charAt(0)==b.charAt(0)) {
			return 1+ LCS(a.substring(1),b.substring(1));
		}else {
			int opt1 = LCS(a,b.substring(1));
			
			int opt2 = LCS(a.substring(1),b);
			
			return Math.max(opt1, opt2);
		}
		
	}

	public static void main(String[] args) {
		
		String a = "adgei";
		
		String b = "abegi";
		
		System.out.println(LCS(a,b));

	}

}
