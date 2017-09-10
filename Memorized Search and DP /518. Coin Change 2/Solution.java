class Solution {
    public int change(int amount, int[] coins) {
        if( coins == null || coins.length == 0 && amount == 0 ) return 1;
        return helper(coins,0,amount);
    }
    public int helper(int[] nums, int pos , int amount){
        int res = 0;
        if( amount < 0 ) return 0;
        if(amount == 0) return 1;
        for( int i = pos ; i < nums.length ; i++ ){
            res += helper(nums,i,amount-nums[i]);
        }
        return res;
    }
}