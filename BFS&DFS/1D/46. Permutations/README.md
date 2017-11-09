## 1.1.BFS
* Time : O(n!)
* Space : O(n!)

```
				[]
				[1]
		[1,2]                     [2,1]
[3,1,2],[1,3,2],[1,2,3]   [3,2,1],[2,3,1],[2,1,3]
```

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        res.add(new ArrayList<Integer>());
        
        for( int i = 0 ; i < nums.length ; i++ ){
            List<List<Integer>> nextRes = new ArrayList<>();
            for( List<Integer> list : res ){
                for( int j = 0 ; j <= list.size() ; j++ ){
                    List<Integer> nextList = new ArrayList<>(list);
                    nextList.add(j,nums[i]);
                    nextRes.add(nextList);
                }
            }
            res = nextRes;
        }
        return res;
    }
}
```

## 1.2.DFS
* Time O(n! * n )
* space O(n)

```java
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums,res,list);
        return res;
    }
    private void dfs(int nums[], List<List<Integer>> res, List<Integer> list ){
        if( list.size() == nums.length ){
            res.add(new ArrayList<Integer>(list));
            return;
        } 
        for( int i = 0 ; i < nums.length ; i++ ){
            if( !list.contains(nums[i])){
                list.add(nums[i]);
                dfs(nums,res,list);
                list.remove(list.size()-1);
            }
        }
    }
}
```

## 1.3.DFS + Swap
* Time O(n! )
* Space O(n)

```
1 2 3
index = 0       index = 1    
[2 1 3,3 2 1]   [1 3 2] 
index = 1
[2 3 1,3 1 2]  
```

```java
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if( nums == null || nums.length == 0 ) return res;
        dfs(nums,res,0);
        return res;
        
    }
    private void dfs(int[] nums, List<List<Integer>> res, int pos ){
        if( pos == nums.length ){
            List<Integer> list = new ArrayList<>();
            for( int num : nums ){
                list.add(num);
            }
            res.add(list);
            return;
        }
        for( int i = pos ; i < nums.length ; i++ ){
            if( i== pos ) {
                dfs(nums,res,pos+1);
                continue;
            }   
            swap(nums,i,pos);
            dfs(nums,res,pos+1);
            swap(nums,i,pos);
        }
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```

## 2.Follow-Up : Permute String

```java
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> res =  sol.permuteString("abc");
        System.out.println(res);
    }

    public List<String> permuteString(String s) {
        List<List<Character>> lists = permuteCharArray(s.toCharArray());

        List<String> res = new ArrayList<>();
        for(List<Character> list : lists){
            res.add(list.toString());
        }
        return res;
    }

    public List<List<Character>> permuteCharArray(char[] chs) {
        List<List<Character>> res = new ArrayList<>();
        if (chs == null || chs.length == 0) return res;
        res.add(new ArrayList<>());
        for (int i = 0; i < chs.length; i++) {
            List<List<Character>> nextRes = new ArrayList<>();
            for (List<Character> list : res) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Character> nextList = new ArrayList<>(list);
                    nextList.add(j, chs[i]);
                    nextRes.add(nextList);
                }
            }
            res = nextRes;
        }
        return res;
    }
}

```