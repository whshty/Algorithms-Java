public class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums.length == 0 ) return 0;
        int index = 0;
        for( int  n : nums ){
            if( index == 0 || n > nums[index-1]){
                nums[index++] = n;
            }
        }
        return index;
    }
}
 
 
public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for( int i = 1 ; i < nums.length ; i++ ){
            if( nums[i] != nums[index] ){
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
