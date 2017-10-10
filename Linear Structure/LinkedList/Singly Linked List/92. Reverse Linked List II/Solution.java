public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( head == null ) return null;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        for( int i = 0 ; i < m - 1 ; i++ ) pre = pre.next;
        ListNode one = pre.next;
        ListNode two = one.next;
        
        for( int i = 0 ; i < n - m ; i++ ){
            one.next = two.next;
            two.next = pre.next;
            pre.next = two;
            two = one.next;
        }
        return dummy.next;
    }
}