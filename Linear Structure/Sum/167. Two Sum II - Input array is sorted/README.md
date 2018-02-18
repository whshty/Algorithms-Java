* O(n)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int start = 0, end = nums.length - 1;
        while( start <= end ){
            if( nums[start] + nums[end] < target){
                start++;
            } else if( nums[start] + nums[end] > target ){ 
                end--;
            } else {
                res[0] = start + 1;
                res[1] = end + 1 ;
                return res;
            }
        }
        return res;
    }
}
```