public class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        for(int i = 1;i<nums.length;i++){
            curSum = Math.max(curSum+nums[i],nums[i]);
            maxSum = Math.max(maxSum,curSum);
        }
        return maxSum;
    }
}