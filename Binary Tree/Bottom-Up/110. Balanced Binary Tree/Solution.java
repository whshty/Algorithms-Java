public class Solution {
    public boolean isBalanced(TreeNode root) {
        if( root == null ) return true;
        return helper(root) != - 1;
    }
    public int helper(TreeNode node){
        if( node == null ) return 0;
        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);
        if( Math.abs(leftHeight-rightHeight)  > 1 || leftHeight == -1 || rightHeight == -1 ) return -1;
        return Math.max(leftHeight,rightHeight) + 1;
    }
}