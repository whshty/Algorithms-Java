## 1.Use Tree Class as DLL
### 1.1 Inorder & Recursion & Global Variable
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
### 1.2 Inorder & Recursion & Without Global Variable

``` java
class Solution {
    public void treeToDll(TreeNode root) {
        if (root == null) return;
        helper(root);
        // Generate Cycle
//        TreeNode head = root;
//        TreeNode tail = root;
//        while (head.left != null) {
//            head = head.left;
//        }
//        while (tail.right != null) {
//            tail = tail.right;
//        }
//        head.left = tail;
//        tail.right = head;
//        return head;
    }
    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            TreeNode left = root.left;
            helper(left);
            while (left.right != null) {
                left = left.right;
            }
            left.right = root;
            root.left = left;
        }
        if (root.right != null) {
            TreeNode right =root.right;
            helper(right);
            while (right.left != null) {
                right = right.left;
            }
            right.left = root;
            root.right = right;
        }
    }
}

```




### 1.3 Inorder - Iteration
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


## 2.Create DLL class

### 2.1 Inorder - Iteration

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