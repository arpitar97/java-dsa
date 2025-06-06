package recursion2;

public class ReturnKeypad {
	
	//Time Complexity : O(N^2)


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
	
	public static String[] returnKeypad(int input) {
		
		if(input==0 || input==1) {
			String[] smallAns = {""};
			return smallAns;
		}
		
		
		String[] smallAns = returnKeypad(input/10);
		
		String[] chararr = characters(input%10);
		
		String[] ans = new String[smallAns.length*chararr.length];
		
		int k=0;
		
		for(int i=0; i<chararr.length; i++) {
			
			for(int j=0; j<smallAns.length; j++) {
				
				ans[k]=smallAns[j]+chararr[i];
				k++;
				
			}
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		String[] ans = returnKeypad(235);
		
		for(String i : ans) {
			System.out.println(i);
		}
		
		

	}

}
