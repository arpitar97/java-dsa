package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		int[] arr = {2,5,4,77,66,1};
		   
        HashMap<Integer,Boolean> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            
            map.put(arr[i],true);
        }
        
  
    	Set<Integer> keySet = map.keySet();
		for(Integer str : keySet) {
			System.out.println(str);
		}
		
		
		////Iterating over the map. Order is not maintained
		Collection<Boolean> keyvalue = map.values();
		for(Boolean a : keyvalue) {
			System.out.println(a);
		}
        
        
        
	   }

}
