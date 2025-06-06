package tries;

import java.util.ArrayList;

class TrieNode{
	
	char data;
	boolean isTerminating;
	TrieNode[] children;
	int childCount;
	
	
	public TrieNode(char data){
		this.data=data;
		isTerminating=false;
		children = new TrieNode[26];
		childCount=0;
	}
	
}

public class Trie {
	
	private TrieNode root;
	private int numWords;

	public Trie() {
		root = new TrieNode('\0');
		numWords = 0;
	}
	

	public void remove(String word){
		if(remove(root, word)) {
			numWords--;
		}
	}
	

	private boolean remove(TrieNode root, String word) {
		if(word.length() == 0){
			if(root.isTerminating) {
				root.isTerminating = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		boolean ans = remove(child, word.substring(1));
		// We can remove child node only if it is non terminating and its number of children are 0	

		if(!child.isTerminating && child.childCount == 0){
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		return ans;
	}

	private boolean add(TrieNode root, String word){
		if(word.length() == 0){
			if(root.isTerminating) {
				return false;
			}
			else {
				root.isTerminating = true;
				return true;
			}
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		return add(child, word.substring(1));
	}

	public void add(String word){
		if(add(root, word)) {
			numWords++;
		}
	}
	
	public int countWords() {
        return numWords;
	}
	
	public boolean isPalindromePairr(ArrayList<String> words) {
		
		for(String word : words) {
			this.add(reverseWord(word));
		}
		
		
		return isPalindromePair(root,words);
	}


	private boolean isPalindromePair(TrieNode root, ArrayList<String> words) {
		
		if( words==null || words.size()==0) {
			return false;
		}
		
		for(String word : words) {
			if(doesPairExistFor(root,word,0)) {
				return true;
			}
		}
		return false;
	}


	private boolean doesPairExistFor(TrieNode root, String word, int startIndex) {
		
		if(word=="") {
			return true;
		}
		
		if(startIndex==word.length()) {
			
			if(root.isTerminating) {
				return true;
			}
			return checkRemaniningBranchesInTrie(root,"");
		}
		
		int childIndex = word.charAt(startIndex)-'a';
		
		TrieNode childNode = root.children[childIndex];
		
		if(childNode==null) {
			if(root.isTerminating) {
				return checkWordForPalindrome(word.substring(startIndex));
			}
			return false;
		}
		return doesPairExistFor(childNode,word,startIndex+1);
		
	}


	private static boolean checkWordForPalindrome(String word) {
		
		int sI=0;
		int eI=word.length()-1;
		
		while(sI<eI) {
			
			if(word.charAt(sI)!=word.charAt(eI)) {
				return false;
			}
			
			sI++;
			eI--;
		}
		
		return true;
	}


	private boolean checkRemaniningBranchesInTrie(TrieNode root, String word) {
		
		if(root.isTerminating) {
			if(checkWordForPalindrome(word)) {
				return true;
			}

		}
		
		for(TrieNode childNode : root.children) {
			
			if(childNode==null) {
				continue;
			}
			
			String fwd = word + childNode.data;
			
			return checkRemaniningBranchesInTrie(childNode, fwd);
			
		}
		
		return false;
		
	}




	private String reverseWord(String word) {
		
		String reverse="";
		
		for(int i=word.length()-1; i>=0; i--) {
			reverse+=word.charAt(i);
		}
		
		return reverse;
	}
	
	
	
	

}
