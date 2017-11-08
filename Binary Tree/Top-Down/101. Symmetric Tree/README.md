## 1.Recursion
* Use helper function to check the most left,right and medium left,right

```java
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null ) return true;
        return isSame(root.left,root.right);
    }
    
    public boolean isSame(TreeNode left, TreeNode right){
        if( left == null && right == null ) return true;
        if( left == null || right == null ) return false;
        if( left.val != right.val ) return false;
        return isSame(left.left,right.right) && isSame(left.right,right.left);
    }
}
```

## 2.Stack
* Pusht the most left right node to the stack and compare it every time
* Compare the number of nodes in stack and the value of nodes

```java
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if( root == null ) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(!pushLeftAndRight(stack,root.left,root.right)) return false;
        TreeNode left,right;
        
        while( !stack.isEmpty()){
            if( stack.size() % 2 != 0 ) return false;
            right = stack.pop();
            left = stack.pop();
            if(right.val!=left.val) return false;
            
            if(!pushLeftAndRight(stack,left.left,right.right)) return false;
            if(!pushLeftAndRight(stack,left.right,right.left)) return false;
        }
        return false;
    }
    
    public boolean pushLeftAndRight(Stack<TreeNode> stack, TreeNode left,TreeNode right){
        if
       if(left!=null){
           if(right==null) return false;
           stack.push(left);
           stack.push(right);
       } else if(right!=null){
           return false;
       }
       return true;
    }
}
```