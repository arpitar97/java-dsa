package hashmaps;
import java.util.HashMap;

public class MaximmFrequencyNumber {
	
	
	 //Time complexity : O(N)
	//Space complexity : O(N) where n is the size of array
	 public static int maxFrequencyNumber(int[] arr) {
		 
		 HashMap<Integer,Integer> hm = new HashMap<>();
		 
		 for(int i : arr) {
			 
			 hm.put(i, hm.getOrDefault(i, 0)+1);
			 
		 }
		 
		 int ans = Integer.MIN_VALUE;
		 
		 int max = Integer.MIN_VALUE;
		 
		 for(int i : arr) {
			 
			 if( hm.get(i) > max ) {
				 
				 max = hm.get(i);
				 
				 ans = i;
			 }
		 }
		 
		 
		 return ans;
	 }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
