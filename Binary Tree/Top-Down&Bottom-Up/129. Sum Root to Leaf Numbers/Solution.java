public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode node, int cur){
        if( node == null ) return 0;
        if( node.left == null && node.right == null ) return cur * 10 + node.val;
        return helper(node.left, cur*10+node.val) + helper(node.right,cur*10+node.val);
    }
}