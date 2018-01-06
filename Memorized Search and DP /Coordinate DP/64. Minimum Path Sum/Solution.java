class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for( int j = 1 ; j < n ; j++ ){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for( int i = 1 ; i < m ; i++ ){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    } 
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[2][n];
        int pre , cur = 0;

        for (int i = 0 ; i < m; i++) {
            // Rolling Array
            pre = cur;
            cur = 1 - cur;
            for (int j = 0 ; j < n; j++) {
                dp[cur][j] = grid[i][j];
                if( i == 0 && j == 0 ) continue;
                int temp = Integer.MAX_VALUE;
                if ( i > 0 ) temp = Math.min(temp,dp[pre][j]);
                if ( j > 0 ) temp = Math.min(temp,dp[cur][j-1]);
                dp[cur][j] += temp;
            }
        }
        return dp[cur][n - 1];
    } 
}