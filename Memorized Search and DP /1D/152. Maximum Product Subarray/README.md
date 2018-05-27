## 1.DP
1. Last step: Assume the last element of result is a[j]
	* The result is a[j] if there is only one element
	* If the length of array is bigger than one, the element in the front of a[j] is a[j-1]
	* If a[j] is postive，we hope a[j-1] has the max product result; if a[j] is negative，a[j-1] product array should have the min value
	* Keep two array min and max at the same time
	* Calculate the max and min result of product array of a[j] at the same time
	* Both situtaion need max and min product array result of a[j-1]
2. Transfer function
	* `max[j] = max{ a[j], max{a[j]*max[j-1], a[j]*min[j-1]}| j>0}`
	* `max{a[j]*max[j-1], a[j]*min[j-1]}` 
	* `g[j] = min{ a[j], min{a[j]*f[j-1], a[j]*g[j-1]}| j>0}`
3. Initial and boundary conditions
	* None
4. Calculation order
	* max[j] = max product array result of a[j]
	* min[j] = min product array result of a[j]
	* The anser is max{max[0], max[1], max[2], ..., max[n-1]}


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