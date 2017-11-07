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

// Iteration
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
        // Create a path from node P to from
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


// Find distance between two nodes of a Binary Tree
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

// LCA of deeptest node - recursion 
class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution sol = new Solution();
        System.out.println(sol.findLCA(root).val);

    }

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
    public TreeNode node;
    public int depth;

    public Node(TreeNode node, int depth) {
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




