class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if( nums.length == 0 || nums.length * nums[0].length != r * c ) return nums;
        int[][] res = new int[r][c];
        
        int index = 0;
        for( int[] row : nums ){
            for ( int i : row ) {
                res[index/c][index%c] = i;
                index++;
            }
        }
        return res;
    }
}