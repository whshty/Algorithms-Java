public class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        return helper(root,0,sum,map);
    }
    public int helper(TreeNode root , int curSum, int target, HashMap<Integer,Integer> map){
        if( root == null ){
            return 0;
        }
        
        curSum += root.val;
        int res = map.getOrDefault(curSum - target, 0);
        map.put(curSum,map.getOrDefault(curSum,0) + 1 );
        res += helper(root.left,curSum,target,map) + helper(root.right,curSum,target,map);
        map.put(curSum,map.get(curSum)-1);
        
        return res;
    }
}