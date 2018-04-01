## Iteration
* Stack 
* Check left, check right and add current value

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        // Right first
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.push(node);
                res.addFirst(node.val);
                node = node.right;
            } else {
                node = deque.pop();
                node = node.left;
            }
        }
        return res;
    }
}
```