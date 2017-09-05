### Brute Force DFS 
```
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

### Memo DFS

```
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if( nums == null || nums.length == 0 || target <= 0 ){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        helper(nums,map,target);
        return map.get(target);
    }
    
    private int helper(int[] nums, Map<Integer,Integer> map, int sum ){
        if( sum < 0 ) return 0;
        if( sum == 0 ) return 1;
        if( map.containsKey(sum)) return map.get(sum);
        
        int res = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            if(map.containsKey(sum)) res += map.get(sum);
            else res += helper(nums,map,sum - nums[i]);
        }
        map.put(sum,res);
        return map.get(sum);  
    }
}

```

### DP
* Based on the recurison rule of memo DFS
* Recurison rule : helper(i) = sumOf(helper(i-nums[j])), i - nums[j] >= 0
* Induction rule : dp[i] = sumOf(dp[i-nums[j]]), i - nums[j] >= 0

```
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for( int i = 1 ; i < dp.length ; i++){
            for( int j = 0 ; j < nums.length ; j++ ){
                if( i - nums[j] >= 0 ){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}

```
