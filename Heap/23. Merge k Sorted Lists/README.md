## 1.Heap
```java
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b) -> a.val - b.val );
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        // add all head nodes of K list into the heap
        for(ListNode node : lists){
            if( node != null ) heap.add(node);
        }
        while(!heap.isEmpty()){
            head.next = heap.poll();
            head = head.next;
            // if list just extract fromt sill has element, add it to the heap
            if(head.next != null ) heap.add(head.next);
        }
        return dummy.next;
    }
}
```
## 2.Merge K Sorted Array 
```java
public class Solution {
    public int[] mergeKSortedArray(List<int[]>input) {
        int m = input.size();
        int n = input.get(0).length;
        int[] res = new int[m * n];
        int index = 0;

        PriorityQueue<Index> heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for( int i = 0 ; i < input.size() ; i++ ){
            int val = input.get(i)[0];
            Index temp = new Index(val,0,i);
            heap.add(temp);
        }

        while (!heap.isEmpty()) {
            Index temp = heap.poll();
            int curVal = temp.val;
            res[index++] = curVal;

            int x = temp.x;
            int y = temp.y;

            int[] curArray = input.get(y);

            if( x  + 1 < curArray.length ){
                int nextVal = curArray[x+1];
                int nextX = x + 1;
                Index next = new Index(nextVal,nextX,y);
                heap.add(next);
            }
        }
        return res;
    }
}

class Index {
    int val;
    int x;
    int y;

    Index(int value, int xPos, int yPos) {
        this.val = value;
        this.x = xPos;
        this.y = yPos;
    }
}
```

## 3.Merge K sorted Array Iterator

```java
public class Solution {
    PriorityQueue<Index> heap;
    List<int[]> input;
    public void ListIterator(List<int[]> list){
        heap = new PriorityQueue<>((a,b) -> a.val - b.val);
        input = list;

        for( int i = 0 ; i < list.size() ; i++ ){
            int val = list.get(i)[0];
            Index temp = new Index(val,0,i);
            heap.add(temp);
        }
    }

    public boolean hasNext(){
        return !heap.isEmpty();
    }

    public int next(){
        Index temp = heap.poll();
        int curVal = temp.val;

        int x = temp.x;
        int y = temp.y;

        int[] curArray = input.get(y);

        if( x  + 1 < curArray.length ){
            int nextVal = curArray[x+1];
            int nextX = x + 1;
            Index next = new Index(nextVal,nextX,y);
            heap.add(next);
        }
        return curVal;
    }
}

class Index{
    int val;
    int x;
    int y;
    Index(int value , int xPos ,int yPos){
        this.val = value;
        this.x = xPos;
        this.y = yPos;
    }
}
```