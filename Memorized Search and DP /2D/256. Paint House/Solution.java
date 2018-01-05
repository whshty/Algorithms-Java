class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int len = costs.length;
        
        int[][] dp = new int[len+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        
        for( int i = 1 ; i <= len ; i++ ){
            for ( int j = 0 ; j < 3 ; j++ ){
                dp[i][j] = Integer.MAX_VALUE;
                for( int k = 0 ; k < 3 ; k++ ){
                    if( k == j ) continue;
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][k] + costs[i-1][j]);
                }
            }
        }
        return Math.min(dp[len][0],Math.min(dp[len][1],dp[len][2])); 
    }
}

class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        
        for(int i = 1; i < costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
        }
        int n = costs.length - 1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}