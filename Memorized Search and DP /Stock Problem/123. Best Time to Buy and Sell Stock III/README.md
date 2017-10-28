### DP
* cost1 means that we have to borrow money from others, we want to borrow less so that we have to make our balance as max as we can(because this is negative)
* cur1 means we decide to sell the stock
* cost2 means we want to buy another stock
* cur2 means we want to sell stock2, this will be the result

```
input:[1,1,1,1,5,8,1]
output:7

```
```java
class Solution {
    public int maxProfit(int[] prices) {
        int curOne = 0, curTwo = 0;
        int costOne = Integer.MIN_VALUE, costTwo = Integer.MIN_VALUE;
        
        for( int price : prices ){
            costOne = Math.max(costOne , -price); 
            curOne = Math.max(curOne , costOne + price);
            // We already have curOne money
            // so after buying stock2 we have costTwo = curOne - price money left
            costTwo = Math.max(costTwo , curOne - price);
            // find the max money left + current price
            curTwo = Math.max(curTwo , costTwo + price);
        }
        return curTwo;
    }
}
```