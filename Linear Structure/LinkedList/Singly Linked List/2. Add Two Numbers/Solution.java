public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode cur = dummy;
        int carry = 0;
        while ( node1 != null || node2 != null ){
            int x = ( node1 != null ) ? node1.val : 0;
            int y = ( node2 != null ) ? node2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            if ( node1 != null ) node1 = node1.next;
            if ( node2 != null ) node2 = node2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }
}