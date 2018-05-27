## Brute Force DFS 
```java
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if( nums == null || nums.length == 0 || target <= 0 ) return 0;
        return helper(nums,target);
    }
    
    private int helper(int[] nums, int sum ){
        if( sum < 0 ) return 0;
        if( sum == 0 ) return 1;
        
        int res = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            res += helper(nums,sum-nums[i]);
        }
        return res;
    }
}
```

## Memo DFS

```java
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        dfs(nums,map,target);
        return map.get(target);
    }
    
    private int dfs(int[] nums, Map<Integer,Integer> map, int sum) {
        if (sum < 0) return 0;
        if (sum == 0) return 1;
        if (map.containsKey(sum)) return map.get(sum);
        
        int res = 0;
        for (int i = 0; i < nums.length; i++ ){
            res += dfs(nums,map,sum - nums[i]);
        }
        map.put(sum,res);
        return map.get(sum);  
    }
}


```

## DP
1. Last step
	* dp[target] = sumOf(dp[target-nums[i]), 0 <= i < len
2. Tranfer function
	* dp[i] = sumOf(dp[i-nums[j]]), i - nums[j] >= 0
3. Initial and boundary conditions
	* dp[0] = true
4. Calculation order
	* Init dp[0]
	* Calculate dp[1],dp[2],... dp[target]
	* return dp[target]

```java
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length ; j++) {
                if (i - nums[j] >= 0) dp[i] += dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
```
