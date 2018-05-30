## 1.DFS
* Time : Worst Case O(2^n)

```
假设P全是a*a*a*这样组成，s = aaaaaaaa 而s的每一个字符都有2种可能：与当前的a*匹配,或者与下一个a*匹配（前一个匹配空)
s[] = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
p[] = "a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*a*b"
```

```java
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

```

## 2.DP

1. Last step and status
	* If B[m-1] is a regular character, we need A[n-1] = B[m-1]
	* If B[m-1] is ., then A[n-1] is a match
	* If B[m-1] = c is *, then B[m-2] can be duplicated multiple times, we need to consider A[m-1] is 0 c or last c of a mutilpe c.
		* If A[n-1] is 0 c. check if A[0,n1] matches B[0,n-3]
		* If A[n-1] is the last c, check is A[0,n-2] matchs B[0,n-1], A[m-1] = c or c ='.'


2. Transfer function
	* dp[i][j] = dp[i-1][j-1] (i > 0 && B[j-1] == '.' || A[i-1] == B[j-1])
	* dp[i][j] = dp[i][j-2] || (dp[i-1][j] && B[j-2]='.' || B[j-2]= A[i-1]) if B[j-1] =  *

3. Initial and boundary conditions
	* dp[0][0] = true 
	* dp[1][0] .... dp[n][0] = false

4. Calculation order
	* return dp[m][n]


 
 If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
 
 If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
 
 If p.charAt(j) == '*': sub conditions:

1. if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]. In this case, a* only counts as empty
2. if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
	* dp[i][j] = dp[i-1][j]  : a* counts as multiple a 
	* or dp[i][j] = dp[i][j-1] :  a* counts as single a
	* or dp[i][j] = dp[i][j-2] :  a* counts as empty


```java
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
```

