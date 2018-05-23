// next state + current state
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = countNeighbors(board,i,j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                // Reproduction
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }    
        updateState(board);
    }
    
    private void updateState(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;  
            }
        }
    }
    
    private int countNeighbors(int[][] board, int m , int n){
        int count = 0;
        for (int i = - 1 ; i <= 1 ; i++ ) {
            for (int j = -1 ; j <= 1 ; j++) {
                if (isValid(board,i+m,j+n)) count += board[i+m][j+n] & 1;
            }
        }
        if (board[m][n] == 1) count--;
        return count;
    }
    private boolean isValid (int[][] board, int i, int j){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        else return true;
    }
}