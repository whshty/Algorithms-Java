## DP ( Based on House Robber 1 )
```java
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int len = nums.length;
        // no steal house 0
        int[] temp = new int[len-1];
        for( int i = 0 ; i < len - 1 ; i++ ){
            temp[i] = nums[i+1];
        }
        int res1 = helper(temp);
        // no steal house 1
        for( int i = 0 ; i < len - 1 ; i++ ){
            temp[i] = nums[i];
        }
        int res2 = helper(temp);
        return Math.max(res1,res2);
    }
    // house rober 1 
    public int helper(int[] nums) {
        int notVisitedPrevious = 0;
        int visitedPrevious = 0 ;
        for( int num : nums ){
            int temp = notVisitedPrevious;
            notVisitedPrevious = Math.max(notVisitedPrevious,visitedPrevious);
            visitedPrevious = num + temp;
        }
        return Math.max(notVisitedPrevious,visitedPrevious);
    }
}
```
## DP

```java
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int prev0 = 0,curr0 = 0, prev1 = 0, curr1 = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            int temp0 = prev0;
            prev0 = curr0;
            curr0 = Math.max(temp0 + nums[i], prev0);
            int temp1 = prev1;
            prev1 = curr1;
            curr1 = Math.max(temp1 + nums[i + 1], prev1);
        }
        return Math.max(curr1,curr0);
    }
}
```