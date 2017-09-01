## DFS
```
public class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    private boolean dfs(char[] s, char[] p, int i, int j) {
        if (j == p.length) return i == s.length;
          
        if (j == p.length - 1 || p[j + 1] != '*') {
            if ( i < s.length && (s[i] == p[j] || p[j] == '.')) return dfs(s,p, i + 1, j + 1);
            else return false;
        }
        else {
            while (i < s.length && (s[i] == p[j] || p[j] == '.')) {
                if (dfs(s, p, i, j + 2)) return true;
                i++;
            }
            return dfs(s, p, i, j + 2);
        }
    }
}

```

## DP
 
 If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
 
 If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
 
 If p.charAt(j) == '*': sub conditions:

1. if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]. In this case, a* only counts as empty
2. if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
	* dp[i][j] = dp[i-1][j]  : a* counts as multiple a 
	* or dp[i][j] = dp[i][j-1] :  a* counts as single a
	* or dp[i][j] = dp[i][j-2] :  a* counts as empty



Input word = aab pattern = ``c*a*.``

First loop 

|   | i   | 0     | 1   | 2   | 3   | 4   | 5   |
|---|-----|-------|-----|-----|-----|-----|-----|
| j |     |pattern| 0:c | 1:* | 2:a | 3:* | 4:. |
| 0 | word| T     |     | T   |     | T   |     |
| 1 | 0:a |       |     |     |     |     |     |
| 2 | 1:a |       |     |     |     |     |     |
| 3 | 2:b |       |     |     |     |     |     |

Second loop

|   | i   | 0 | 1   | 2   | 3   | 4   | 5   |
|---|-----|---|-----|-----|-----|-----|-----|
| j |     | p | 0:c | 1:* | 2:a | 3:* | 4:. |
| 0 | w   | T |     | T   |     | T   |     |
| 1 | 0:a |   |     |     | T   |     |     |
| 2 | 1:a |   |     |     |     | T   |     |
| 3 | 2:b |   |     |     |     |     | T   |

```
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
```

