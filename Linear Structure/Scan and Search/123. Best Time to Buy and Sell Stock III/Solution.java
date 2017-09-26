class Solution {
    public int maxProfit(int[] prices) {
        int sellOne = 0, sellTwo = 0;
        int buyOne = Integer.MIN_VALUE, buyTwo = Integer.MIN_VALUE;
        
        for( int i = 0 ; i < prices.length ; i++ ){
            buyOne = Math.max(buyOne,-prices[i]);
            sellOne = Math.max(sellOne,buyOne+prices[i]);
            
            buyTwo = Math.max(buyTwo,sellOne-prices[i]);
            sellTwo = Math.max(sellTwo,buyTwo+prices[i]);
        }
        return sellTwo;
        
    }
}