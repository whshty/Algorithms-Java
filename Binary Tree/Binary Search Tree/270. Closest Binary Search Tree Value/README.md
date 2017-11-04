## 1.Recursion
* Time : O(logN)
 
```java
class Solution {
    public int closestValue(TreeNode root, double target) {
        int curVal = root.val;
        
        if( target == curVal ) return curVal;
        if( target < curVal ) root = root.left;
        else root = root.right;
        
        if( root == null ) return curVal;
        
        int nextVal = closestValue(root,target);
        if( Math.abs( nextVal - target ) < Math.abs( curVal - target) ) return nextVal;
        
        else return curVal;
    }
}
```

## 2.Iteration
```
class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while( root != null ){
            // Update cloest value
            if( Math.abs(root.val-target) < Math.abs(res-target)) res = root.val;
            if( root.val > target ) root = root.left;
            else root = root.right;
        }
        return res;
    }
}
```