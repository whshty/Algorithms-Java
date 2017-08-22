class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if( root == null ) return res;
        helper(root,res,0);
        return res;
    }
    public void helper(TreeNode node, List<Integer> res, int level){
        if( node == null ) return;
        setMax(res,node,level);
        helper(node.left,res,level+1);
        helper(node.right,res,level+1);
    }
    private void setMax(List<Integer> res, TreeNode root, int level) {
	    if (level  == res.size()) res.add(root.val);
	    else res.set(level, Math.max(root.val, res.get(level)));
    }
}