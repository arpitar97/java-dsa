package trie;

public class TrieUse {

	public static void main(String[] args) {
		
		Trie t = new Trie();
		
		t.add("hero");
		t.add("arpit");
		
		System.out.println(t.search("arpit"));
		t.remove("arpit");
		System.out.println(t.search("arpit"));

	}

}
