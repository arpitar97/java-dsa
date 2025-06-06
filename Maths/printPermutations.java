package pack1;

public class printPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindPermutations("abc");

	}
	
	public static void FindPermutations(String str) {
		// Write your code here
        
         FindPermutations(str,"");

	}
    
    
    public static void FindPermutations(String str, String output) {
		// Write your code here

        if(str.length()==0){
            System.out.println(output);
            return;
        }
        
        for(int i=0; i<str.length(); i++){
        	
        	
        	String ans = str.substring(0,i)+str.substring(i+1); 
        			
            FindPermutations(ans,output+str.charAt(i));
            
        }
        
	}

}
