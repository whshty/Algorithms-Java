class Solution {
    public int dominantIndex(int[] nums) {
        int maxOne = 0 , maxTwo = 0, index = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            if( maxOne < nums[i]){
                maxTwo = maxOne;
                maxOne = nums[i];
                index = i;
            } else if ( maxTwo < nums[i]){
                maxTwo = nums[i];
            }
        }
        return ( maxOne >= maxTwo * 2 ) ? index : -1;
    }
}
