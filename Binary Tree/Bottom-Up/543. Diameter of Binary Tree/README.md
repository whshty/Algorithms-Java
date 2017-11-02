## Bottom-Up
* O(N^2)

```java
public class Solution {
    // int max;
    public int diameterOfBinaryTree(TreeNode root) {
        int res = 0;
        if (root == null ) return res;
        int cur = dfs(root.left) + dfs(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(cur,Math.max(left,right));    
    }
    
    private int dfs(TreeNode node){
        if(node == null ) return 0;
        return Math.max(dfs(node.left),dfs(node.right))+1;
        
    }
}
```