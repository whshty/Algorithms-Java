
### DP
```java
class TicTacToe {
    int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[6*n][3];
    }
    

    public int move(int row, int col, int player) {
        int n = board.length / 6;
        int[] temp = new int[]{row,n+col,2*n+row+col,5*n+row-col};
        for( int i : temp ){
            if( ++board[i][player] == n ) return player;
        }
        return 0;
    }
}
```