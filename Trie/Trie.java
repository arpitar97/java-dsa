package trie;

import java.util.ArrayList;

class TrieNode{
	
	char data;
	boolean isTerminating;
	TrieNode[] children;
	int childCount;
	
	public TrieNode(char data) {
		this.data=data;
		isTerminating=false;
		children = new TrieNode[26];
		childCount=0;
	}
	
}

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode('\0');
	}
	
	public void add(String word) {
		add(root,word);
	}

	//Time complexity : O(l) where l is the length of string
	private void add(TrieNode root, String word) {
		
		if(word.length()==0) {
			root.isTerminating=true;
			return;
		}
		
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex]=child;
			root.childCount++;
		}
		
		add(child,word.substring(1));
		
	}
	
	public boolean search(String word) {
		return search(root,word);
	}

	//Time complexity : O(l) where l is the length of string
	private boolean search(TrieNode root, String word) {
		
		if(word.length()==0) {
			return root.isTerminating;
		}
		
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return false;
		}
		
		return search(child,word.substring(1));
	}
	
	public void remove(String word) {
		remove(root,word);
	}

    //Time complexity : O(l) where l is the length of string
	private void remove(TrieNode root, String word) {
		
		if(word.length()==0) {
			root.isTerminating=false;
			return;
		}
		
		int childIndex = word.charAt(0)-'a';
		TrieNode child = root.children[childIndex];
		if(child==null) {
			return;
		}
		
		remove(child,word.substring(1));
		
		if(!child.isTerminating && child.childCount==0) {
			root.children[childIndex]=null;
			child=null;
			root.childCount--;
		}
		
	}
	
    public boolean isPalindromePair(ArrayList<String> words) {
		
		for(String word : words) {
			String ans = reverseWord(word);
			add(ans);
		}
		
		return isPairPalindrome(root,words);
		
	}
	
	private boolean isPairPalindrome(TrieNode root, ArrayList<String> words) {
		
		if(words==null || words.size()==0) {
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
			
			return checkRemainingBranchesInTrie(root,"");
		}
		
		int childIndex = word.charAt(startIndex)-'a';
		
		TrieNode child = root.children[childIndex];
		
		if(child == null) {
			
			if(root.isTerminating) {
				return checkWordForPalindrome(word.substring(startIndex));
			}
			
			return false;
		}
		
		return doesPairExistFor(child, word, startIndex+1);
		
	}

	private boolean checkWordForPalindrome(String word) {
		
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

	private boolean checkRemainingBranchesInTrie(TrieNode root, String word) {
		
		if(root.isTerminating) {
			
			if(checkWordForPalindrome(word)) {
				
				return true;
			}
		}
		
		for(TrieNode child : root.children) {
			if(child==null) {
				continue;
			}
			
			String fwd = word + child.data;
			
			if(checkRemainingBranchesInTrie(child, fwd)) {
				return true;
			}
		}
		
		return false;
	}

	private String reverseWord(String word) {
		
		String ans = "";
		
		for(int i=word.length()-1; i>=0; i--) {
			ans+=word.charAt(i);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	}

}
