## 1.Recursion
* Time : O(n)
* Space : O(h)

```java
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

## 2.Iteration (In-Order)
* Time : O(n)
* Space : O(n)

```java
public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while( !stack.isEmpty() || node != null ){
            if( node != null ){
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                if( pre != null && temp.val <= pre.val ) return false;
                pre = temp;
                node = temp.right;
            }
        }
        return true;
    
    }
}
```