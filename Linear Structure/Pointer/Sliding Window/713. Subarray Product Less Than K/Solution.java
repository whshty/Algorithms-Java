class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) return 0;
            
        int res = 0;
        int product = 1;
        
        int start = 0, end = 0;
        while( end < nums.length ){
            product *= nums[end];
            while ( start < nums.length && product >= k) {
                product /= nums[start++];    
            }
            res += end - start + 1;
            end++;
        }
        return res;
    }
}