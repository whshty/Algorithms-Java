public class Solution {
    public int minDepth(TreeNode root) {
        int res = 0;
        if( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        res+=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for( int i = 0 ; i < size ; i++ ){
                TreeNode node = queue.poll();
                if( node.left == null && node.right == null ) return res;
                if( node.left != null ) queue.add(node.left);
                if( node.right != null ) queue.add(node.right);
            }
            res++;
        }
        return res;
    }
}