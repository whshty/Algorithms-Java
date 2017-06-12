public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if( nums.length == 1 ){
            if(target == nums[0]){
                return new int[]{0,0};
            }
            else return new int[]{-1,-1};
        }
        int start = Solution.firstGreaterOrEqual(nums,target);
        if( start == nums.length || nums[start] != target ){
            return new int[]{-1,-1};
        }
        return new int[]{start, Solution.firstGreaterOrEqual(nums, target + 1) - 1};
        
    }
    public static int firstGreaterOrEqual(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while( low < high ){
            int mid = low + ( high - low ) / 2;
            if( nums[mid] < target ){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}