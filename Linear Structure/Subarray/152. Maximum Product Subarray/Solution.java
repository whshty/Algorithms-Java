class Solution {
    public int maxProduct(int[] nums) {
        if( nums == null || nums.length == 0 ) return 0;
        int res = nums[0], min = res, max = res;
        for( int i = 1 ; i < nums.length ; i++ ){
            if(nums[i] >= 0 ){
                max = Math.max(nums[i], max*nums[i]);
                min = Math.min(nums[i], min*nums[i]);  
            } else {
                int temp = max;
                max = Math.max(nums[i],min*nums[i]);
                min = Math.min(nums[i],temp*nums[i]);
            }
            //res = Math.max(res,max);
            if( max > res ){
                res = max;
            }
        }
        return res;
    }
}