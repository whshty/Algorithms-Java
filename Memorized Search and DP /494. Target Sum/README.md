## 1.Brute Force DFS
```java
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int res = 0;
        if( nums == null || nums.length == 0 ) return res;
        return dfs(nums,S,0,res);
    }
    
    private int dfs(int[] nums, int target, int pos ,int res){
        if( pos == nums.length ){
            if( target == 0 ) return 1;
            else return 0;
        }
        return dfs(nums,target+nums[pos],pos+1,res) + dfs(nums,target-nums[pos],pos+1,res);
    }
}
```


## 2.Memorized DFS
* Worst Case : Time : O(2^n)

```java
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int res = 0;
        if( nums == null || nums.length == 0 ) return res;
        return dfs(nums,S,0,res, new HashMap<String,Integer>());
    }
    
    private int dfs(int[] nums, int target, int pos ,int res, Map<String,Integer> map){
        String key = pos + "-" + target;
        if( map.containsKey(key)){
            return map.get(key);
        }
        
        if( pos == nums.length ){
            if( target == 0 ) return 1;
            else return 0;
        }
        int tempRes = dfs(nums,target+nums[pos],pos+1,res,map) + dfs(nums,target-nums[pos],pos+1,res,map);
        map.put(key,tempRes);
        return tempRes;
    }
}
```


## 3.DP : Subset sum 
Let P be the positive subset and N be the negative subset
For example:
Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

Then let's see how this can be converted to a subset sum problem:

```
                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
```

```java
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for( int i : nums ) sum += i;
        
        if( sum < S || ( S + sum ) % 2 > 0 ) return 0;
        else return subsetSum(nums,(S + sum) >>> 1);
    }
    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    } 
}
```
