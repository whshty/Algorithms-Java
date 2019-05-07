## 1.1.Recursion
* Time : O(n)
* If We can find left and right, return root
* If I can only find left or right, which means, p(or q) is the ancester of q(or p), we return p(or q)

```java
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null ) return root;
        if( root == p || root == q ) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if( left == null ) return right;
        else if( right == null ) return left;
        else return root;
    }
}
```
![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Binary%20Tree/Top-Down%26Bottom-Up/236.%20Lowest%20Common%20Ancestor%20of%20a%20Binary%20Tree/pic1.png)

![alt text](https://github.com/RagingPsyduck/Data-Structures-and-Algorithms-in-Java/blob/master/Binary%20Tree/Top-Down%26Bottom-Up/236.%20Lowest%20Common%20Ancestor%20of%20a%20Binary%20Tree/pic2.png)

## 1.2.Iteration

```java
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Deque<TreeNode> deque = new ArrayDeque<>(); // Stack
        map.put(root, null);
        deque.push(root);

        // Create child - root relationship
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
        // Create a path from node P to root
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        // Traverse backwards from q to this path
        while (!set.contains(q)) q = map.get(q);
        return q;
    }
}

```

## 2. Follow up - Find the length of shortest path between two nodes in a tree

```java
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

## 3.1.Follow Up - Find LCA of deepest nodes : Recursion

```java
class Solution {
    public TreeNode findLCA(TreeNode root) {
        Node res = helper(root);
        return res.node;
    }

    private Node helper(TreeNode root) {
        if (root == null) return new Node(null, 0);

        int depth = 0;
        Node left = helper(root.left);
        Node right = helper(root.right);

        depth = Math.max(left.depth, right.depth) + 1;
        if (left.depth == right.depth) return new Node(root, depth);
        else if (left.depth > right.depth) return new Node(left.node, depth);
        else return new Node(right.node, depth);
    }
}

class Node {
    TreeNode node;
    int depth;

    Node(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
```

## 3.2.Follow Up - Find LCA of deepest nodes : Iteration
```java
class Solution {
    public TreeNode findLCA(TreeNode root) {
        if(root == null) return root;
        Map<TreeNode, TreeNode> map = new HashMap<>();

        TreeNode start = null, end = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        map.put(root, null);
        while(!queue.isEmpty()) {
            start = null; end = null;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(start == null) start = node;
                if(size == 0) end = node;
                if(node.left != null) {
                    map.put(node.left, node);
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    map.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }

        while(start != end){
            start = map.get(start);
            end = map.get(end);
        }
        return start;
    }
}

class Node {
    TreeNode node;
    int depth;

    Node(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
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
