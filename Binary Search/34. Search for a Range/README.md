```java
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if( nums.length == 1 ){
            if(target == nums[0]){
                return new int[]{0,0};
            } else return new int[]{-1,-1};
        }
        int firstIndex = binarSeary(nums,target);
        if( firstIndex == nums.length || nums[firstIndex] != target ){
            return new int[]{-1,-1};
        }
        return new int[]{firstIndex, binarSeary(nums, target + 1) - 1};
        
    }
    public int binarSeary(int[] nums, int target){
        int start = 0;
        int end = nums.length;
        while( start < end ){
            int mid = ( start + end ) >>> 1;
            if( nums[mid] < target ){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
```