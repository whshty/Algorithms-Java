class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int res = dfs(i, j, matrix, cache, Integer.MIN_VALUE);
                max = Math.max(max, res);
            }
        }
        return max;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] dp, int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        else {
            int cur = matrix[i][j];
            int max = 0;
            max = Math.max(dfs(i - 1, j, matrix, dp, cur), max);
            max = Math.max(dfs(i + 1, j, matrix, dp, cur), max);
            max = Math.max(dfs(i, j - 1, matrix, dp, cur), max);
            max = Math.max(dfs(i, j + 1, matrix, dp, cur), max);
            dp[i][j] = ++max;
            return max;
        }
    }
}