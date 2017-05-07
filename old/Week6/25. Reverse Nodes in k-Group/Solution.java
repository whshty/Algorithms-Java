public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        // find k + 1 node
        while( cur != null &&  count != k ){
            cur = cur.next;
            count++;
        }
        // if the k + 1 node is found
        if(  count == k ){
            cur = reverseKGroup(cur,k);
            while(count-- > 0 ){
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