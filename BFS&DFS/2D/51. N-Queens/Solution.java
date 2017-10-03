class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board,res,0);
        return res;
    }
    
    private void dfs(char[][] board, List<List<String>> res , int index) {
        // index : column index 
        if( index == board.length) {
            res.add(buildBoard(board));
            return;
        }
        
        for( int i = 0; i < board.length; i++) {
            if(isValid(board, i, index)) {
                board[i][index] = 'Q';
                dfs(board,res,index + 1);
                board[i][index] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if( board[i][j] == 'Q' && (Math.abs(x - i) == Math.abs(y - j) || i == x)) return false;
            }
        }
        return true;
    }
    
    private List<String> buildBoard(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}