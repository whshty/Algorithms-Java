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
        if ( ch == '#' || node.nodes[ch-'a'] == null ) return;
        node = node.nodes[ch-'a'];
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
            TrieNode temp = root;
            for( char ch : word.toCharArray() ){
                int val = ch - 'a';
                if( temp.nodes[val] == null ) temp.nodes[val] = new TrieNode();
                temp = temp.nodes[val];
            }
            temp.word = word;
        }
        return root;
    } 
}

class TrieNode {
    TrieNode[] nodes = new TrieNode[26];
    String word;
}