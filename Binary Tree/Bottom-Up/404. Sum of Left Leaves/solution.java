public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if( root == null ) return res;
        if( root.left != null ){
            if( root.left.left == null && root.left.right == null ){
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    
    }
}