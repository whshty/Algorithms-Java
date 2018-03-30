## Two Pointers

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head == null || head.next == null ) return null;
        ListNode dummy = new ListNode(-1);
        ListNode fast = dummy;
        ListNode slow = dummy;
        dummy.next = head;
        
        while ( n > 0 ){
            fast = fast.next;
            n--;
        }
        
        while ( fast.next != null ){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
```