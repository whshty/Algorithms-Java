class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for ( int i = 0 ; i < 32 ; i++ ) {
            int count = 0;
            for( int j = 0 ; j < nums.length ; j++ ){
                if( ((nums[j] >> i) & 1 ) == 1 ){
                    count++;
                    count %= 3;
                }
            }
            if( count != 0 ) res |= count << i;
        }
        return res;
    }
}