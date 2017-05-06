public class Solution {
    int res = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        if( nums == null || nums.length == 0 ) return res;
        helper(nums,S,0,0);
        return res;
    }
    
    public void helper(int[] nums, int target ,int pos ,long eval){
        if( pos == nums.length ){
            if( target == eval ){
                res++;
            }
            return;
        }
        helper(nums,target,pos+1,eval+nums[pos]);
        helper(nums,target,pos+1,eval-nums[pos]);
    }
}