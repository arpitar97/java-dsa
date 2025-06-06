package recursion2;

public class ReturnAllCodes {
	
	//Time Complexity : O(2^N)
	//Space Complexity : O(N)
	
	 public static char code(int n){
	        return (char)(n+96); //'a'+n-1
	    }
	    
		public static  String[] getCode(String input){

	        if(input.length()==0){
	            String[] smallAns = {""};
	            return smallAns;
	        }
	        
			int firstDigit=input.charAt(0)-'0';
	        
	        String[] ans1 = getCode(input.substring(1));
	        
	        String[] ans2 = new String[0];

	        int first2digit=0;
	        
	        if(input.length()>1){
	            
	            first2digit = (input.charAt(0)-'0')*10+input.charAt(1)-'0';
	            
	            if(first2digit>=10 && first2digit<=26){
	                
	               ans2 = getCode(input.substring(2)); 
	                
	            }
	            
	        }
	        
	        String[] ans = new String[ans1.length+ans2.length];
	        
	        int k=0;
	        
	        for(int i=0; i<ans1.length; i++){
	            ans[k]= code(firstDigit)+ans1[i];
	            k++;
	        }
	        
	        for(int i=0; i<ans2.length; i++){
	            ans[k]=code(first2digit)+ans2[i];
	            k++;
	        }
	        
	        return ans;
		}



	public static void main(String[] args) {
		

	}

}
