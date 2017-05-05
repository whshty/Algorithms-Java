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
        return build(inorder,inorder.length-1,0,postorder,postorder.length-1);
    }
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart){
        if( inEnd > inStart ) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        if( inEnd == inStart ) return root;
        int i = 0;
        for( i = inStart; i >= inEnd; i -- ){
            if( inorder[i] == root.val) break;
        }
        
        root.right = build(inorder,inStart,i+1,postorder,postStart-1);
        root.left = build(inorder,i-1,inEnd,postorder,postStart-(inStart-i)-1);
        
        return root;
    }
}