class Solution {
    public int maxProfit(int[] prices) {
        int sellOne = 0, sellTwo = 0;
        int buyOne = Integer.MIN_VALUE, buyTwo = Integer.MIN_VALUE;
        
        for( int i = 0 ; i < prices.length ; i++ ){
            // Use max because buyone is assign as Integer.MIN_VALUE
            buyOne = Math.max(buyOne,-prices[i]); 
            sellOne = Math.max(sellOne,buyOne+prices[i]);
            // We already have sell1 money, so after buying stock2 we have buy2 = sell1 - price[i] money left
            // we want more money left, so we make it max
            buyTwo = Math.max(buyTwo,sellOne-prices[i]);
            // find the max money left + current price
            sellTwo = Math.max(sellTwo,buyTwo+prices[i]);
        }
        return sellTwo;
    }
}