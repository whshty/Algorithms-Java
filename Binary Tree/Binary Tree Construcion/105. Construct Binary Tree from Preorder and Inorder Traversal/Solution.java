/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder, int inStart , int inEnd){
        if( preStart > preEnd || inStart > inEnd ) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inorderRoot = inStart;
        
        for(int i = inStart ; i <= inEnd ; i++){
            if( inorder[i] == root.val){
                inorderRoot = i;
                break;
            }
        }
        
        int leftTreeLen = inorderRoot-inStart;
        
        root.left = build(preorder,preStart+1,preStart+leftTreeLen,inorder,inStart,inorderRoot-1);
        root.right = build(preorder,preStart+leftTreeLen+1,preEnd,inorder,inorderRoot+1,preEnd);
        
        return root;
    }
}