## Memo DFS
```java
class Solution {
    public int numSquares(int n) {
        return dfs(new HashMap<>(),n);
    }
    
    private int dfs(Map<Integer,Integer> map, int val) {
        if (val == 0) return 0;
        if (val == 1) return 1;
        if (map.containsKey(val)) return map.get(val);
        
        int sqrtVal = (int)Math.sqrt(val);
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= sqrtVal; i++) {
            int leftVal = val - i * i;
            min = Math.min(min, dfs(map, leftVal) + 1);
        }
        map.put(val,min);
        return min;
    }
}
```

## DP

1. Last step
	* dp[n] = min(dp[j] + 1), (n - j * j) is valid and dp[j] has value

2. Tranfer function
	* `dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1`
	* `1 <= i * i < j`

3. Initial and boundary conditions
 	* dp[0] = 0

4. Calculation order
	* Init dp[0]
	* Calculate dp[1],dp[2],... dp[n]
	* return dp[n]

Time : \sqrt{n} * n


```java
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1 ; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            int min = dp[i];
            for (int j = 1 ; j * j <= i; j++ ){
                min =  Math.min(min, dp[i-j*j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
```