public class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] res = new int[1];
        if( root == null ) return res[0];
        longestPath(root,res);
        return res[0];
    }
    
    public int[] longestPath(TreeNode root, int[] res){
        if( root == null ){
            return new int[] {0,0};
        }
        int increase = 1, decrease = 1;
        if( root.left != null ){
            int[] left = longestPath(root.left,res);
            if( root.val == root.left.val + 1 ){
                decrease = left[1] + 1;
            } else if ( root.val == root.left.val - 1 ){
                increase = left[0] + 1;
            }
        }
        if( root.right != null ){
            int[] right = longestPath(root.right,res);
            if( root.val == root.right.val + 1 ){
                decrease = Math.max(decrease,right[1] + 1);
            } else if ( root.val == root.right.val - 1){
                increase = Math.max( increase, right[0] + 1 );
            }
        }
        res[0] = Math.max(res[0],decrease+increase -1 );
        return new int[]{increase,decrease};
    }
}