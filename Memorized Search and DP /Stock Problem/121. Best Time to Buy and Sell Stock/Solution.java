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
        int res = 0, min = Integer.MAX_VALUE;
        
        for( int i : prices ){
            min = Math.min(min,i);
            res = Math.max(i-min,res);
        }
        return res;
    }
}