class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root,max);
        return max[0];
    }
    private int[] helper(TreeNode node, int[] max){
        if( node == null ) return new int[1];
        int left = Math.max(0,helper(node.left,max)[0]);
        int right = Math.max(0,helper(node.right,max)[0]);
        max[0] = Math.max(max[0],left+right+node.val);
        int[] res = new int[1];
        res[0] = Math.max(left,right) + node.val; 
        return res;      
    }
}