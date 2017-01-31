// start point  = ( i + offset, y + offer)
// scall = ( row - 2 , col - 2 )

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //Using recursion: print all boundary elem in spiral order in each level, using boundary size to move into next level 
        List<Integer> res = new ArrayList<Integer>();
        if ( matrix == null || matrix.length == 0 ) return res;
        if ( matrix[0] == null ||  matrix[0].length == 0 ) return res;

        int row = matrix.length;
        int col = matrix[0].length;

        help(matrix, res, row, col, 0);
        return res;
    }
    private void help (int[][] m, List<Integer> res, int row , int col , int offset){
        //base case
        if (row == 0 || col == 0) return;
        if (row == 1 ){
            for (int i = offset ; i < offset + col; i++){
                res.add(m[offset][i]);
            }
            return;
        }
        if (col == 1 ){
            for (int i = offset ; i < offset + row; i++){
                res.add(m[i][offset]);
            }
            return;
        } 
        //  up row 
        for ( int i = offset ; i < col - 1 + offset ; i ++){
            res.add(m[offset][i]);
        }

        //right col 
        for (int i = offset ; i < row  - 1 + offset; i++){
            res.add(m[i][col  - 1 + offset]);
        }

        //down row 
        for (int i = col - 1 + offset ; i > offset ; i--){
            res.add(m[row - 1 + offset][i]);

        }
        for (int i = row - 1 + offset; i > offset; i--){
            res.add(m[i][offset]);
        }
        // next level 
        help(m, res, row - 2, col - 2, offset + 1);
    }
}