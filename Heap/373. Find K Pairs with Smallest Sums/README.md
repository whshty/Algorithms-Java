### Brute Force
* O(k^2 * lg(k^2))
* Add k^2 pairs to heap

```
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        
        if( nums1.length == 0 || nums2.length == 0 || k == 0 ) return res;
        for( int i = 0 ; i < nums1.length &&  i < k ; i++ ) {
            for( int j = 0 ; j < nums2.length && j < k ; j++ ){
                minHeap.offer(new int[]{nums1[i],nums2[j]});
            }
        }
        
        while( k-- > 0 && !minHeap.isEmpty()){
            res.add(minHeap.poll());
        }
        return res;
    }
}

```

### Improvement
* O(2k * lg(2k))
* One for loop
* Added first K pairs from nums1[i] and nums[0], track the index of nums[2]

```

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        
        if( nums1.length == 0 || nums2.length == 0 || k == 0 ) return res;
        for( int i = 0 ; i < nums1.length && i < k ; i++ ) {
            minHeap.offer(new int[]{nums1[i],nums2[0],0});
        }
        
        while( k-- > 0 && !minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            res.add(new int[]{cur[0],cur[1]});
            if( cur[2] == nums2.length - 1 ) continue;
            int curIndex2 = cur[2];
            minHeap.offer(new int[]{cur[0],nums2[curIndex2+1],curIndex2+1});
        }
        return res;
    }
}
```