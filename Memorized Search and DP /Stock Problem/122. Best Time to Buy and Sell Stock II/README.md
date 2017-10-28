### DP + Greedy
```java
class Solution {
    public int maxProfit(int[] prices) {
        int cur = 0 , cost = Integer.MIN_VALUE;
        for( int price : prices ){
            int temp = cur;// cur at i - 1
            cur = Math.max(cur,price+cost);// price[i] + cur[i-1] - price[i-1] 
            cost = Math.max(cost,temp-price);
        }
        return cur;
    }
}
```


### Peak Valley Approach

```java
class Solution {
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length == 0 ) return 0;
        int index = 0;
        int low = prices[0];
        int high = prices[0];
        int maxprofit = 0;
        while (index < prices.length - 1) {
            while (index < prices.length - 1 && prices[index] >= prices[index + 1]) index++;
            low = prices[index];
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) index++;
            high = prices[index];
            maxprofit += high - low;
        }
        return maxprofit;
    }
}

```

### One Pass
* Optimize to solve the situation of continually increasing array

```java
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for( int i = 0 ; i < prices.length - 1; i++){
            if( prices[i+1] > prices[i] ){
                res +=  prices[i+1] - prices[i];
            }
        }
        return res;
    }
}
```