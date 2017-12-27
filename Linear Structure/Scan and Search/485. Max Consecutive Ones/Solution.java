class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0 , res = 0;
        for( int num : nums ){
            if ( num == 1 ){
                count++;
                res = Math.max(count,res);
            } else count = 0;
        }
        return res;
    }
}