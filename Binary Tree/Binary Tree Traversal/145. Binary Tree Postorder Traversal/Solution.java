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

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.addFirst(node);
                res.addFirst(node.val);
                node = node.right;
            } else {
                TreeNode temp = deque.removeFirst();
                node = temp.left;
            }
        }
        return res;
    }
}