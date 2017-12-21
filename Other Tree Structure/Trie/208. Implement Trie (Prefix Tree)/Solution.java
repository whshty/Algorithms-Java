class TrieNode {
    // Initialize your data structure here.
    private TrieNode[] nodes;
    private final int SIZE = 26;
    private boolean isEnd;
    
    public TrieNode() {
        nodes = new TrieNode[26];
    }
    
    public boolean containsKey(char ch) {
        return nodes[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return nodes[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        nodes[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
    
}


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        
        for(char ch: word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch,new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char cur = word.charAt(i);
           if (node.containsKey(cur)) {
               node = node.get(cur);
           } else {
               return null;
           }
        }
        return node;
    }

  
    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

