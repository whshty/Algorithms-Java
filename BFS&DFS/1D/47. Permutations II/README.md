### BFS + Set

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<Integer>());
        
        for(int i = 0; i< nums.length;i++){
            //next level
            Set<List<Integer>> nextRes = new HashSet<>();
            // for each list in line
            for(List<Integer> list: res){
                for(int j = 0 ; j < list.size()+1 ; j++){
                    //copy a list to nextList
                    List<Integer> nextList = new ArrayList<Integer>(list);
                    //for each postion in list
                    //left - mid - right
                    nextList.add(j,nums[i]);
                    nextRes.add(nextList);
                }
            }
            // move to next level
            res = nextRes;
        }
        return new ArrayList<>(res);
    }
}

```

### DFS + Set

```java
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        dfs(nums,res,0);
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, int pos){
        if( pos == nums.length ){
            List<Integer> list = new ArrayList<>();
            for( int num : nums ){
                list.add(num);
            }
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for( int i = pos ; i < nums.length ; i++ ){
            if( set.add(nums[i])){
                swap(nums,i,pos);
                dfs(nums,res,pos+1);
                swap(nums,i,pos);
            }
        }
    }
    private void swap(int[] a , int i , int j ){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```

