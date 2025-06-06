package dynamicProgramming;

public class EditDistanceRec {
	
     public static int editDistance(String s1, String s2){
        
        if(s1.length()==0){
            return s2.length();
        }
        
        if(s2.length()==0){
            return s1.length();
        }
        
        if(s1.charAt(0)==s2.charAt(0)){
           return editDistance(s1.substring(1),s2.substring(1));
        }
        
        else{
            
            int opt1 = editDistance(s1,s2.substring(1));
            
            int opt2 = editDistance(s1.substring(1),s2);
            
            int opt3 = editDistance(s1.substring(1),s2.substring(1));
            
            return 1 + Math.min(opt1,Math.min(opt2,opt3));

            
        }

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
