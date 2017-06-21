public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }
    
    private int dfs(TreeNode node, List<List<Integer>> res){
        if( node == null ) return -1;
        int level = 1 + Math.max(dfs(node.left,res),dfs(node.right,res));
        if( res.size() < level + 1 ) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
}