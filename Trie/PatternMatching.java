package trie;

import java.util.ArrayList;

public class PatternMatching {
	
	//Time complexity : O(N*M)
	//Space complexity : O(N*M)
	//where N = no. of words and m = average word length
	public boolean patternMatching(ArrayList<String> vect, String pattern) {
        
		Trie t = new Trie();
		
		for(int i=0; i<vect.size(); i++) {
			
			for(int j=0; j<vect.get(i).length(); j++) {
				
				t.add(vect.get(i).substring(j));
				
			}
			
		}
		
		return t.search(pattern);
		
	}

}
