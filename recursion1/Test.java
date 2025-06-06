package recursion1;

public class Test {
	
public static String[] keypad(int n){
		
        if(n==0 || n==1){
            String[] ans = {""};
            return ans;
        }

        String[] smallAns = keypad(n/10);
        
        String[] ch = characters(n%10);
        
        String[] ans = new String[smallAns.length*ch.length];
        
        int k=0;
        
        for(int i=0; i<ch.length; i++){
            for(int j=0; j<smallAns.length; j++){
                ans[k]=smallAns[j]+ch[i];
                k++;
            }         
        }
        
        return ans;
    }
    
    
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int input=215;
		String output[] = keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		}

	}


