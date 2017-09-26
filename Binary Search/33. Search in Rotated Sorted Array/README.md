```
class Solution {
    public int search(int[] nums, int target) {
        if( nums == null || nums.length == 0 ) return -1;
        int start = 0 , end = nums.length - 1;
        
        while( start <= end ){
            int mid = ( start + end ) >>> 1;
            if( nums[mid] == target ) return mid;
            // eg. 3,4,5,6,1,2
            if( nums[mid] > nums[end]){
                if( nums[mid] < target || nums[end] >= target ){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            // eg. 5,6,1,2,3,4
            else {
                if( nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        if( nums[start] != target ) return -1;
        else return start;
    }
}
```