## 1.Iteration
* Left, Root, Right
* Depth first to the left to store every node is a stack
* The very first node is our start node
* Check node's right first, the node maybe the root for other nodes
* If the right is null, we can go to the parent node( stack pop)
* If the right is not null, we need to store the right node in stack and travel to next very left

```java
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.addFirst(node);
                node = node.left;
            } else{
                node = deque.removeFirst();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }
}
```


## 2.Recursion
* If the current very left node has right child node, we need to consider it as parent node and go the right subtree
* Time : O(n)
* Space : O(n) + O(h) is stack space, o(h) = o(logn) is the tree is balanced


```java
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode node, List<Integer> res){
        if( node != null ){
            if ( node.left != null ) helper(node.left,res);
            res.add(node.val);
            if( node.right != null ) helper(node.right,res);
        }
    }
}
```
