import java.util.ArrayDeque;
import java.util.Deque;

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
        System.out.println();
        sol.reversePrintInRecursion(head);
        System.out.println();
        sol.printByDivide(head);

    }

    public void reversePrintInRecursion(ListNode head) {
        if (head == null) return;
        reversePrintInRecursion(head.next);
        System.out.print(head.val);
    }

    public void reversePrintByStack(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void printByDivide(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        helper(head, len);
    }

    private void helper(ListNode head, int length) {
        if (head == null) return;

        if (length == 1) {
            System.out.print(head.val);
            return;
        }

        int count = 0;
        ListNode cur = head;
        while (count < length / 2) {
            cur = cur.next;
            count++;
        }
        helper(cur, length - length / 2);
        helper(head, length / 2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}