public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix.length == 0 || matrix[0].length == 0 ) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end =  n*m - 1;

        while( start <= end){
            int mid = ( start + end ) >>> 1 ;
            if( target == matrix[mid/n][mid%n])return true;
            else if( target > matrix[mid/n][mid%n] ) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}