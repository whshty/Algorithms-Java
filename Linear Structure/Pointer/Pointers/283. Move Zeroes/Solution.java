public class Solution {
    public void moveZeroes(int[] nums) {
        if( nums == null || nums.length == 0 ) return;
        int index = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] != 0 ){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    
    }
}

// two pointers and minium writes
class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0 , end = nums.length -1;
        while( start < end ){
            if( nums[start] != 0 ){
                start++;
                continue;
            }
            while( start < end ){
                if(nums[end] != 0 ) {
                    break;
                }
                end--;
            }
            if( start < end ){
                swap(nums,start,end);
                start++;
                end--;
            }
        }
    }
    public void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}