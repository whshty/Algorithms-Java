// Recursion
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode node, List<Integer> res){
        if( node != null ){
            if ( node.left != null ) helper(node.left,res);
            res.add(node.val);
            if( node.right != null ) helper(node.right,res);
        }
    }
}

// Stack
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.addFirst(node);
                node = node.left;
            } else{
                node = deque.removeFirst();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}