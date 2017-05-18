public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        while( head!= null ){
            TreeLinkNode node = head;
            while( node != null ){
                if( node.left != null ) node.left.next = node.right;
                if( node.right != null && node.next != null ) node.right.next = node.next.left;
                node = node.next;    
            }
            head = head.left;
        }
    }
}