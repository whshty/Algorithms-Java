```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1 == null ) return l2;
        if( l2 == null ) return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int val = 0;
        
        while( l1 !=null || l2 != null ){
            if( l1 != null ) val += l1.val;
            if( l2 != null ) val += l2.val;
            cur.next = new ListNode(val%10);
            val /= 10;
            
            if( l1 != null ) l1 = l1.next;
            if( l2 != null ) l2 = l2.next;    
            cur = cur.next;
        }
        if( val == 1 ) cur.next = new ListNode(1);
        return dummy.next;
    }
}

```