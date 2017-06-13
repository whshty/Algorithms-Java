public class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rowSet = new HashSet<Integer>();
        HashSet<Integer> colSet = new HashSet<Integer>();
        for( int i = 0 ; i < matrix.length; i++ ){
            for( int j = 0 ; j < matrix[0].length ; j++ ){
                if( matrix[i][j] == 0 ){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
        // row to zero
        for( int i : rowSet){
            for( int j = 0 ; j < matrix[0].length ; j++ ){
                matrix[i][j] = 0;
            }
        }
        
        
        for( int j : colSet){
            for( int i = 0 ; i < matrix.length ; i++ ){
                matrix[i][j] = 0;
            }
        }
    }
}