## DP
1. Last step and status
	* If a[n-1] == b[m-1], then it depends on a[0,n-2] and b[0,n-2]
	* If b[m-1] is ?, then it depends on a[0,n-2] and b[0,n-2]
	* If B[m-1] is *
		* If A[n-1] can not be matched by *, then it depends on A[0,n-1] and B[0,n-2]
		* If A[n-1] can be matched by *, then it depends on A[0,n-2] and B[0,n-1]

2. Transfer function
	* dp[i][j] = dp[i-1][j-1], if i > 0 and B[j-1] = '?' or A[i-1] = B[j-1]
	* dp[i-1][j] or dp[i][j-1], if B[j-1] = '*'

3. Initial and boundary conditions
	* dp[0][0] = true
	* dp[1][0] .... dp[n][0] = false

4. Calculation order
	* return dp[m][n]


```java
class Solution {
    public boolean isMatch(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j==0) {
                    dp[i][j] = (i == 0);
                    continue;
                }
                dp[i][j] = false;
                if (b.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1];
                    if (i > 0) {
                        dp[i][j] |= dp[i-1][j];
                    }
                } else {
                    if (i > 0) {
                        if (a.charAt(i-1) == b.charAt(j-1) || b.charAt(j-1) == '?') {
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
```
