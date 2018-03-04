```java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countAmount(root.left);
        if( k <= leftCount ) return kthSmallest(root.left,k);
        else if( k > leftCount + 1 ) return kthSmallest(root.right,k-1-leftCount);
        return root.val;
    }
    
    private int countAmount(TreeNode node){
        if( node == null ) return 0;
        return 1 + countAmount(node.left) + countAmount(node.right);
    }
}

```