public class WordDictionary {
    class TrieNode {
        // Initialize your data structure here.
        private TrieNode[] children;
        private final int SIZE = 26;
        private boolean isEnd;
    
        public TrieNode() {
            children = new TrieNode[26];
        }

        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node =  root;
        for( int i = 0 ; i < word.length() ; i++){
            if( node.children[word.charAt(i) - 'a'] == null){
                node.children[word.charAt(i) - 'a'] = new TrieNode();    
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.setEnd();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return isMatch(word.toCharArray(), 0, root);    
    }
    public boolean isMatch(char[] ch, int index , TrieNode node){
        if( index == ch.length ) return node.isEnd();
        if( ch[index] != '.'){
            return node.children[ch[index] - 'a'] != null && isMatch(ch, index + 1, node.children[ch[index] - 'a']);
        } else{
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (isMatch(ch, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}