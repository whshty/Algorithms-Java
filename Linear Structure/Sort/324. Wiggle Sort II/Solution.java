public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int mid;
        if( nums.length % 2 == 0 ) mid = nums.length / 2 - 1;
        else mid = nums.length / 2;
        
        int index = 0; 
        for( int i = 0 ; i <= mid ; i++ ){
            res[index] = nums[mid-i];
            if( index + 1 < nums.length ){
                res[index+1] = nums[nums.length-i-1];
            }
            index = index + 2;
        }
        for( int i = 0 ; i < nums.length ; i++ ){
            nums[i] = res[i];
        }
    }
}
// 1 2 3 4 5 6  mid = 2
// 3 6 2 5 1 4  