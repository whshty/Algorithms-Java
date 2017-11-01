## 1.Inorder-Iteration

```java
public class BSTIterator {
    private Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
     
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while( node != null ){
            deque.addLast(node);
            if( node.left != null ){
                node = node.left; 
            } else{
                break;
            }
        }
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = deque.removeLast();
        TreeNode cur = node;
        if( cur.right != null ){
            cur = cur.right;
            while( cur != null ){
                deque.addLast(cur);
                if(cur.left != null){
                    cur = cur.left;
                }
                else break;
            }
        }
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
```