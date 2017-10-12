class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0 , preSell = 0 , buy = Integer.MIN_VALUE , preBuy = buy;
        for( int i : prices ){
            preBuy = buy;
            buy = Math.max(preSell - i,preBuy);
            preSell = sell;
            sell = Math.max(preBuy + i,preSell);
        }
        return sell;
    }
}