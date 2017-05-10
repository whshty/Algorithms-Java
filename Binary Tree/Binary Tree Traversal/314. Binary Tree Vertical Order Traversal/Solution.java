public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        HashMap<TreeNode,Integer> weightMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        weightMap.put(root,0);
        int min = 0;
        
        while( !queue.isEmpty()){
            TreeNode node = queue.poll();
            int weight = weightMap.get(node);
            
            map.putIfAbsent(weight,new ArrayList<>());
            
            map.get(weight).add(node.val);
            
            if( node.left != null){
                queue.add(node.left);
                weightMap.put(node.left,weight-1);
            }
            
            if( node.right != null ){
                queue.add(node.right);
                weightMap.put(node.right,weight+1);
            }
            min = Math.min(min,weight);
        }
        
        while( map.containsKey(min)){
            res.add(map.get(min++));
        }
        
        return res;
    }
}