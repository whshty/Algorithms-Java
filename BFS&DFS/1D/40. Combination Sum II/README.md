```java
public class Solution {
    public List<List<Integer>> combinationSum2(int[] input, int target) {
        Arrays.sort(input);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res,list,input,target,0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> list, int[] input , int target , int pos){
        if( target == 0 ){
            res.add(new ArrayList<Integer>(list));
        }
        if(  target < 0 ) return;
        for( int i  = pos ; i < input.length ; i++ ){
            if( i > pos && input[i] == input[i-1] ) continue;
            list.add(input[i]);
            dfs(res,list,input,target-input[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
```