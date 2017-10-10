class Solution {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        int start = 0 , end = len / 2;
        while( start < end ){
            int mid = ( start + end ) >>> 1;
            if( nums[mid*2] != nums[mid*2+1]) end = mid;
            else start = mid + 1;
        }
        return nums[2*start];     
    }
}