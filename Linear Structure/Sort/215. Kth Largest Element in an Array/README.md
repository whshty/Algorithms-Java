### 1.Brute force
* O(nlgn) + O(1)

```java
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

```

### 2.Min heap
* Use a min head that will store the kth largest values;
* Iterate over the whole input and  maintains the size of head 
* O(n*lgk) running time + O(K) memory

```java
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for( int i : nums){
            heap.offer(i);
            if( heap.size() > k ){
                heap.poll();
            }
        }
        return heap.peek();
    }
}

```

### 3.Quick select
* put nums that are <= pivot to the left 
* Put nums that are > pivot to the right
* Count the nums that are smaller than pivot from start
* If the count is k, return index 
* Average O(n)

Set nums[right] as the pivot, set i = lo , j = hi
Put all the numbers that are greater the pivot to the right

```
l ----- r 
5 2 1 4 3

i ----- j 
3 is the pivot, since 5 (a[i++]) > pivot, put 5 to the right
4 2 1 5 3 
i     j

since 4 is larger than pviot, swap 4 and 1 

1 2 4 5 3 
i   j

1 2 4 5 3 
    j
    i
    
1 2 3 5 4

--i makes sure we can still check a[i] after the swap, and --j makes sure we won't overwrite the ones that are already done.

```


```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums,0,len-1,len-k+1);
    }
    
    public int quickSelect(int[] nums, int start , int end , int k){
        int i = start , j = end, pivot = nums[end];
        while( i < j ) {
            if( nums[i++] > pivot ) {
                swap(nums,--i,--j);
            }
        }
        swap(nums,i,end);
        int index = i - start + 1;
        if( index == k ) return nums[i];
        else if( index > k ) return quickSelect(nums,start,i-1,k);
        else return quickSelect(nums,i+1,end,k-index);
    }
    public void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### 4. Follow-up(Find kth in 2D)

```

public class Solution {
    public List<int[]> findKth2D(List<int[]> list, int k){
        int[] nums = new int[list.size()];
        Map<Integer,List<int[]>> map = new HashMap<>();

        for( int i = 0 ; i < list.size() ; i++ ){
            int[] temp = list.get(i);
            nums[i] = temp[0] * temp[0] + temp[1] * temp[1];
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(temp);
        }

        int kVal = findKthLargest(nums,k);
        return map.get(kVal);
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums,0,len-1,len-k+1);
    }

    public int quickSelect(int[] nums, int start , int end , int k){
        int i = start , j = end, pivot = nums[end];
        while( i < j ) {
            if( nums[i++] > pivot ) {
                swap(nums,--i,--j);
            }
        }
        swap(nums,i,end);
        int index = i - start + 1;
        if( index == k ) return nums[i];
        else if( index > k ) return quickSelect(nums,start,i-1,k);
        else return quickSelect(nums,i+1,end,k-index);
    }
    public void swap(int[] nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


```