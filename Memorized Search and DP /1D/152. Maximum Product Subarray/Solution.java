class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        min[0] = max[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            
            res = Math.max(res, max[i]);
        }
        
        return res;
    }
}


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