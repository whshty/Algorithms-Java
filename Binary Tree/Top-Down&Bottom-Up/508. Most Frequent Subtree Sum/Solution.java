public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap();
        helper(map, root);  
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        } 
        List<Integer> res = new ArrayList();
        for(int key: map.keySet()){
            if(map.get(key) == max) res.add(key);
        }   
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);  
        }
        return result;
    }
    private int helper(Map<Integer,Integer> map, TreeNode root){
        if(root == null) return 0;
        int left = helper(map, root.left);
        int right = helper(map, root.right);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}