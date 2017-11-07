class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);


        Solution sol = new Solution();
        sol.reversePrintInRecursion(head);
    }

    public void reversePrintInRecursion(ListNode head) {
        if (head == null) return;
        reversePrintInRecursion(head.next);
        System.out.print(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}