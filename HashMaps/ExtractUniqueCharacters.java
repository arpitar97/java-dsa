package hashmaps;

import java.util.HashMap;

public class ExtractUniqueCharacters {
	
	//Time complexity : O(N)
	//Space complexity : O(N)
	public static String uniqueChar(String str){
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        if(str.length()==0){
            return "";
        }
        
        String s = "";
        
        for(int i=0; i<str.length(); i++){
            
            if(map.containsKey(str.charAt(i))){
                continue;
            }
            
            map.put(str.charAt(i),1);
            
            s+=str.charAt(i);
            
        }
        
        return s;

	}

}
