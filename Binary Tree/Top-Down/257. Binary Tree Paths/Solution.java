public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null ) return res;
        helper(root,res,new StringBuilder());
        return res;
    }
    private void helper(TreeNode node, List<String> res, StringBuilder sb){
        if( node == null ) return; 
        int len = sb.length();
        sb.append(node.val);
        if( node.left == null && node.right == null ) {
            res.add(sb.toString());
        } else{
            sb.append("->");            
            helper(node.left,res,sb);
            helper(node.right,res,sb);
        }
        sb.delete(len,sb.length());
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<StringBuilder> path = new LinkedList<>();
        queue.add(root);
        path.add(new StringBuilder());
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            StringBuilder sb = path.poll();
            if( node.left == null && node.right == null ){
                res.add(sb.append(node.val).toString());
            }
            if( node.left != null ){
                StringBuilder temp = new StringBuilder(sb);
                queue.add(node.left);
                path.add(temp.append(node.val).append("->"));
            }
            if( node.right != null ){
                StringBuilder temp = new StringBuilder(sb);
                queue.add(node.right);
                path.add(temp.append(node.val).append("->"));
            }
        }
        return res;
    }
}