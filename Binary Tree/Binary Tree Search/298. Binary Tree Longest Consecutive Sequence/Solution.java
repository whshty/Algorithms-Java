public class Solution {
    public int longestConsecutive(TreeNode root) {
        return dfs(null,root,0);
    }
    private int dfs(TreeNode parent, TreeNode node, int length){
        if( node == null ) return length;
        if( parent != null && node.val == parent.val + 1 ){
            length += 1;
        } else {
            length = 1;
        }
        return Math.max(length,Math.max(dfs(node,node.left,length),dfs(node,node.right,length)));
    }
}