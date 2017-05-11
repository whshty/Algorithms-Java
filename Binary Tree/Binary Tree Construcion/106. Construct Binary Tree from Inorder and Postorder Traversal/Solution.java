/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0 ) return null;
        return build(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd){
        if( inStart >  inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        if( inEnd == inStart ) return root;
        int i = 0;
        for( i = inEnd; i >= inStart; i -- ){
            if( inorder[i] == root.val) break;
        }
        root.left = build(inorder,inStart,i-1,postorder,postEnd-(inEnd-i)-1);
        root.right = build(inorder,i+1,inEnd,postorder,postEnd-1);
        return root;
    }
}