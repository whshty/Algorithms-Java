### Three pointers

```java
public class Solution {
    public List<List<Integer>> threeSum(int[] n) {
        List<List<Integer>> res = new ArrayList<>();
        if( n == null || n.length == 0) return res;
        Arrays.sort(n);
        for(int i = 0 ; i< n.length - 2 ; i++){
            if ( i -1 >= 0  && n[i] == n[i-1]) continue;
            int start = i + 1, end = n.length - 1;
            while(start < end){
                int sum = n[i] + n[start] + n[end];
                if( sum == 0 ){
                    res.add(Arrays.asList(n[i],n[start],n[end]));
                    start++;
                    end--;
                    while( start < end && n[start] == n[start-1]) {
                        start++;
                    }
                    while( start < end && n[end] == n[end+1]){
                        end--;
                    } 
                }
                else if ( sum < 0) start++;
                else end--;
            }
        }
        return res;
    }
}
```