### Iteration
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}
```

### Recursion 
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if( head == null ) return null;
        return helper(head,null);
    }
    
    public ListNode helper(ListNode cur , ListNode pre){
        if( cur == null ) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return helper(next,cur);
    }
}
```