```
class Solution {
    public int longestConsecutive(TreeNode root) {
        if( root == null ) return 0;
        else return Math.max(helper(root.left,root.val,1),helper(root.right,root.val,1));
    }
    
    private int helper(TreeNode node, int pre, int max){
        if( node == null ) return max;
        if( node.val != pre + 1) max = 1;
        else max += 1;
        int subMax = Math.max(helper(node.left,node.val,max),helper(node.right,node.val,max));
        return Math.max(subMax,max);
    }
}
```