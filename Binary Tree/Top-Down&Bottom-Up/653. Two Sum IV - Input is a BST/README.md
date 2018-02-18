## Iteration

```java
class Solution {
    public boolean findTarget(TreeNode root, int target) {
        if( root == null ) return false;
        Set<Integer> set = new HashSet<>();
        return helper(root,set,target);
    }
    
    private boolean helper(TreeNode node, Set<Integer> set, int target){
        if( node == null ) return false;
        if( set.contains(node.val)) return true;
        else{
            set.add(target-node.val);
            return helper(node.left,set,target) || helper(node.right,set,target);
        }
    }
}
```

