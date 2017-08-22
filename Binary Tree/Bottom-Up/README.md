# Bottom-up

Postorder-traversal is a kind of bottom-down traversal. Normally, bottom-up traversal only need to parse treenode, but we should figure out what the return value should be.

For example,

```
public int maxDepth(TreeNode root) {
    if (root == null) { 
		return 0; 
    }
    int leftH = maxDepth(root.left);
    int rightH = maxDepth(root.right);
    return Math.max(leftH, rightH) + 1;
} 
```


## Return value
### Boolean
* [100. Same Tree]()

### int
* [104. Maximum Depth of Binary Tree]()
* [110. Balanced Binary Tree]()