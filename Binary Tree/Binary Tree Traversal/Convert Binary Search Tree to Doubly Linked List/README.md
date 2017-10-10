[alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Binary%20Tree/Binary%20Tree%20Traversal/Convert%20Binary%20Search%20Tree%20to%20Doubly%20Linked%20List/Pic.png)

# Use Tree as DLL

### Inorder

```java
public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
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
            } else{
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

### Generate Cycle

```java
public void generateCycle(TreeNode root){
	TreeNode pre = root , head = root;
	while( head.right != null ){
		head = head.right;
   	}
   	head.right = pre;
   pre.left = head;
}
```