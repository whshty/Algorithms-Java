public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;
        helper(root,res,0);
        return res;
    }
    
    private void helper(TreeNode node, List<Integer> res , int level){
        if( node == null ) return;
        if( res.size() == level ){
            res.add(node.val);
        }
        helper(node.right,res,level+1);
        helper(node.left,res,level+1);
    }
}

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for( int i = 0 ; i < size ; i++ ){
                TreeNode node = queue.poll();
                if( i == size - 1 ) res.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return res;
        
    }
}