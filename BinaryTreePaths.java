/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time o(n)

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root != null ) search(root,"",res);
        return res;
        
    }
    private void search(TreeNode root, String path, List<String> res){
        if (root.left == null && root.right == null){
            res.add(path + root.val);
        }
        if (root.left != null) search(root.left, path + root.val + "->", res);
        if (root.right != null) search(root.right, path + root.val + "->", res);
    }
}