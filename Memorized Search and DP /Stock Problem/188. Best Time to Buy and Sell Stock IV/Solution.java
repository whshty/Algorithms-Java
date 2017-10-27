class Solution {
    public int maxProfit(int k, int[] prices) {
        if ( k >= prices.length >>> 1) {
            int sell = 0, buy = Integer.MIN_VALUE;
    
            for (int price : prices) {
                int temp = sell;
                sell = Math.max(sell, buy + price);
                buy = Math.max(buy, temp  - price);
            }
            return sell;
        }
        
        int[] sell = new int[k + 1];
        int[] buy = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                sell[j] = Math.max(sell[j], buy[j] + price);
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
            }
        }
        return sell[k];
    }
}