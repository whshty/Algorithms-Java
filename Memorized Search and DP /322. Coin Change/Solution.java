class Solution {
    public int coinChange(int[] coins, int amount) {
        if( amount < 1 ) return 0;
        return dfs(coins,new HashMap<Integer,Integer>(),amount);
    }
    
    public int dfs(int[] coins, Map<Integer,Integer> map, int remain){
        if( remain < 0 ) return -1;
        if( remain == 0) return 0;
        if(map.containsKey(remain-1) ) return map.get(remain-1);
        
        int min = Integer.MAX_VALUE;
        for( int coin : coins ){
            int res = dfs(coins,map,remain-coin);
            if( res >= 0 && res < min ){
                min = 1 + res;
            }
        }
        if( min == Integer.MAX_VALUE) map.put(remain-1,-1);
        else map.put(remain-1,min);
        return map.get(remain-1);
    }
}