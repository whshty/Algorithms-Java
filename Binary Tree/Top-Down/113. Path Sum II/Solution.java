class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        helper(root,res,new ArrayList<>(),sum);
        return res;
    }
    public void helper(TreeNode node, List<List<Integer>> res , List<Integer> list , int value){
        if( node == null ) return;
        list.add(node.val);
        if( node.left == null && node.right == null ){
            if( value == node.val ){
                res.add(new ArrayList<>(list));;
                list.remove(list.size()-1);
                return;
            }
        }

        helper(node.left,res,list,value-node.val);
        helper(node.right,res,list,value-node.val);

        list.remove(list.size()-1);
    }
}
