class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode cur = dummy;
        int val = 0;
        
        while( node1 != null || node2 != null){
            if( node1 != null ) val += node1.val;
            if( node2 != null ) val += node2.val;
            cur.next = new ListNode(val%10);
            cur = cur.next;
            val /= 10;
            
            if( node1 != null ) node1 = node1.next;
            if( node2 != null ) node2 = node2.next;
        }
        if( val == 1 ) cur.next = new ListNode(1);
        return dummy.next;
    }
}`