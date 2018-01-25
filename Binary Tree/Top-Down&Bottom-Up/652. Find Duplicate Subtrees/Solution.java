class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        helper(root,new HashMap<>(),res);
        return res;
    }

    // post order
    private String helper(TreeNode node , Map<String,Integer> map , List<TreeNode> res ){
        if( node == null ) return "#";
        String str = node.val + "," + helper(node.left,map,res) + "," + helper(node.right,map,res);
        if( map.getOrDefault(str,0) == 1 ) res.add(node);
        map.put(str,map.getOrDefault(str,0)+1);
        return str;
    }
}
