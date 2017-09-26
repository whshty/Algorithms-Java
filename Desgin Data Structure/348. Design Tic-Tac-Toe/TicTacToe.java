class TicTacToe {
    int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[6*n][3];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int n = board.length / 6;
        int[] temp = new int[]{row,n+col,2*n+row+col,5*n+row-col};
        for( int i : temp ){
            if( ++board[i][player] == n ) return player;
        }
        return 0;
    }
}

