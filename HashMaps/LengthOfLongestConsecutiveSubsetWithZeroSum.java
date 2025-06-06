package hashmaps;

import java.util.HashMap;

public class LengthOfLongestConsecutiveSubsetWithZeroSum{
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int count=0;
		
		int sum=0;
		
		for(int i=0; i<arr.length; i++) {
			
			sum+=arr[i];
			
			if(sum==0) {
				count=i+1;
			}
			
			else if(map.containsKey(arr[i])) {
				int length = i-map.get(arr[i]);
				
				if(count<length) {
					count=length;
				}
			}
			
			else {
				map.put(arr[i], i);
			}
			
			
		}
		
		return count;
		
	}
		
}
