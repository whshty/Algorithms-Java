
class Solution {
    public int[][] imageSmoother(int[][] M) {
        if( M == null ) return null;
        int m = M.length;
        int n = M[0].length;
        
        int[][] res = new int[m][n];
        int[] dirs = new int[]{-1,0,1};
        for( int i = 0 ; i < m ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                int count = 0 , sum = 0;
                for( int x : dirs ){
                    for( int y : dirs ){
                        if( isValid(i+x,j+y,m,n)){
                            count++;
                            sum += M[i+x][j+y];
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
        
    }
    private boolean isValid(int i , int j , int m , int n){
        return i >= 0 && i < m && j >=0 && j < n;
    }
}