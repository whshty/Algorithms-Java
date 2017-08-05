# Top-Down&Bottom-Up

Some problems need both top-down and bottom-up traversal.
For example, check if a tree is a valid BST, there node, min and max is traversaled from top and the return boolean values are traveraled from bottom to top

```
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if( root == null ) return true;
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode node, long min, long max){
        if( node == null ) return true;
        if( node.val > min && node.val < max ){
            return isValidBST(node.left,min,node.val) && isValidBST(node.right,node.val,max);
        }
        else return false;
    }
}
```