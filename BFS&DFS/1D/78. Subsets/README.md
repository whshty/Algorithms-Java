### BFS 
* Tims : o(2^n)
* Space : o(2^n*n)


```
For example 
[1,2,3]

start with :
[]
next element 1  :
[] [1]
next element 2 :
[] [2] [1] [1,2]
next element 3 :
[] [3] [2] [2，3] [1] [1,3] [1,2] [1,2,3] 

```

## Code

```java
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for( int num : nums ){
            int size = res.size();
            for( int i = 0 ; i < size ; i++ ){
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }
}


```

### DFS 
* Time : o(2^n)
* Space : o(n) for stack, o(2^n*n) for result

## Code

```java
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() -1);
        }
    }
}
```

## Follow-Up:Multiplication

```java
public class Solution {
    public List<Integer> subsets(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for( int num : nums ){
            List<Integer> temp = new ArrayList<>();
            for( int i = 0 ; i < res.size() ; i++ ){
                int cur = res.get(i);
                temp.add(cur*num);
            }
            res.add(num);
            res.addAll(temp);
        }
        res.add(0);
        return res;
    }
}


```

## Follow-Up:Iterator

```
class myCode {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add( new ArrayList<>());
        for( int i : nums ){
            int size = res.size();
            for( int j = 0 ; j < size ; j++){
                List<Integer> newList = new ArrayList<>(res.get(j));
                newList.add(i);
                res.add(newList);
            }
        }
        return res;
    }
    public List<Integer> next(List<List<Integer>> subset){
        List<Integer> res = subset.get(0);
        subset.remove(res);
        return res;
    }
}

```



