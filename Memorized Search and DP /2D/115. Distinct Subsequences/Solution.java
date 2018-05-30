class Solution {
    public int numDistinct(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        
        for (int i = 1; i <= m ; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if (j > 0 && a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}