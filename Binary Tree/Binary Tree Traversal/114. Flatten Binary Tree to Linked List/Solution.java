public class Solution {
    public void flatten(TreeNode root) {
        if( root == null ) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null ) stack.push(node.left);
            if(!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }
    }
}