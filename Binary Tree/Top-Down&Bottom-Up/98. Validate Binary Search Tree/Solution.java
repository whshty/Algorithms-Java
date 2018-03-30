class Solution {
    public boolean isValidBST(TreeNode root) {
        if( root == null ) return true;
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long min, long max){
        if( node == null ) return true;
        return (node.val > min && node.val < max) ? 
            isValidBST(node.left,min,node.val) && isValidBST(node.right,node.val,max) : false;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode pre = null;
        while( node != null || !stack.isEmpty() ){
            if( node != null ){
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                if( pre != null && temp.val <= pre.val ) return false;
                pre = temp;
                node = temp.right;
            }
        }
        return true;
    }
}