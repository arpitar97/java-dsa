package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MapsUse {

	public static void main(String[] args) {
		
		HashMap<String,Integer> map = new HashMap<>();
		
		//insert
		map.put("abc", 1);
		map.put("def", 2);
		map.put("abc1", 3);
		map.put("def1", 4);
		
		//check Presence
		if(map.containsKey("abc")) {
			System.out.println("HAS ABC");
		}
		
		//checkSize
		System.out.println("Size of map: " + map.size());
		
		//checkPresenceWithValueAsParameter
		if(map.containsValue(2)) {
			System.out.println("Has 2 as value");
		}
		
		//getValue
		int v=0;
		if(map.containsKey("abc")) {
			v=map.get("abc");
		}
		System.out.println(v);
		
		//remove
		int s = map.remove("abc");
		System.out.println(s);
		
		//Iterating over the map. Order is not maintained, Using keySet
		Set<String> keySet = map.keySet();
		for(String str : keySet) {
			System.out.println(str);
		}
		
		
		////Iterating over the map. Order is not maintained
		Collection<Integer> keyvalue = map.values();
		for(Integer a : keyvalue) {
			System.out.println(a);
		}
		
	}

}
