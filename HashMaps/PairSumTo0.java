package hashmaps;
import java.util.HashMap;

public class PairSumTo0 {
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static int PairSum(int[] input, int size) {
		
		HashMap<Integer,Integer> map =  new HashMap<>();
		
		int count=0;
		
		for(int i : input) {
			
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}
			else {
				map.put(i, 1);
			}
			if(i!=0 && map.containsKey(-i)) {
				count+=map.get(-i);
			}
			
			else if(i==0 && map.containsKey(i)) {
				count+=map.get(i)-1;
			}
			
		}
		
		return count;
		
	}

}
