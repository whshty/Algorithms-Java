public class Solution {
    public int findMaxSum(int[] nums){
        if( nums.length == 0 ) return 0;
        if( nums.length == 1 ) return nums[0];

        int pre = 0;
        int cur = nums[0];
        int preNew;

        for( int i = 1 ; i < nums.length ; i++ ){
            preNew = Math.max(pre,cur);
            cur = pre + nums[i];
            pre = preNew;
        }
        return Math.max(pre,cur);
    }
}