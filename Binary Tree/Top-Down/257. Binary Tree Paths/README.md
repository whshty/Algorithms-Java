```
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null ) return res;
        helper(root,res,new StringBuilder());
        return res;
    }
    private void helper(TreeNode node, List<String> res, StringBuilder sb){
        int len = sb.length();
        sb.append(node.val);
        if( node.left == null && node.right == null ) {
            res.add(sb.toString());
        } else{
            sb.append("->");            
            if( node.left != null ){
                helper(node.left,res,sb);
            }
            if( node.right != null ){
                helper(node.right,res,sb);
            }
        }
        sb.setLength(len);
    }
}
```