package hashmaps;
import java.util.HashMap;

public class PrintIntersection {
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static void printIntersection(int[] arr1,int[] arr2) {
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		for(int i : arr2) {
			
			hm.put(i, hm.getOrDefault(i, 0)+1);
			
		}
		
		for(int i : arr1) {
			
			if(hm.containsKey(i)) {
				
				System.out.println(i);
				
				hm.put(i, hm.get(i)-1);
				
				if(hm.get(i)==0) {
					
					hm.remove(i);
					
				}
				
			}
			
		}
		
		
	}

}
