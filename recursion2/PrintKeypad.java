package recursion2;

public class PrintKeypad {
	
	//Time Complexity : O(N^3)
	
	public static String[] characters(int c){

		if(c==2){
			String[] arr = {"a","b","c"};

			return arr;
		}

		else if(c==3){
			String[]  arr = {"d","e","f"};

			return arr;
		}

		else if(c==4){
			String[] arr = {"g","h","i"};

			return arr;
		}

		else if(c==5){
			String[] arr = {"j","k","l"};

			return arr;
		}

		else if(c==6){
			String[]  arr = {"m","n","o"};

			return arr;
		}

		else if(c==7){
			String[]  arr = {"p","q","r","s"};

			return arr;
		}

		else if(c==8){
			String[] arr = {"t","u","v"};

			return arr;
		}

		else if(c==9){
			String[] arr = {"w","x","y","z"};

			return arr;
		}

		String[] arr = {""};
		return arr;

	}
	
	public static void printKeypad(int input) {
		printKeypad(input,"");
	}

	private static void printKeypad(int input, String outputSoFar) {
		
		if(input==0) {
			System.out.println(outputSoFar);
			return;
		}
		
		String[] charArr = characters(input%10);
		
		for(int i=0; i<charArr.length; i++) {
			printKeypad(input/10,charArr[i]+outputSoFar);
		}
		
	}

	public static void main(String[] args) {
		printKeypad(279);
}

}
