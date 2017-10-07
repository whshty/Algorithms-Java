### 1.Recursion 
* If We can find left and right, return root
* If I can only find left or right, which means, p(or q) is the ancester of q(or p), we return p(or q)

```
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null || root == p || root == q ) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if( left == null ) return right;
        else if( right == null ) return left;
        else return root;
    }
}
```

### 2.Iteration

```
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        map.put(root, null);
        deque.push(root);

        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = deque.pop();
            if (node.left != null) {
                map.put(node.left, node);
                deque.push(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                deque.push(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (!set.contains(q)) q = map.get(q);
        return q;
    }
}

```

### 3. Find the length of shortest path between two nodes in a tree

```
public int getShortestDistance(TreeNode root, TreeNode p ,TreeNode q ){
    TreeNode lca = lowestCommonAncestor(root,p,q);
    return getDepth(lca,p.val,0) + getDepth(lca,q.val,0);
}
    
public int getDepth(TreeNode root, int target, int level) {
    if (root == null) return -1;
    if (root.val == target) return level;
    int leftLevel = getDepth(root.left, target, level + 1);
    if (leftLevel == -1) return getDepth(root.right, target, level);
    else return leftLevel;
}
```