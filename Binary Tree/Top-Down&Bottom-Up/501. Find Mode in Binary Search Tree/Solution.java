public class Solution {
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0]; 
        Map<Integer,Integer> freq = new HashMap<>();
        int max = dfs(root, freq);
        return freq.entrySet().stream().
                filter(e -> e.getValue() == max).
                mapToInt(e -> e.getKey()).toArray();
    }
    
    private int dfs(TreeNode node, Map<Integer,Integer> map){
        if( node == null ) return 0;
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        int left = dfs(node.left,map);
        int right = dfs(node.right,map);
        return Math.max(map.get(node.val), Math.max(left, right));
    }
}