class Solution {
    public int closestValue(TreeNode root, double target) {
        int cur = root.val;
        
        if( target == cur ) return cur;
        root = target < cur ? root.left : root.right;
        if( root == null ) return cur;
        int next = closestValue(root,target);
        
        return Math.abs( next - target ) < Math.abs( cur - target) ?
                next : cur;     
    }
}
class Solution {
    public int closestValue(TreeNode root, double target) {  
        int res = root.val;
        while( root != null ){
            // Update cloest value
            if( Math.abs(root.val-target) < Math.abs(res-target)) res = root.val;
            if( root.val > target ) root = root.left;
            else root = root.right;
        }
        return res;
    }
}