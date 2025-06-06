package recursion2;

public class PrintSubsequencesOfString {
	
	//Time Complexity : O(2^N)
	
	
	public static void printSubsequences(String input) {
		 printSubsequences(input,"");
	}

	private static void printSubsequences(String input, String outputSoFar) {
		
		if(input.length()==0) {
			System.out.println(outputSoFar);
			return;
		}
		//Not including in subsequence
		printSubsequences(input.substring(1),outputSoFar);
		
		//Including the character in subsequence
		printSubsequences(input.substring(1),outputSoFar+input.charAt(0));
		
	}

	public static void main(String[] args) {
		
		printSubsequences("xyz");

	}

}
