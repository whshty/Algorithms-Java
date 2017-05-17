public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        helper(res,new ArrayList<>(),root,sum);
        return res;
    }
    
    public void helper(List<List<Integer>> res , List<Integer> list , TreeNode node , int cur ){
        if( node == null ) return;
        list.add(node.val);
        if( node.val == cur && node.left == null && node.right == null ){
            res.add(new ArrayList<>(list));
        }
        else{
            helper(res,list,node.left,cur-node.val);
            helper(res,list,node.right,cur-node.val);   
        }
        list.remove(list.size()-1);
    }
}