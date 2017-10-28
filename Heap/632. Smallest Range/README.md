### Heap
* Heap to save a index from each list, which means every list has a value in the range
* int array to save value, index of list, index of value in this list


```java
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            max = Math.max(max, nums.get(i).get(0));
            min = Math.min(min,nums.get(i).get(0));
            // {firstValue,index of list,index of value}
            minHeap.add(new int[] {nums.get(i).get(0), i, 0});
        }
        
        int[] res = new int[]{ min, max};
        while( minHeap.peek()[2] + 1 < nums.get(minHeap.peek()[1]).size()) {
            // {firstValue,index of list,index of value}
            int[] cur = minHeap.poll();
            int nextValue = nums.get(cur[1]).get(cur[2] + 1);
            // {nextValue,index of list, index of value + 1}
            minHeap.add(new int[] {nextValue, cur[1], cur[2] + 1});
            max = Math.max(max, nextValue);
            
            if( max - minHeap.peek()[0] < res[1] - res[0] ) {
                res = new int[] {minHeap.peek()[0], max};
            }    
        }
        return res;
    }
}
```