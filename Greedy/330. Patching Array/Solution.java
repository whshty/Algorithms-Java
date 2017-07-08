public class Solution {
    public int minPatches(int[] nums, int n) {
        long max = 0;
        int count = 0;
        int index = 0;
        while( max < n ){
            if( index >= nums.length || max < nums[index] - 1 ){
                max += max + 1;
                count++;
            } else{
                max += nums[index];
                index++;
            }
        }
        return count;
    }
}