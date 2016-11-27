/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Iteration 
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int count = 0;
        
        while ( ! q.isEmpty() ){
            int size = q.size();
            while (size >0 ){
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right !=null) q.add(cur.right);
                size--;
            }
            count++;
        }
        return count;
    }
}
// Recursion
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}