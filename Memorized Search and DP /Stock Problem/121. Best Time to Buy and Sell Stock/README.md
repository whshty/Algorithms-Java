### 1.DP
* Sell : How much money we have, should choose max value
* Buy : How much money will cost, should choose min value

```java
class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = Integer.MIN_VALUE;
        
        for (int price : prices) {
            sell = Math.max(sell, buy + price);
            buy = Math.max(buy, -price);
        }
        return sell;
    }
}
```

### 2.Scan
* Update two values : res and min

```java
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
```