class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int res = 0;
        if (root == null ) return res;
        int cur = dfs(root.left,root.val) + dfs(root.right,root.val);
        int left = longestUnivaluePath(root.left);
        int right = longestUnivaluePath(root.right);
        return Math.max(cur,Math.max(left,right));  
    }
    private int dfs(TreeNode node, int val){
        if(node == null || node.val != val ) return 0;
        return Math.max(dfs(node.left,val),dfs(node.right,val))+1;
        
    }
}