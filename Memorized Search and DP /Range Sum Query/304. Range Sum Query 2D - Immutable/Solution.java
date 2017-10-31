class NumMatrix {
    int[][] temp;

    public NumMatrix(int[][] matrix) {
        temp = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for( int i = row1 ; i <= row2 ; i++ ){
            for( int j = col1 ; j <= col2 ; j++ ){
                res += temp[i][j];
            }
        }
        return res;
    }
}


class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return;   
        
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1] ;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rowStart = Math.min(row1, row2);
        int rowEnd = Math.max(row1, row2);
        int colStart = Math.min(col1, col2);
        int colEnd = Math.max(col1, col2);
        return dp[rowEnd + 1][colEnd + 1] - dp[rowEnd + 1][colStart] - dp[rowStart][colEnd + 1] + dp[rowStart][colStart];    
    }
}