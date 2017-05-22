public class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<TreeNode>();
     
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while( node != null ){
            stack.push(node);
            if( node.left != null ){
                node = node.left; 
            } else{
                break;
            }
        }
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if( cur.right != null ){
            cur = cur.right;
            while( cur != null ){
                stack.push(cur);
                if(cur.left != null){
                    cur = cur.left;
                }
                else break;
            }
        }
        return node.val;
    }
}
