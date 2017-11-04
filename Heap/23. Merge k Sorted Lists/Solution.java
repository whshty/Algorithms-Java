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

// Comparator
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        // minHeap
        // PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
        //     @Override
        //     public int compare(ListNode o1, ListNode o2){
        //         if(o1.val < o2.val) return -1;
        //         else if(o1.val == o2.val) return 0;
        //         else return 1;
        //     }
        // });
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

// Merge K sorted Array
public class Solution {
    public static void main(String[] args) {
        int[] input1 = new int[]{1, 3, 5, 7};
        int[] input2 = new int[]{2, 8, 11, 19};
        int[] input3 = new int[]{0, 4, 6, 10};

        List<int[]> input = new ArrayList<>();
        input.add(input1);
        input.add(input2);
        input.add(input3);

        Solution sol = new Solution();
        int[] res = sol.mergeKSortedArray(input);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

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


// Merge K sorted Array Iterator
import java.util.*;
public class Solution {
     public static void main(String[] args) {
         int[] input1 = new int[]{1,3,4,5,6};
         int[] input2 = new int[]{2,8,11,19};
         int[] input3 = new int[]{0,4,6};

         List<int[]> input = new ArrayList<>();
         input.add(input1);
         input.add(input2);
         input.add(input3);


         Solution itr = new Solution();
         itr.ListIterator(input);

         while(itr.hasNext()){
             System.out.print(itr.next() + ",");
         }
     }
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

