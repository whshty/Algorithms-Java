class Solution {
    public int coinChange(int[] coins, int amount) {
        if( amount < 1 ) return 0;
        return dfs(coins,amount);
    }
    
    public int dfs(int[] coins, int value){
        if( value < 0 ) return -1;
        if( value == 0) return 0;
        
        int res = 0;
        int min = Integer.MAX_VALUE;
        for( int i : coins ){
            res = dfs(coins,value-i);
            if( res >= 0 && res < min ) min = 1 + res;
        }
        if( min == Integer.MAX_VALUE ) return -1;
        else return min;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        if( amount < 1 ) return 0;
        return dfs(coins,amount, new HashMap<Integer,Integer>());
    }
    
    public int dfs(int[] coins, int value, Map<Integer,Integer> map){
        if( value < 0 ) return -1;
        if( value == 0) return 0;
        if(map.containsKey(value)) return map.get(value);
        
        int res = 0;
        int min = Integer.MAX_VALUE;
        for( int i : coins ){
            res = dfs(coins,value-i,map);
            if( res >= 0 && res < min ) min = 1 + res;
        }
        if( min == Integer.MAX_VALUE ) return -1;
        map.put(value,min);
        return min;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for( int i = 1 ; i <= amount ; i++ ){
            dp[i] = Integer.MAX_VALUE;
            for( int j : coins ){
                if( i >= j && dp[i-j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-j] +1 );
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}