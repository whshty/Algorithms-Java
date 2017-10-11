https://discuss.leetcode.com/topic/40195/how-we-handle-this-question-on-interview-thinking-process-dp-solution

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        int offset = 1;
        for( int i = 1 ; i < num + 1 ; i++ ){
            if( offset * 2 == i) offset *= 2;
            dp[i] = dp[i-offset] + 1;
        } 
        return dp;   
    }
}