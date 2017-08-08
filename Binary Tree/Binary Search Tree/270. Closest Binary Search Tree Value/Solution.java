public class Solution {
    public int closestValue(TreeNode root, double target) {
        int cur = root.val;
        if( target < cur ) {
            root = root.left;
        } else {
            root = root.right;
        }
        if( root == null ) return cur;
        int next = closestValue(root,target);
        if( Math.abs( next - target ) < Math.abs( cur - target) ) return next;
        else return cur;
    }
}

public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while( root != null ){
            if( Math.abs(root.val-target) < Math.abs(res-target)){
                res = root.val;
            }
            if( root.val > target ) root = root.left;
            else root = root.right;
        }
        return res;
    }
}