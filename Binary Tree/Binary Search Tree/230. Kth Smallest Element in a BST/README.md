```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftTreeCount = findLeftTreeCount(root.left);
        if (k == leftTreeCount + 1) return root.val;
        else if (k <= leftTreeCount) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - leftTreeCount -1);   
    }
    
    private int findLeftTreeCount(TreeNode node) {
        if (node == null) return 0;
        else return 1 + findLeftTreeCount(node.left) + findLeftTreeCount(node.right);        
    }
}
```