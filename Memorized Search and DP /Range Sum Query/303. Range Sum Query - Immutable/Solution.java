public class NumArray {
    int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length];
        int sum = 0;
        for( int i = 0; i < nums.length ; i++ ){
            sum += nums[i];
            dp[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if( i == 0 ) return dp[j];
        return dp[j] - dp[i-1];
    }
}