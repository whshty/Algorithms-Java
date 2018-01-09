class Solution {
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
    
    public String searchRoot(String word){
        TrieNode node = root;
        for( int i = 0 ; i < word.length() ; i++ ){
            int index = word.charAt(i) - 'a';
            if( node.children[index] == null ) return word;
            else if( node.children[index].isEnd ) return word.substring(0,i+1);
            node = node.children[index];
        }
        return word;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        for( int i = 0 ; i < dict.size() ; i++ ){
            addWord(dict.get(i));
        }
        String[] strs = sentence.split(" ");
        for( int i = 0 ; i < strs.length ; i++ ){
            strs[i] = searchRoot(strs[i]);
        }
        return String.join(" ",strs);
    }
}