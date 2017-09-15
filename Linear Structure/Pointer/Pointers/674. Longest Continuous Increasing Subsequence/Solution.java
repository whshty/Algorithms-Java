class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if( nums == null || nums.length == 0 ) return 0;
        int res = 1 , count = 1;
        for( int i = 0 ; i < nums.length - 1 ; i++ ){
            if( nums[i] < nums[i+1] )  res = Math.max(res,++count);
            else count = 1;
        }
        return res;   
    }
}