```java
class Solution {
    public void reversePrintInRecursion(ListNode head) {
        if (head == null) return;
        reversePrintInRecursion(head.next);
        System.out.print(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
```