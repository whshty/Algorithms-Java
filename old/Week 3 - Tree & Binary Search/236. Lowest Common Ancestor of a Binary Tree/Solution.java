public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // use map to store <child,parent> relationship
        Map<TreeNode,TreeNode> map = new HashMap<TreeNode,TreeNode>();
        map.put(root,null);
        // use queue to do traversal 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        // traversal is finised if we find p and q
        while(!map.containsKey(p)||!map.containsKey(q)){
            TreeNode node = queue.poll();
            if( node.left != null ){
                map.put(node.left,node);
                queue.offer(node.left);
            }
            if (node.right != null ){
                map.put(node.right,node);
                queue.offer(node.right);
            }
        }
        // add the path from p to set
        Set<TreeNode> ancestor = new HashSet<TreeNode>();
        while( p != null){
            ancestor.add(p);
            p = map.get(p);
        }
        // check the ancestor of q in the set
        while ( !ancestor.contains(q)){
            q = map.get(q);
        }
        return q; 
    }
}

// Follow up, find LCA of three given nodes 

public TreeNode lowestCommonAncestorOFThreeNodes(TreeNode root, TreeNode p, TreeNode q, TreeNode r) {
    TreeNode f = lowestCommonAncestor(TreeNode root, TreeNode p , TreeNode q);
    TreeNode lca = lowestCommonAncestor(f,r);
    return lca;
}