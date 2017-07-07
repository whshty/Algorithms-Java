public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int prev0 = 0,curr0 = 0, prev1 = 0, curr1 = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            int temp0 = prev0;
            prev0 = curr0;
            curr0 = Math.max(temp0 + nums[i], prev0);
            int temp1 = prev1;
            prev1 = curr1;
            curr1 = Math.max(temp1 + nums[i + 1], prev1);
        }
        return Math.max(curr1,curr0);
    }
}