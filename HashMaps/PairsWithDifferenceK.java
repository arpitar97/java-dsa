package hashmaps;
import java.util.HashMap;

public class PairsWithDifferenceK {
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static int getPairsWithDifferenceK(int arr[], int k) {
		
		int count = 0;
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i : arr) {
			
			if(map.containsKey(i+k)) {
				count+=map.get(i+k);
			}
			
			if(map.containsKey(i-k) && k!=0) {
				count+=map.get(i+k);
			}
			
			map.put(i, map.getOrDefault(i, 0)+1);
			
		}
		
		return count;
		
	}

}
