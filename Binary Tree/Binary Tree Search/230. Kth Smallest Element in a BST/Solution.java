public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int nodesAmount = countNodes(root.left);
        if( k <= nodesAmount ){
            return kthSmallest(root.left,k);
        } 
        else if ( k  > nodesAmount + 1 ){
            return kthSmallest(root.right,k-1-nodesAmount);
        }
        return root.val;
    }
    public int countNodes(TreeNode node){
        if ( node == null ) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}