class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if( head == null ) return null;
        return helper(head,null);
    }
    
    public TreeNode helper(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if( head == tail ) return null;
        
        // Find mid point
        while( fast != tail && fast.next != tail ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Build Tree
        TreeNode node = new TreeNode(slow.val);
        node.left = helper(head,slow);
        node.right = helper(slow.next,tail);
        return node;
    }
}