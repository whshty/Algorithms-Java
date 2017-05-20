public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        
        while( node != null ){
            TreeLinkNode cur = dummy;
            while( node != null ){
                if( node.left != null ){
                    cur.next = node.left;
                    cur = cur.next;
                }
                if(node.right != null ){
                    cur.next = node.right;
                    cur = cur.next;
                }
                node = node.next;
            }
            node = dummy.next;
            dummy.next = null;
        }
    }
}