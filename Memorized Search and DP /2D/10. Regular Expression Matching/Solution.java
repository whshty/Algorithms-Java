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



public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length()+1;
        int n = p.length()+1;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for( int i = 2 ; i < n ; i++){
            if(pc[i-1] == '*') dp[0][i] = dp[0][i-2];
        }
        
        for( int i = 0 ; i < s.length() ; i++){
            for( int j = 0 ; j < p.length(); j++){
                if( pc[j] == '.') dp[i+1][j+1] = dp[i][j];
                if( pc[j] == sc[i] ) dp[i+1][j+1] = dp[i][j];
                if( pc[j] == '*'){
                    if(pc[j-1] != sc[i] && pc[j-1] != '.' ){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else{
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}