class Solution {
    public int maxProfit(int[] prices, int fee) {
        long sell = 0, buy = Integer.MIN_VALUE;
        for (int price : prices) {
            long preSell = sell;
            sell = Math.max(sell, buy + price - fee);
            buy = Math.max(buy, preSell - price);
        }
        return (int)sell;
    }
}