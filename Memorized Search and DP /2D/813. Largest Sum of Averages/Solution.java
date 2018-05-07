// Brute force
class Solution {
    public double largestSumOfAverages(int[] num, int k) {
        int[] sum = new int[num.length];
        for (int i = 0 ; i < num.length ; i++) sum[i] = num[i] + (i > 0 ? sum[i-1] : 0);   
        return helper(num, sum , k , num.length, 0);
    }
    
    private double helper(int[] num, int[] sum, int k, int len, int index) {
        if (k == 1) {
            return ((double)(sum[len-1] - sum[index] + num[index]) / (len-index));
        }
        
        double res = 0;
        for (int i = index ; i + k <= len ; i++) {
            res = Math.max(
                res, 
                ((double) (sum[i] - sum[index] + num[index]) / (i - index + 1)) + helper(num, sum, k - 1, len, i+1));
        }
        return res;
    }
}

// Memo DFS
class Solution {
    public double largestSumOfAverages(int[] num, int k) {
        int[] sum = new int[num.length];
        for (int i = 0 ; i < num.length ; i++) sum[i] = num[i] + (i > 0 ? sum[i-1] : 0);
        double[][] dp = new double[num.length][k+1];
        return helper(num, sum , k , num.length, 0, dp);
    }
    
    private double helper(int[] num, int[] sum, int k, int len, int index, double[][] dp) {
        if (dp[index][k] != 0) return dp[index][k];
        if (k == 1) {
            dp[index][1] = ((double)(sum[len-1] - sum[index] + num[index]) / (len-index));
            return dp[index][k];
        }
        
        for (int i = index ; i + k <= len ; i++) {
            dp[index][k] = Math.max(
                dp[index][k], 
                ((double) (sum[i] - sum[index] + num[index]) / (i - index + 1)) + helper(num, sum, k - 1, len, i+1, dp));
        }
        return dp[index][k];
    }
}