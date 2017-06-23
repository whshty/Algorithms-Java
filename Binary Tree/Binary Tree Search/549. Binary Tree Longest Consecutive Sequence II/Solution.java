public class Solution {
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return max;
    }
    
    public int[] longestPath(TreeNode root){
        if( root == null ){
            return new int[] {0,0};
        }
        int increase = 1, decrease = 1;
        if( root.left != null ){
            int[] left = longestPath(root.left);
            if( root.val == root.left.val + 1 ){
                decrease = left[1] + 1;
            } else if ( root.val == root.left.val - 1 ){
                increase = left[0] + 1;
            }
        }
        if( root.right != null ){
            int[] right = longestPath(root.right);
            if( root.val == root.right.val + 1 ){
                decrease = Math.max(decrease,right[1] + 1);
            } else if ( root.val == root.right.val - 1){
                increase = Math.max( increase, right[0] + 1 );
            }
        }
        max = Math.max(max,decrease+increase -1 );
        return new int[]{increase,decrease};
        
    }
}