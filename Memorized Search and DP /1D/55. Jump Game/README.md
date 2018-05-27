## 1.DP
1. Last step
	* Frog in rock n-1
	* dp[i] == true && n-1-i <= nums[i]

2. Transfer function
	* dp[j] ^= dp[i] && i + nums[i] >= j ( 0 <= i < j )
3. Initial and boundary conditions
	* dp[0] = true
4. Calculation order
	* Init dp[0] 
	* Calculate dp[1],dp[2],... dp[n-1]
	* return dp[n-1]

```java
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i ) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
```



## 2.Greedy
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