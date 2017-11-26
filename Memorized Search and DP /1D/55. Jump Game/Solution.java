public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for( int i = 1 ; i < nums.length ; i++ ){
            for( int j = 0 ; j < i ; j++ ){
                if( dp[j] && j + nums[j] >= i ){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}

public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for( int i = 0 ; i < nums.length ; i++){
            if( i > max ) return false;
            max = Math.max( max , nums[i] + i );
        }
        return true;
    }
}