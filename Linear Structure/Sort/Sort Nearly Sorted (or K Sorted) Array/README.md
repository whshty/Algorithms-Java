## 1.Insertion Sort

## 2.Heap
* Create a Min Heap of size k+1 with first k+1 elements. This will take O(k) time (See this GFact)
* One by one remove min element from heap, put it in result array, and add a new element to heap from remaining elements.
* Removing an element and adding a new element to min heap will take Logk time. So overall complexity will be O(k) + O((n-k)*logK)

```
class Solution {
    public void sortKsortedArray(int[] input, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        //Construct Heap for k+1 elements
        for (i = 0; i <= k && i < input.length; i++){
            minHeap.add(input[i]);
        }

        int index = 0;

        // Repeat the process until priority queue becomes empty.
        while (!minHeap.isEmpty()) {
            input[index++] = minHeap.poll();
            if (i < input.length)
                minHeap.add(input[i++]);
        }
    }
}
```