// BFS
class Solution {
    public int closestValue(TreeNode node, double target) {        
        int cur = node.val;
        node = target < cur ? node.left : node.right;
        if (node == null || target == cur) return cur;
        int nextVal = closestValue(node, target);
        
        return Math.abs(nextVal - target) < Math.abs(cur - target) ? next:cur;     
    }
}

// DFS
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