# Use Tree Class as DLL
### Inorder - Recursion
```java
public class Solution {
    TreeNode prev = null;

    public void convert(TreeNode root) {
        if (root == null) return;
        convert(root.left);
        if (prev != null) {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
    }

    public void generateCycle(TreeNode root) {
        TreeNode pre = root, head = root;
        while (head.right != null) {
            head = head.right;
        }
        head.right = pre;
        pre.left = head;
    }
}
```
### Inorder - Iteration
```java
public class Solution {
    public void convert(TreeNode root) {
        // write your code here
        if( root == null ) return;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode pre = null;

        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.addFirst(node);
                node = node.left;
            } else {
                node = deque.removeFirst();
                if( pre != null )pre.right = node;
                node.left = pre;
                pre = node;
                node = node.right;

            }
        }
    }
}

```


# Create DLL class

### Inorder - Iteration

```java
public class Solution {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if( root == null ) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        
        DoublyListNode dummy = new DoublyListNode(-1);
        DoublyListNode head = dummy;
        
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.addFirst(node);
                node = node.left;
            } else {
                node = deque.removeFirst();
                DoublyListNode cur = new DoublyListNode(node.val);
                head.next = cur;
                
                cur.prev = head;
                head = head.next;
                node = node.right;
            }
        } 
        return dummy.next;
    }
}
```