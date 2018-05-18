## 1.Recursion
* Time : O(logN)
 
```java
class Solution {
    public int closestValue(TreeNode root, double target) {
        int cur = root.val;
        
        if( target == cur ) return cur;
        root = target < cur ? root.left : root.right;
        if( root == null ) return cur;
        int next = closestValue(root,target);
        
        return Math.abs( next - target ) < Math.abs( cur - target) ?
                next : cur;     
    }
}
```

## 2.Iteration
```java
class Solution {
    public int closestValue(TreeNode node, double target) {        
        int cur = node.val;
        node = target < cur ? node.left : node.right;
        if (node == null || target == cur) return cur;
        int nextVal = closestValue(node, target);
        
        return Math.abs(nextVal - target) < Math.abs(cur - target) ? next:cur;     
    }
}
```