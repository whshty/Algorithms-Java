```java
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if( nums == null || nums.length == 0) return 0;
        int sum = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1); 
        for( int i = 0; i < nums.length ; i++){
            sum += nums[i];
            map.putIfAbsent(sum,i);
            if( map.containsKey(sum - k) ){
                res = Math.max( res, i - map.get(sum-k) );
            }
        }
        return res;
    }
}
```