 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if( n == 0 ) return new ArrayList<>();
        return helper(1,n);    
    }
    public List<TreeNode> helper(int start , int end){
        List<TreeNode> res =  new ArrayList<TreeNode>();
        if( start > end ){
            res.add(null);
        }
        // pick ith node as the root
        // get all possible left subtree and right subtree
        for( int i = start ; i <= end; i++ ){
            List<TreeNode> left = helper(start,i-1);
            List<TreeNode> right = helper(i+1,end);
            for( TreeNode leftNode : left ){
                for( TreeNode rightNode : right ){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}