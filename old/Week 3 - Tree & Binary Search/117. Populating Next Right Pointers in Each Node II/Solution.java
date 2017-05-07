public class Solution {
    public void connect(TreeLinkNode root) {
        // move all nodes in tree in level order
        // keep sewing together next level's children
        
        // dummy is used to keep track of start node of next level
        TreeLinkNode node = root, dummy = new TreeLinkNode(0);
        
        // this while loop is for all levels
        while( node != null ){
            // cur is sewing next nodes in current level
            // first time in a level, it is same as dummy
            // if we get a non null children from node. threads that child into its next
            // make that childer as next dummy
            TreeLinkNode cur = dummy;
            // move nodes in current level 
            while( node != null ){
                if( node.left != null ){
                    cur.next = node.left;
                    cur = cur.next;
                }
                if( node.right != null ){
                    cur.next = node.right;
                    cur = cur.next;
                }
                // move node to next in same level, end up null at rightmost
                node = node.next;
            }
            // curren levet ended because of null node
            // take node from the beginning of next levet
            node = dummy.next;
            
            dummy.next = null;
        }
    }
}