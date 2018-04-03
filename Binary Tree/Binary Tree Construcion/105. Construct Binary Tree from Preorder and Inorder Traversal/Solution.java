class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if( preorder.length != inorder.length ) return null;
        if( preorder.length == 0 || inorder.length == 0 ) return null;
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode helper(int[]preorder, int preStart, int preEnd, int inorder[], int inStart, int inEnd ){
        // Base case
        if( preStart > preEnd || inStart > inEnd ) return null;
    
        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRoot = inStart;
        // Find inorder root
        for( int i = inStart ; i <= inEnd ; i++ ){
            if( inorder[i] == root.val){
                inorderRoot = i;
                break;
            }
        }
        
        int leftTreeLen = inorderRoot - inStart;
        root.left = helper(preorder,preStart+1,preStart+leftTreeLen,inorder,inStart,inorderRoot-1);
        root.right = helper(preorder,preStart+leftTreeLen+1,preEnd,inorder,inorderRoot+1,inEnd);
        
        return root;
    }
}