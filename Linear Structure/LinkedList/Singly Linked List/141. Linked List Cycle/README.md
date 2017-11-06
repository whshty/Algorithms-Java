## Slow and Fast Pointer

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        // Move one pointer by one and other pointer by two
        // If these pointers meet at some node then there is a loop
        while ( slow != fast){
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
```