// recursion
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,res);
        return res;
    }
    public void helper(TreeNode node, List<Integer> res){
        res.add(node.val);
        if(node.left != null )helper(node.left,res);
        if(node.right != null )helper(node.right,res);
    }
}

// stack
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                res.add(node.val);
                deque.push(node);
                node = node.left;
            } else {
                node = deque.pop(); 
                node = node.right;
            }
        }
        return res;
    }
}