## 1.DP
1. Define status
	* 最后一步:如果青蛙能跳到最后一块石头n-1，我们考虑它跳的最后一步
	* dp[i] == true && n-1-i <= nums[i]

2. 转移方程
	* dp[i] ^= dp[i] && i + nums[i] >= j ( 0 <= i < j )
3. 初始条件和边界情况
	* dp[0] = true
4. 动态规划组成部分四:计算顺序
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