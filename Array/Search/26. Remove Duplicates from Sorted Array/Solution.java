public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for( int n : nums ){
            if( index == 0 || n > nums[index-1] ){
                nums[index++] = n;
            }
        }
        return index;
    }
}