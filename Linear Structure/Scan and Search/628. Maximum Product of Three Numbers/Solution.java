class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        
        int len = nums.length;
        int resOne = nums[len-1] * nums[len-2] * nums[len-3];
        int resTwo = nums[0] * nums[1] * nums[len-1];
        
        return resOne > resTwo ? resOne : resTwo;
    }
}