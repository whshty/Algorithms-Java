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


### 2.Output Two BSTs in Sorted Order
```java
class Solution {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(1);
        root1.right = new TreeNode(6);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(9);


        Solution sol = new Solution();
        List<Integer> res = sol.outputBSTsInSortedOrder(root1, root2);
        System.out.print(res);
    }

    public List<Integer> outputBSTsInSortedOrder(TreeNode one, TreeNode two) {
        List<Integer> res = new ArrayList<>();
        BSTIterator itrOne = new BSTIterator(one);
        BSTIterator itrTwo = new BSTIterator(two);

        int valOne = itrOne.next();
        int valTwo = itrTwo.next();
        while (itrOne.hasNext() || itrTwo.hasNext()) {
            if (valOne < valTwo) {
                res.add(valOne);
                if (itrOne.hasNext()) valOne = itrOne.next();
            } else {
                res.add(valTwo);
                if (itrTwo.hasNext()) valTwo = itrTwo.next();
            }
        }
        if (valOne > valTwo) {
            res.add(valTwo);
            res.add(valOne);
        } else {
            res.add(valOne);
            res.add(valTwo);
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
```