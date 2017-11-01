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


class Solution {
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