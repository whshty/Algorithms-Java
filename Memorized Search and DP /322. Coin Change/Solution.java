class Solution {
    public int coinChange(int[] coins, int amount) {
        if( amount < 1 ) return 0;
        return dfs(coins,new int[amount],amount);
    }
    
    public int dfs(int[]coins, int[] memo, int remain){
        if( remain < 0 ) return -1;
        if( remain == 0) return 0;
        if( memo[remain-1] != 0 ) return memo[remain-1];
        
        
        int min = Integer.MAX_VALUE;
        for( int coin : coins ){
            int res = dfs(coins,memo,remain-coin);
            if( res >= 0 && res < min ){
                min = 1 + res;
            }
        }
    
        memo[remain-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[remain-1];
    }
}