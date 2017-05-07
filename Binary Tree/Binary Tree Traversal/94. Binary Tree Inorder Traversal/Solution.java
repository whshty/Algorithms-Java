public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode node = root;
        boolean isFinished = false;
        
        while( !isFinished ){
            if( node != null){
                stack.push(node);
                node = node.left;
            }
            else {
                if( stack.isEmpty()){
                    isFinished = true;
                } else {
                    node = stack.pop();
                    res.add(node.val);
                    node = node.right;
                }
            }
        }
        return res;
    }
}