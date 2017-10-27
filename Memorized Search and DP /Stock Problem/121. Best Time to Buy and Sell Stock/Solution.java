class Solution {
    public int maxProfit(int[] prices) {
        int cur = 0, cost = Integer.MIN_VALUE;
        
        for (int price : prices) {
            cur = Math.max(cur, cost + price);
            cost = Math.max(cost, -price);
        }
        return cur;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for( int i = 0 ; i < prices.length ; i++){
            min = Math.min(prices[i],min);
            res = Math.max(prices[i] - min, res);
        }
        return res;
    }
}