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

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> map = new HashMap<TreeNode,TreeNode>();
        map.put(root,null);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
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
        Set<TreeNode> ancestor = new HashSet<TreeNode>();
        while( p != null){
            ancestor.add(p);
            p = map.get(p);
        }
        while ( !ancestor.contains(q)){
            q = map.get(q);
        }
        return q; 
    }
}