## 1.DFS
```java
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
```

## 2.MEMO DFS
```java
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
```
## 3.DP
* Assume we have coins of {2,5,7} and the total value is 27
* In the last step, we have f(27) = min{f(27-2)+1,f(27-5)+1,f(27-7)+1}
* Initial condition : dp[0] = 0, we can can calculate dp[1],dp[2],.....,dp[27]


