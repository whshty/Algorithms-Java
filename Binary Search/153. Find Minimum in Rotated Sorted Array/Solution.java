public class Solution {
    public int findMin(int[] nums) {
        if ( nums == null) return 0;
        if ( nums.length == 1 ) return nums[0];
        int start = 0 , end = nums.length - 1;
        while ( start + 1  < end){
            int mid = (start + end) >>> 1; 
            if ( nums[mid] > nums[end]){
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start] , nums[end]);
        //return nums[start]; // if [2,1]
    }
}