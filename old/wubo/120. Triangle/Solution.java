public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        // last row
        for( int i = 0 ; i < n ; i++ ){
            dp[i] = triangle.get(n-1).get(i);
        }
        
        // dp[] = {4,1,8,3}
        // dp[] = {7,6,10}
        // dp[] = {9,10}
        // dp[] = {11}
        for( int i = n - 2;  i >= 0 ; i--){
            for( int j = 0 ; j<= i ; j++ ){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}