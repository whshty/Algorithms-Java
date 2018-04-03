class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0 ) return null;
        return build(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd){
        if( inStart > inEnd ) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        if( inStart == inEnd ) return root;
        int inorderRoot = 0;
        for( int i = inStart ; i <= inEnd ; i++){
            if( inorder[i] == root.val) {
                inorderRoot = i;
                break;
            }
        }
        
        int rightTreeLen = inEnd - inorderRoot;
        root.left = build(inorder,inStart,inorderRoot-1,postorder,postEnd-rightTreeLen-1);
        root.right = build(inorder,inorderRoot+1,inEnd,postorder,postEnd-1);
        
        return root;
    }
}