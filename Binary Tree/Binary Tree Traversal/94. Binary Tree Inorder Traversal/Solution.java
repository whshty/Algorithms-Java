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
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode node = root;
        while( node != null || !stack.isEmpty()){
            while( node != null ){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}

