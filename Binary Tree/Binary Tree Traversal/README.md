# Binary Tree Traversal 


## In-Order, Pre-Order, Post-Order Traversals
![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Binary%20Tree/Binary%20Tree%20Traversal/Picture/tree12.gif?raw=true "Logo Title Text 1")

All these traversals can be solved by stack and recursion

*  Inorder (Left, Root, Right):  4 2 5 1 3  

*  Preorder (Root, Left, Right): 1 2 4 5 3 

*  Postorder (Left, Right, Root): 4 5 2 3 1

### Recursion

```
public class Solution {
    public List<Integer> traversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        helper(root,res);
        return res;
    }
    public void helper(TreeNode node, List<Integer> res){
        // res.add(node.val); Pre-Order
        if(node.left != null )helper(node.left,res);
        // res.add(node.val); In-Order
        if(node.right != null )helper(node.right,res);
        // res.add(node.val); Post-Order
    }
}
```

### Iteration 

##### Pre-Order and In-Order


```
public class Solution {
    public List<Integer> traversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new new ArrayDeque<>();
        TreeNode node = root;
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                // res.add(node.val); Pre-Order
                deque.addFirst(node);
                node = node.left;
            } else {
                node = deque.removeFirst(); 
                // res.add(node.val); In-Order
                node = node.right;
            }
        }
        return res;
    }
}

```

##### Post-Order

```
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                res.addFirst(node.val); // Reverse the process of preorder
                deque.addFirst(node);
                node = node.right; // Reverse the process of preorder
            } else {
                TreeNode temp = deque.removeFirst();
                node = temp.left; // Reverse the process of preorder
            }
        }
        return res;
    }
}
```


### Morris Traversal