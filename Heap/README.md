## 1.Time Complexity
* Basic heap operation of Heapify runs in O(logn) time, because the heap has O(log n) levels
* Building a Binary Heap is O(n)

1. getMini(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
2. extractMin(): Removes the minimum element from Min Heap. Time Complexity of this Operation is O(Logn) as this operation needs to maintain the heap property (by calling heapify()) after removing root.
3. decreaseKey(): Decreases value of key. Time complexity of this operation is O(Logn). If the decreases key value of a node is greater than parent of the node, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
4. insert(): Inserting a new key takes O(Logn) time. We add a new key at the end of the tree. IF new key is greater than its parent, then we don’t need to do anything. Otherwise, we need to traverse up to fix the violated heap property.
5. delete(): Deleting a key also takes O(Logn) time. We replace the key to be deleted with minum infinite by calling decreaseKey(). After decreaseKey(), the minus infinite value must reach root, so we call extractMin() to remove key.


## 2.Two Ways of Creating minHeap
```java
PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val );
```
```java
 PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
 		@Override
 		public int compare(ListNode o1, ListNode o2){
 			if(o1.val < o2.val) return -1;
 				else if(o1.val == o2.val) return 0;
 				else return 1;
       }
});
        
```

```java
PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val );
```


## 3.Design Heap