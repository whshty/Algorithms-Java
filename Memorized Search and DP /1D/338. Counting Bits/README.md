## DP
1. Last step
	* For example, bitcount[5] == bitcount[2] + (5 & 1)
2. Transfer function
	* dp[i] = dp[i>>1] + (i & 1);
3. Initial and boundary conditions
	* dp[0] = 0
4. Calculation order
	* Init dp[0]
	* Calculate dp[1],dp[2],... dp[n]
	* return dp[]


```java
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for (int i = 1; i < num + 1; i++ ){
            dp[i] = dp[i>>1] + (i & 1);
        } 
        return dp;   
    }
}
```

```java
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        int offset = 1;
        for( int i = 1 ; i < num + 1 ; i++ ){
            if( offset * 2 == i) offset *= 2;
            dp[i] = dp[i-offset] + 1;
        } 
        return dp;   
    }
}
```