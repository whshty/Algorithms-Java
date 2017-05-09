public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new ArrayList<>();
        if( root == null ) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while( !stack.isEmpty()){
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if( node.left != null ) stack.push(node.left);
            if( node.right !=null ) stack.push(node.right);
        }
        return res;
    }
}

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