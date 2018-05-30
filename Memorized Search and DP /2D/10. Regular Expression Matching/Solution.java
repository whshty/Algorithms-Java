class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s, p , 0, 0);
    }
    private boolean dfs(String s, String p, int i, int j) {
        // If j reach the end, i should also in the end
        if( j == p.length() ) return i == s.length();
        
        // No * situation in j + 1
        // j == p.length() - 1 is the end case 
        if( j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if ( i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) return dfs(s,p, i + 1, j + 1);
            else return false;
        }
        // * in j + 1  
        else {
            while( i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                if (dfs(s, p, i, j + 2)) return true;
                i++;// "aaaaaaaa",".*"
            }
            return dfs(s, p, i, j + 2);
        }
    }
}

class Solution {
    public boolean isMatch(String a, String b) {
        int m = a.length();
        int n = b.length();

        boolean[][] dp = new boolean[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = (i==0);
                    continue;
                }
                // j > 0
                if (b.charAt(j-1) == '*') {
                    if (j > 1) {
                        dp[i][j] |= dp[i][j-2];
                        if (i > 0 && (a.charAt(i-1) == b.charAt(j-2) || b.charAt(j-2) == '.')) {
                            dp[i][j] |= dp[i-1][j];
                        }
                    }

                } else {
                    if (i > 0 && (a.charAt(i-1) == b.charAt(j-1) || b.charAt(j-1) == '.')) {
                        dp[i][j] |= dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
}