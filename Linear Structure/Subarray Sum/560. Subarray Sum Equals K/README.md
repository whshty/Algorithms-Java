### Map

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        if( nums == null || nums.length == 0 ) return 0;
        int sum = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        
        for( int i = 0 ; i < nums.length ; i++ ){
            sum += nums[i];
            if(map.containsKey(sum-k)) count += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}
```

### Avoid overflow

```
class Solution {
    public int subarraySum(int[] nums, int k) {
        if( nums == null || nums.length == 0 ) return 0;
        int sum = 0;
        int count = 0;
        Map<Long,Integer> map = new HashMap<>();
        map.put(new Long(0),1);
        for( int i = 0 ; i < nums.length ; i++ ){
            sum += nums[i];
            if(map.containsKey(new Long(sum-k))) count += map.get(new Long(sum-k));
            map.put(new Long(sum),map.getOrDefault(new Long(sum),0) + 1);
        }
        return count;
    }
}
```

