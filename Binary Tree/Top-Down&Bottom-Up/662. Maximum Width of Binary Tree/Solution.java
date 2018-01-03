class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return helper(root , 0 , 1 , new ArrayList<>() , new ArrayList<>());   
    }
    public int helper(TreeNode root , int level , int id, List<Integer> lefts, List<Integer> rights ){
        if( root == null ) return 0;
        if( lefts.size() == level ){
            lefts.add(id);
            rights.add(id);
        } else { 
            rights.set(level,id);
        }
        int cur = rights.get(level) - lefts.get(level) + 1;
        int left = helper(root.left, level + 1, 2 * id, lefts, rights);
        int right = helper(root.right, level + 1, 2 * id + 1, lefts,rights);
        return Math.max(cur, Math.max(left, right));
    
    }
}