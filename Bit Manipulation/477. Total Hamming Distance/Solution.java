class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++ ){
            for( int j = i + 1 ; j < nums.length ; j++ ){
                count += hammingDistance(nums[i],nums[j]);
            }
        }
        return count;
    }
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}