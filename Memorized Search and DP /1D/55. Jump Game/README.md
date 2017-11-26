## DP
1. Define status
	* If the frog can jump to n-1, the last step is from i to n -1 ( i < n - 1)
	* dp[i] == true && n-1-i <= nums[i]

2. Status transfer function
	* dp[i] ^= dp[i] && i + nums[i] >= j ( 0 <= i < j )
3. Initial state
	* dp[0] = true
4. Order of calculation
	* Init dp[0] 
	* Calculate dp[1],dp[2],... dp[n-1]
	* return dp[n-1]

```java
public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for( int i = 1 ; i < nums.length ; i++ ){
            for( int j = 0 ; j < i ; j++ ){
                if( dp[j] && j + nums[j] >= i ){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
```



## Greedy
```java 
public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for( int i = 0 ; i < nums.length ; i++){
            if( i > max ) return false;
            max = Math.max( max , nums[i] + i );
        }
        return true;
    }
}
```