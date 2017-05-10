public class Solution {
    public int maxDepth(TreeNode root) {
        int count = 0;
        if(root==null) return count;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while( !queue.isEmpty()){
            int size = queue.size();
            for( int i = 0 ; i < size ; i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            count++;
        }
        return count;
    }
}