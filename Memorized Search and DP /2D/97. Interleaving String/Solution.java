class Solution {
    public boolean isInterleave(String a, String b, String x) {
        int m = a.length(), n = b.length();
        if (m + n != x.length()) return false;
        
        boolean[][] dp = new boolean[m+1][n+1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <=n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i > 0 && a.charAt(i-1) == x.charAt(i+j-1)) {
                    dp[i][j] |= dp[i-1][j];
                }
                if (j > 0 && b.charAt(j-1) == x.charAt(i+j-1)) {
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }
        return dp[m][n];   
    }
}