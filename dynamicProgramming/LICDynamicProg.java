package dynamicProgramming;

public class LICDynamicProg {
	
	 public static int lis(int arr[]) {
	        
	      int[] storage = new int[arr.length];
	        
	      storage[0]=1;
	        
	      int ans=0;
	  
	      for(int i=1; i<storage.length; i++){
	          
	          int max=0;
	          
	          int j=i-1;
	          
	          while(j>=0){
	              
	              if(arr[i]>arr[j] && storage[j]>max){
	                  max=storage[j];
	                  
	              }
	           j--;   
	              
	          }
	          storage[i]=max+1;
	          
	          if(storage[i]>ans){
	              ans=storage[i];
	          }
	          
	      }
	        
	        return ans;

	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
