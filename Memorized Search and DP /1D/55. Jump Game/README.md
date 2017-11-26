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



## DP(Compress Space)