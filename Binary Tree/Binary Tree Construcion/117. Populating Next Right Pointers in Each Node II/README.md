## 1.Queue + BFS

```java
class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if( root == null ) return;
        queue.offer(root);
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            TreeLinkNode temp = null;
            for(int i = 0 ; i < size ; i++){
                TreeLinkNode node = queue.poll();
                node.next = temp;
                temp = node;
                if( node.right != null) queue.offer(node.right);
                if( node.left != null) queue.offer(node.left);
            }
        }
    }
}
```


## 2.Pointers
* Move all nodes in level order
* Use dummy to track all start node of next level
* Two while loop, the first is for differetn levels, the second is for traversal in the same level

```java
class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root, dummy = new TreeLinkNode(-1);
        
        // Different levels
        while( node != null ){ 
            TreeLinkNode cur = dummy;
            
            // Same level
            while( node != null ){
                if( node.left != null ){
                    cur.next = node.left;
                    cur = cur.next;
                }
                if( node.right != null ){
                    cur.next = node.right;
                    cur = cur.next;
                }
                // move node to next in same level
                node = node.next; 
            }
            
            node = dummy.next;
            dummy.next = null;  
        }
    }
}
```