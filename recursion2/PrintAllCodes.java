package recursion2;

public class PrintAllCodes {
	
	//Time Complexity : 0(2^N)
	
	public static char code(int n){
        return (char)(n+96);
    }
    
    
	public static void printAllPossibleCodes(String input, String outputSoFar) {
		
        if(input.length()==0){
            System.out.println(outputSoFar);
            return;
        }
        
        
        int firstDigit = input.charAt(0)-'0';
        
        printAllPossibleCodes(input.substring(1),outputSoFar+code(firstDigit));
        
        int first2digit=0;
        
        if(input.length()>=2){
            first2digit=(input.charAt(0)-'0')*10+(input.charAt(1)-'0');
            
            if(first2digit>=10 && first2digit<=26){
                printAllPossibleCodes(input.substring(2),outputSoFar+code(first2digit));
            }
        }
        

	}

	public static void printAllPossibleCodes(String input) {
		
        printAllPossibleCodes(input,"");

	}

	public static void main(String[] args) {
		

	}

}
