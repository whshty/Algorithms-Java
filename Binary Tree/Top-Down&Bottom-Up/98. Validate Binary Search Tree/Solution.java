public class Solution {
    public boolean isValidBST(TreeNode root) {
        if( root == null ) return true;
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long min, long max){
        if( node == null ) return true;
        if( node.val > min && node.val < max ){
            return isValidBST(node.left,min,node.val) && isValidBST(node.right,node.val,max);
        }
        else return false;
    }
}