class Solution {
    public int deleteAndEarn(int[] nums) {
        int len = 10001;
        int[] dp = new int[len];
        for( int num : nums ){
            dp[num] += num;
        }
        int take = 0 , skip = 0;
        for( int i = 0 ; i < len ; i++ ){
            int curTake = skip + dp[i];
            int curSkip = Math.max(skip,take);
            take = curTake;
            skip = curSkip;
        }
        return Math.max(take,skip);
    }
}
