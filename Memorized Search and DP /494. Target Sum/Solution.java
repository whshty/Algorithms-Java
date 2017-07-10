public class Solution {
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