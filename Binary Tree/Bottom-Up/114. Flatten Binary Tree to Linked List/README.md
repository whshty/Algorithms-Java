### Recursion 

```
class Solution {
    public void flatten(TreeNode root) {
        if(  root == null ) return;
        TreeNode right = root.right;
        
        flatten(root.left);
        flatten(root.right);
        
        root.right = root.left;
        root.left = null;
        while( root.right != null ){
            root = root.right;
        }
        root.right = right;
    }
}
```

### Generate Cycle

```
public void generateCycle(TreeNode root){
	TreeNode pre = root , head = root;
	while( head.right != null ){
		head = head.right;
	}
	head.right = pre;
	//pre.left = head;
}

```


### Iteration
* use stack to save node.
* Preorder traversal 

```
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            if(!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }
    }
}

```

