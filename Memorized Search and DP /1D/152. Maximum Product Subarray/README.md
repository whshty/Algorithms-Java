## 1.DP
1. 最后一步:对于最优的策略(乘积最大)，一定有最后一个元素a[j]
	* 第一种情况:最优策略的序列就是{a[j]}，答案是a[j]
	* 第二种情况，连续子序列长度大于1，那么最优策略中a[j]前一个元素肯 定是a[j-1].
	* 但是如果a[j]是正数，我们希望以a[j-1]结尾的连续子序列乘积最大; 如果a[j]是负数，我们希望以a[j-1]结尾的连续子序列乘积最小
	* 同时保留两个极值
	* 可以同时做两个问题:求以a[j]结尾的连续子序列的最大乘积和以a[j]结尾的连续子序列的最小乘积
	* 两种情况都需要求以a[j-1]结尾的乘积最大/小连续子序列
2. 转移方程
	* `f[j] = max{ a[j], max{a[j]*f[j-1], a[j]*g[j-1]}| j>0}`
	* f[j] =  以a[j]结尾的连续子序列的最大乘积
	* a[j] : 情况1:子序列 就是a[j]本身
	* `max{a[j]*f[j-1], a[j]*g[j-1]}` : 情况2:以a[j-1]结尾的连续子序 列的最大/最小乘积，乘上a[j]
	* g[j] =以a[j]结尾的连续子序列的最小乘积
	* `g[j] = min{ a[j], min{a[j]*f[j-1], a[j]*g[j-1]}| j>0}`
3. 初始条件和边界情况
	* 没有初始条件
4. 计算顺序
	* f[j] =以a[j]结尾的连续子序列的最大乘积
	* g[j] =以a[j]结尾的连续子序列的最小乘积
	* 答案是max{f[0], f[1], f[2], ..., f[n-1]}


```
class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        
        min[0] = max[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            
            res = Math.max(res, max[i]);
        }
        
        return res;
    }
}
```



## Scan
* Main two values
* max for postive 
* min for negative

```
class Solution {
    public int maxProduct(int[] nums) {
        if( nums == null || nums.length == 0 ) return 0;
        int res = nums[0], min = res, max = res;
        for( int i = 1 ; i < nums.length ; i++ ){
            if(nums[i] >= 0 ){
                max = Math.max(nums[i], max*nums[i]);
                min = Math.min(nums[i], min*nums[i]);  
            } else {
                int temp = max;
                max = Math.max(nums[i],min*nums[i]);
                min = Math.min(nums[i],temp*nums[i]);
            }
            //res = Math.max(res,max);
            if( max > res ){
                res = max;
            }
        }
        return res;
    }
}
```

### Follow-up return start index and end index