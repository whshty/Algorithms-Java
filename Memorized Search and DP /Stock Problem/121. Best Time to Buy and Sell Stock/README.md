### 1.DP
* Cur : How much money we have, should choose max value
* cost : How much money will cost, should choose min value

```java
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
```

### 2.Scan
* Update two values : res and min

```java
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
```