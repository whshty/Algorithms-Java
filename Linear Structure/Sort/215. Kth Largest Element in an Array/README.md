### Brute force
* O(nlgn) + O(1)

```
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

```

### Min heap
* Use a min head that will store the kth largest values;
* Iterate over the whole input and  maintains the size of head 
* O(n*lgk) running time + O(K) memory

```
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

### Quick select )
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


```
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int pos = quickSelect(nums, 0 , n - 1 , n- k + 1);
        return nums[pos];
    }
    public int quickSelect(int[] nums, int left , int right , int k){
        int i = left , j = right , pivot = nums[right];
        while( i < j ){
            if( nums[i++] > pivot ){
                swap(nums,--i,--j);
            }
        }
        swap(nums,i,right);
            
        int pos = i - left + 1;
        if( pos == k) return i;
        else if( pos > k ) return quickSelect(nums,left,i-1,k);
        else return quickSelect(nums,i+1,right,k-pos);
    }
    public void swap(int[] n, int i , int j){
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}
```

