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
        for( int i = 0 ; i < 3 ; i++ ){
            for( int j = 0 ; j < 3 ; j++){
                if(!isValid(board,i*3,j*3,i*3+2,j*3+2)){
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