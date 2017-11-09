## DFS

```
input = [2,3,6,7] and target = 7

[
  [7],
  [2, 2, 3]
]

```

```java
public class Solution {
    public List<List<Integer>> combinationSum(int[] input, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if( input == null || input.length == 0 ) return res;
        dfs(input,target,res,new ArrayList<>(),0);
        return res;
    }
    private void dfs(int[] input, int sum, List<List<Integer>> res, List<Integer> list, int pos){
        if( sum < 0 ) return;
        if( sum == 0 ){
            res.add(list);
            return;
        }
        for( int i = pos ; i < input.length ; i++ ){
            List<Integer> tempList = new ArrayList<>(list);
            tempList.add(input[i]);
            dfs(input, sum - input[i],res,tempList,i);
        }
    }
}
```