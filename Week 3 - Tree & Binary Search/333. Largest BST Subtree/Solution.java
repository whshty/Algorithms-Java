public class Solution {
    int max = 0;
    // size and range of current nodes
    class result {
        int size;
        int lower;
        int upper;
        result( int size , int lower , int upper ){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }    
        traverse(root);
        return max;
    }
    private result traverse(TreeNode root) {
        if (root == null) { return new result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
        result left = traverse(root.left);
        result right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}