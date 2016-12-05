// time o(n^2)
// space o(n)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        int max = 1;
        // initilziaed 
        for(int i = 0 ; i< nums.length ; i++){
            dp[i] = 1;
        }
        // i : end 
        // j : start 
        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
        
    }
}