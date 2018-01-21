class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for( int i = 0 ; i < board.length ; i++ ){
            for( int j = 0 ; j < board[0].length ; j++ ){
                dfs(board,i,j,root,res);
            }
        }
        return res;
    }
    public void dfs(char[][] board, int i , int j , TrieNode node, List<String> res){
        char ch = board[i][j];
        if ( ch == '#' || !node.containsKey(ch) ) return;
        node = node.get(ch);
        if( node.word != null ){
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,node, res); 
        if (j > 0) dfs(board, i, j - 1, node, res);
        if (i < board.length - 1) dfs(board, i + 1, j, node, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, res); 
        board[i][j] = ch;
    }
    
    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words ){
            TrieNode node = root;
            for( char ch : word.toCharArray() ){
                if( !node.containsKey(ch)) node.put(ch,new TrieNode());
                node = node.get(ch);
            }
            node.word = word;
        }
        return root;
    } 
}

class TrieNode {
    TrieNode[] nodes;
    int SIZE = 26;
    String word;
    public TrieNode(){
        nodes = new TrieNode[SIZE];
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

}