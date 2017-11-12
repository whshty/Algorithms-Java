## 1.1.BFS 
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

## 1.2.DFS 
* Time : o(2^n)
* Space : o(n) for stack, o(2^n*n) for result

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        helper(res,new ArrayList<>(),nums,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() -1);
        }
    }
}
```
## 1.2.Bit Manipulation 

```

 i: 0 j: 0 bit cal: 0
 i: 0 j: 1 bit cal: 0
 i: 0 j: 2 bit cal: 0
 i: 1 j: 0 bit cal: 1
 i: 1 j: 1 bit cal: 0
 i: 1 j: 2 bit cal: 0
 i: 2 j: 0 bit cal: 0
 i: 2 j: 1 bit cal: 2
 i: 2 j: 2 bit cal: 0
 i: 3 j: 0 bit cal: 1
 i: 3 j: 1 bit cal: 2
 i: 3 j: 2 bit cal: 0
 i: 4 j: 0 bit cal: 0
 i: 4 j: 1 bit cal: 0
 i: 4 j: 2 bit cal: 4
 i: 5 j: 0 bit cal: 1
 i: 5 j: 1 bit cal: 0
 i: 5 j: 2 bit cal: 4
 i: 6 j: 0 bit cal: 0
 i: 6 j: 1 bit cal: 2
 i: 6 j: 2 bit cal: 4
 i: 7 j: 0 bit cal: 1
 i: 7 j: 1 bit cal: 2
 i: 7 j: 2 bit cal: 4
 
 
0) 0 0 0  -> Dont take 3 , Dont take 2 , Dont take 1 = { } 
1) 0 0 1  -> Dont take 3 , Dont take 2 , take 1 =  {1 } 
2) 0 1 0  -> Dont take 3 , take 2 , Dont take 1 = { 2 } 
3) 0 1 1  -> Dont take 3 , take 2 , take 1 = { 1 , 2 } 
4) 1 0 0  -> take 3 , Dont take 2  , Dont take 1 = { 3 } 
5) 1 0 1  -> take 3 , Dont take 2  , take 1  = { 1 , 3 } 
6) 1 1 0  -> take 3 , take 2 , Dont take 1 = { 2 , 3 } 
7) 1 1 1  -> take 3 , take 2 , take 1  = { 1 , 2 , 3 } 
 
```

```java
class Solution {
    public List<List<Integer>> subsets(int[] input) {
	    Arrays.sort(input);
	    int size = 1 << input.length;
	    List<List<Integer>> res = new ArrayList<>();
	    for (int i = 0 ; i < size ; i++) {
		    List<Integer> set = new ArrayList<>();
		    for (int j = 0 ; j < input.length ; j++) {
                //System.out.println( " i: " + i + " j: " + j + " bit cal: " + (i & (1 << j)));
			    if ((i & (1 << j)) != 0) {
				    set.add(input[j]);
			    }
		    }
		    res.add(set);
	    }
	    return res;
    }
}
```



## 2.Follow-Up:Multiplication
```
For example 
[1,2,3]

start with :
[]
next element 1  :
[1]
next element 2 :
[1] [2] [1*2] =  [1][2]
next element 3 :
[1] [2] [1*3] [2*3]
```

```java
public class Solution {
    public List<Integer> subsets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for( int num : nums ){
            Set<Integer> temp = new HashSet<>();
            for( int i : set ){
                temp.add(i*num);
            }
            set.add(num);
            set.addAll(temp);
        }
        //set.add(0);
        return new ArrayList<>(set);
    }
}
```

## 3.Follow-Up:Iterator

```java
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

## 4.Follow-Up : min(sub) + max(sub) <= k

```java
public class Solution {
    public List<List<Integer>> subsets(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        helper(res,new ArrayList<>(),nums,0 , Integer.MAX_VALUE, Integer.MIN_VALUE , k);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> list, int[] nums, int pos , int min , int max , int k){
        if( min + max >= k ) return;
        res.add(new ArrayList<>(list));
        for(int i=pos;i<nums.length;i++){
            list.add(nums[i]);
            //helper(res,list,nums,i+1,min,max,k);
            helper(res,list,nums,i+1,Math.min(min,nums[i]),Math.max(max,nums[i]),k);
            list.remove(list.size() -1);
        }
    }
}
```

