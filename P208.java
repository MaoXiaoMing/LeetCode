
/*
 * 208. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class TrieNode {
    // Initialize your data structure here.
	boolean value;
	TrieNode[] map;
    public TrieNode() {
        value = false;
        map = new TrieNode[26];
    }
    
    public void insert(String word, int index) {
    	if(word==null || index==word.length()) {
    		this.value = true;
    		return ;
    	}
    	if(map[word.charAt(index)-'a'] != null) 
    		map[word.charAt(index)-'a'].insert(word, index+1);
    	else {
    		TrieNode node = new TrieNode();
    		map[word.charAt(index)-'a'] = node;
    		node.insert(word, index+1);
    	}
    } 
    
}

public class P208 {
	private TrieNode root;

    public P208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if(word==null) return true;
        TrieNode current = root;
    	for(int i=0; i<word.length(); i++) {
        	if(current.map[word.charAt(i)-'a']==null) return false;
        	current = current.map[word.charAt(i)-'a'];
        }
    	return current.value;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i=0; i<prefix.length(); i++) {
        	if(current.map[prefix.charAt(i)-'a']==null) return false;
        	current = current.map[prefix.charAt(i)-'a'];
        }
        return true;
    }
    
	public static void main(String[] args) {
		P208 trie = new P208();
		trie.insert("pp");
		trie.insert("ppp");
		System.out.println(trie.startsWith("pp"));
	}

}
