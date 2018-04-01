public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null ) return res;
        helper(root,res);
        return res;
        
    }
    public void helper(TreeNode node, List<Integer> res){
        if( node.left != null ) helper(node.left,res);
        if( node.right != null ) helper(node.right,res);
        res.add(node.val);
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        // Right first
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.push(node);
                res.addFirst(node.val);
                node = node.right;
            } else {
                node = deque.pop();
                node = node.left;
            }
        }
        return res;
    }
}