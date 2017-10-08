public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * ( len + 1 ) >>>  1;
        for( int i = 0 ; i < len ; i++ ){
            sum -= nums[i];
        }
        return sum;
    }
}