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


public class Solution {
    public void flatten(TreeNode root) {
        if( root == null ) return;
        flatten(root.left);
        flatten(root.right);
        
        TreeNode right = root.right;
        
        if( root.left != null ){
            root.right = root.left;
            root.left = null;
            
            while( root.right != null ){
                root = root.right;
            }
            root.right = right;
        }
    }
}