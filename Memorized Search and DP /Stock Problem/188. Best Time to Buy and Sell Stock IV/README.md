## DP
```java
class Solution {
    public int maxProfit(int k, int[] prices) {
        if ( k >= prices.length >>> 1) {
            int cur = 0, cost = Integer.MIN_VALUE;
    
            for (int price : prices) {
                int temp = cur;
                cur = Math.max(cur, cost + price); // cur[i-1] - price[i-1] + price[i]
                cost = Math.max(cost, temp  - price);
            }
            return cur;
        }
        
        int[] cur = new int[k + 1];
        int[] cost = new int[k + 1];
        Arrays.fill(cost, Integer.MIN_VALUE);
        
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                cur[j] = Math.max(cur[j], cost[j] + price);
                cost[j] = Math.max(cost[j], cur[j - 1] - price);
            }
        }
        return cur[k];
    }
}
```