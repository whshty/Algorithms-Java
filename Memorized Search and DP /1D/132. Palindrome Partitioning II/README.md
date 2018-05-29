## DP
1. Last step
	* The last palindrome, define it as dp[j,n-1]
	* dp[n-1] = dp[j-1] + 1

2. Transfer function
	* dp[i] = min(dp[j] +1) (0 <=j<= i-1) || s[j,i-1] is palindrome

3. Initial and boundary conditions
	* dp[0] = 0

4. Calculation order
	* dp[0] to dp[n]
	* return dp[n] - 1


Time : O(n^2)

```java

class Solution {
    public int minCut(String s) {
        int len = s.length();
        if (len == 0) return 0;

        boolean[][] isPalindrome = calPalindrome(s);

        int[] dp = new int[len + 1];
        dp[0] = 0;


        for (int i = 1; i <= len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[s.length()] - 1;
    }

    private boolean[][] calPalindrome(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len][len];

        for (int mid = 0; mid < len; mid++) {
            int i = mid;
            int j = mid;
            while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
                res[i][j] = true;
                i--;
                j++;
            }
        }

        for (int mid = 0; mid < len - 1; mid++) {
            int i = mid;
            int j = mid + 1;
            while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
                res[i][j] = true;
                i--;
                j++;
            }
        }

        return res;
    }
}

```