package pack1;

public class returnKeypad {
	
	public static String[] keypad(int n){
		// Write your code here
        
        if(n==0){
            String[] ans = {""};
            System.out.println(ans.length);
            return ans;
        }

        
        String[] smallAns = keypad(n/10);
        
        char[] alpha = alphabets(n%10);
        
       
        
       
        	
        String[] ans = new String[smallAns.length];
        	System.out.println(ans.length);
        	
      
        
        int k=0;
        
        for(int i=0; i<alpha.length; i++){
            
            for(int j=0; j<smallAns.length; j++){
                
                ans[k]=smallAns[j]+alpha[i];
                
                k++;
                
            }
            
        }
        
        
             return ans;
	}
    
    private static char[] alphabets(int a){
        
        if(a==2){
            
            char[] ans = {'a','b','c'};
            return ans;
            
        }
        
        
        else if(a==3){
            
            char[] ans = {'d','e','f'};
             return ans;
        }
        
         else if(a==4){
            
            char[] ans = {'g','h','i'};
              return ans;
            
        }
        
         else if(a==5){
            
            char[] ans = {'j','k','l'};
              return ans;
            
        }
        
         else if(a==6){
            
            char[] ans = {'m','n','o'};
              return ans;
            
        }
        
         else if(a==7){
            
            char[] ans = {'p','q','r','s'};
              return ans;
            
        }
        
         else if(a==8){
            
            char[] ans = {'t','u','v'};
              return ans;
            
        }
        
         else if(a==9){
            
            char[] ans = {'w','x','y','z'};
            return ans;
            
        }
        
         else if(a==0){
             
             char[] ans = {'*'};
               return ans;
             
         } 
         
         else if(a==1){
             
             char[] ans = {'@'};
               return ans;
             
         }
        
      
        
        char[] ans={};
        return ans;
        
     
    }

	public static void main(String[] args) {
	
	
		String[] ans = keypad(5230);
		
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
		
		

	}

}
