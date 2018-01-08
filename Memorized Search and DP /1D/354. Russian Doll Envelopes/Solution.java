class Solution {
    public int maxEnvelopes(int[][] input) {
        if ( input == null || input.length == 0 ) return 0;
        int len = input.length;
        Arrays.sort(input, (a, b) -> a[0] - b[0]);
        
        int[] dp = new int[len];
        int res = 0;
        for( int i = 0 ; i < len ; i++ ){
            dp[i] = 1;
            for ( int j = 0 ; j < i ; j++ ){
                if( input[j][0] < input[i][0] && input[j][1] < input[i][1] ){
                    dp[i] = Math.max(dp[j] + 1 , dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}