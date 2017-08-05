public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if( root == null ) return res;
        while( root != null ){
            if ( root.val <= p.val ){
                root = root.right;
            } else{
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}