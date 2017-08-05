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

In the same way, How we can deep copy a binary tree. We have 

* Top-Down: This is how we build we tree
* Bottom-Up: We return the node value from the bottom


```
public TreeNode deepCopyTree(TreeNode root) {
	if (root == null) {
		return null;
	}
	TreeNode leftNode = deepCopyTree(root.left);
	TreeNode rightNode = deepCopyTree(root.right);

	TreeNode cur = new TreeNode(root.val);
	cur.left = leftNode;
	cur.right = rightNode;
	return cur;
}
```