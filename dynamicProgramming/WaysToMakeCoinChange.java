package dynamicProgramming;

public class WaysToMakeCoinChange {
	
	 public static int countWaysToMakeChange(int denominations[], int value, int index){
	        
	     if(index>=denominations.length || value<0){
	            return 0;
	        }
	        
	        if(value==0){
	         return 1;   
	        }
	        
	
	         
	 return countWaysToMakeChange(denominations,value,index+1)+
	     countWaysToMakeChange(denominations,value-denominations[index],index);
	   
	    }

		
		public static int countWaysToMakeChange(int denominations[], int value){
	        
	        if(denominations.length==0){
	            return 0;
	        }
   
	        
	        return countWaysToMakeChange(denominations,value,0);
		}

	public static void main(String[] args) {
		

	}

}
