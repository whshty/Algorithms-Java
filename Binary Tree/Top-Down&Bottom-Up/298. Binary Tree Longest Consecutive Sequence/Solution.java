public class Solution {
    public int longestConsecutive(TreeNode root) {
        if( root == null ) return 0;
        else return Math.max(helper(root.left,root.val,1),helper(root.right,root.val,1));
        
    }
    private int helper(TreeNode node, int pre, int max){
        if( node == null ) return max;
        if ( node.val != pre + 1 ) max = 1;
        else max++;
        int temp = Math.max(helper(node.left,node.val,max),helper(node.right,node.val,max));
        return Math.max(temp,max);
    }
}

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