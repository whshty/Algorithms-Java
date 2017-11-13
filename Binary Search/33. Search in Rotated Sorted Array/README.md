## 1.Binary Search
* Search the min value, which is the rotated break point
* Binary search based on break point 

```java
class Solution {
    public int search(int[] nums, int target) {
        if( nums == null || nums.length == 0 ) return -1;
        int minIndex = getMinIndex(nums);
        if (target == nums[minIndex]) return minIndex;
        int len = nums.length;
        
        int start, end;
        // 3,4,5,6,7,1,2 and target = 1
        if( target <= nums[len-1]){
            start = minIndex;
            end = len - 1;
        } else {
            start = 0;
            end  = minIndex;
        }
            
        while (start <= end) {
            int mid = ( start + end ) >>> 1;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int getMinIndex(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = ( start + end ) >>> 1 ;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
	    return start;// can also return end
    }
}
```


## 2.Two Pointers
```java
class Solution {
    public int search(int[] nums, int target) {
        if( nums == null || nums.length == 0 ) return -1;
        int start = 0 , end = nums.length - 1;
        
        while( start <= end ){
            int mid = ( start + end ) >>> 1;
            if( nums[mid] == target ) return mid;
            // eg. 3,4,5,6,7,1,2
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