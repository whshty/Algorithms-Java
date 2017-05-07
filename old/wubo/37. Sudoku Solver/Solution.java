public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for( int i = 0 ; i < 9 ; i ++ ){
            if( !isValid(board,i,0,i,8)){
                return false;
            }
            if( !isValid(board,0,i,8,i)){
                return false;
            }
        }
        for( int row = 0 ; row < 3 ; row++ ){
            for( int col = 0 ; col < 3 ; col++){
                if(!isValid(board,row*3,col*3,row*3+2,col*3+2)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int startRow, int startCol, int endRow, int endCol){
        Set<Character> set = new HashSet<Character>();
        for(int i = startRow; i <= endRow; i++){
            for( int j = startCol ; j <= endCol ; j++ ){
                if( board[i][j] != '.' &&  !set.add(board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}