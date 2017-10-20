```java
public class Solution {
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