public class Solution {
    // count the node above the last level
    public int countNodes(TreeNode root) {
        if( root == null ) return 0;
        if( root.left == null ) return 1;
        int height = 0;
        int sum = 0; 
        TreeNode cur = root;
        while( cur.left != null ){
            sum += ( 1 << height );
            height++;
            cur = cur.left;
        }
        return sum + countLast(root, height);
    }
    // count the node of the last level
    private int countLast(TreeNode root, int height ){
        // end condition
        if( height == 1 ){
            if( root.right != null ) return 2;
            if( root.left != null ) return 1;
            else return 0;
        }
        // If the midNode is null, then is means we should count the nodes on the last level in the left subtree
        // If the midNode is not null, then we add half of the last level nodes to the result and then count the nodes on the last level in the right sub tree
        TreeNode midNode = root.left;
        int curHeight = 1;
        while( curHeight < height ){
            curHeight++;
            midNode = midNode.right;
        }
        if( midNode==null) return countLast(root.left,height-1);
        else return ( 1<<(height-1)) + countLast(root.right,height-1);
    }
}