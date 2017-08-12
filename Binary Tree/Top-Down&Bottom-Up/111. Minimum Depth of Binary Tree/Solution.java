public class Solution {
    public int minDepth(TreeNode root) {
        if( root == null ) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if( left == 0 && right == 0 ) return 1;
        else if(left == 0 ) return right + 1;
        else if(right == 0 ) return left + 1;
        return Math.min(left,right) + 1;
    }
}

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