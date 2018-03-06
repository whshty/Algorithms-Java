class Solution {
    public TreeNode[] splitBST(TreeNode root, int val) {
        TreeNode dummySmall = new TreeNode(-1);
        TreeNode curSmall = dummySmall;
        TreeNode dummyLarge = new TreeNode(-1);
        TreeNode curLarge = dummyLarge;
        
        while( root != null ){
            if( root.val <= val ){
                curSmall.right = root;
                curSmall = root;
                root = root.right;
                curSmall.right = null;
            } else {
                curLarge.left = root;
                curLarge = root;
                root = root.left;
                curLarge.left = null;
            }
        }
        return new TreeNode[]{dummySmall.right,dummyLarge.left};
    }
}