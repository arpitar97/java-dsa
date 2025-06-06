package pack1;

public class returnPermutations {

	public static void main(String[] args) {
		
		String[] ans = permutationOfString("abcd");

	}
	
	
	public static String[] permutationOfString(String input){
		
		
        if(input.length()==1){
            String[] ans = {input.substring(input.length()-1)};
            return ans;
        }
        
        String[] smallAns = permutationOfString(input.substring(1));
        
        String[] ans = new String[smallAns.length*input.length()];
        
        int index=0;
        
        for(int i=0; i<=smallAns[0].length(); i++){

        	for(int j=0; j<smallAns.length; j++){
                
                ans[index]=smallAns[j].substring(0,i)+input.charAt(0)+smallAns[j].substring(i);
                index++;
 
            }
        }
        
        for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
        
           
        
         return ans;
	}

}
