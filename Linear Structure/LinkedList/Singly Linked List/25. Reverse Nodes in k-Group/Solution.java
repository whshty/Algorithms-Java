public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while( cur != null && count != k ){
            cur = cur.next;
            count++;
        }
        
        if( count == k){
            // deal with nodes after first k
            cur = reverseKGroup(cur,k); 
            // first k 
            while( count-- > 0 ){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}