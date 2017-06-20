public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<StringBuilder> qs = new LinkedList<>();
        Queue<TreeNode> qt = new LinkedList<>();
        qs.add(new StringBuilder());
        qt.add(root);
        while( !qt.isEmpty()){
            TreeNode node = qt.remove();
            StringBuilder sb = qs.remove();
            if( node.left == null && node.right == null ) {
                res.add(sb.append(node.val).toString());
            }
            if( node.left != null){
                StringBuilder temp = new StringBuilder(sb);
                qt.add(node.left);
                qs.add(temp.append(node.val).append("->"));
            }
            if( node.right != null){
                StringBuilder temp = new StringBuilder(sb);
                qt.add(node.right);
                qs.add(temp.append(node.val).append("->"));
            }
        }
        return res;
    }
}