class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        // map for generating output basde on weight values
        Map<Integer,ArrayList<Integer>> posToRes = new HashMap<>();
        // assign weigth values in BFS
        Map<TreeNode,Integer> nodeToWeight = new HashMap<>(); 
        int minPos = traverseTree(root,posToRes,nodeToWeight);
        
        while( posToRes.containsKey(minPos)){
            res.add(posToRes.get(minPos++));
        } 
        return res;
    }
    
    private int traverseTree(
        TreeNode root,
        Map<Integer,ArrayList<Integer>> posToRes, 
        Map<TreeNode,Integer> nodeToWeight){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            nodeToWeight.put(root,0);
            int min = 0;

            while( !queue.isEmpty()){
            TreeNode node = queue.poll();
            int curWeight = nodeToWeight.get(node);
            
            posToRes.putIfAbsent(curWeight,new ArrayList<>());
            posToRes.get(curWeight).add(node.val);
            
            if( node.left != null){
                queue.add(node.left);
                nodeToWeight.put(node.left,curWeight-1);
            }
            
            if( node.right != null ){
                queue.add(node.right);
                nodeToWeight.put(node.right,curWeight+1);
            }
            min = Math.min(min,curWeight);
        }
        return min;
    }
}