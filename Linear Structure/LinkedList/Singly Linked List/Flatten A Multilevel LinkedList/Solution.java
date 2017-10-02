public class Solution {
    public ListNode flattenList(ListNode head) {
        if (head == null) return head;
        ListNode tail = head;
        while (tail.next != null) tail = tail.next;


        ListNode cur = ListNode;
        while ( cur != tail) {
            if (cur.child != null) {
                tail.next = cur.child;
                ListNode  tmp = cur.child;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tail = tmp;
            }
            cur = cur.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode(int x) {
        val = x;
    }
}


