public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 ) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        return binarySearch(matrix, target, 0, 0, m - 1, n -1);
    }
    private boolean binarySearch(int[][] matrix, int target, int startX, int startY, int endX, int endY){
        if(startX > endX || startY > endY) return false;
        int midX = ( startX + endX ) >>> 1 ;
        int midY = ( startY + endY) >>> 1;
        if( matrix[midX][midY] == target ) return true;
        else if( matrix[midX][midY] > target){
            return binarySearch(matrix,target,startX,startY,endX,midY-1)||binarySearch(matrix,target,startX,startY,midX-1,endY);
        } else {
            return binarySearch(matrix,target,startX,midY+1,endX,endY)||binarySearch(matrix,target,midX+1,startY,endX,midY);
        }
    } 
}