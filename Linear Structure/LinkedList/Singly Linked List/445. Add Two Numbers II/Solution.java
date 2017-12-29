class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        
        while( l1 != null ) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while( l2 != null ){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int val = 0;
        ListNode node = new ListNode(-1);
        
        while( !stack1.isEmpty() || !stack2.isEmpty()){
            if( !stack1.isEmpty() ) val += stack1.pop();
            if( !stack2.isEmpty() ) val += stack2.pop();
            node.val = val % 10;
            ListNode cur = new ListNode(val/10);
            cur.next = node;
            node = cur;
            val /= 10;
        }
        return node.val == 0 ? node.next : node;
    }
}