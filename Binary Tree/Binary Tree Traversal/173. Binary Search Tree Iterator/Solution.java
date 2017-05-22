public class BSTIterator {
    private Stack<TreeNode> res = new Stack<>();

    public BSTIterator(TreeNode root) {
        postorder(root);
    }
    private void postorder(TreeNode root) {
	    Stack<TreeNode> stack = new Stack<>();
	    if (root == null) return;
	    stack.push(root);
	    while (!stack.isEmpty()) {
		    TreeNode cur = stack.pop();
		    res.push(cur);
		    if (cur.left != null) {
			    stack.push(cur.left);
		    }
		    if (cur.right != null) {
			    stack.push(cur.right);
		    } 
	    }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !res.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if( hasNext() ) {
            return res.pop().val;
        }
        else {
            return 0;
        }
    }
}