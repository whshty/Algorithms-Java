// Brute force 
public class Solution {
    public int countNodes(TreeNode root) {
        if( root == null ) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// Recursion 
public class Solution {
    public int countNodes(TreeNode root) {
        int treeHeight = countHeight(root);
        if( treeHeight < 0 ) return 0;
        if( countHeight(root.right) == treeHeight-1 ) {
            return (1 << treeHeight) + countNodes(root.right);
        }
        else return countNodes(root.left) + (1 << treeHeight-1);
    }
    public int countHeight(TreeNode root){
        if( root == null) return -1;
        return 1 + countHeight(root.left);
    }
}