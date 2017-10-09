public class Solution {
    public int findMin(int[] nums) {
        if ( nums == null) return 0;
        if ( nums.length == 1 ) return nums[0];
        int start = 0 , end = nums.length - 1;
        while ( end - start > 1){
            int mid = (stat + end) >>> 1; 
            if ( nums[mid] > nums[end]){
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[end], nums[start]);
    }
}