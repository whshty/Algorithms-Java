* Use a HashMap to store column value and related result list
* Use a HashMap to store the TreeNode and the according cloumn value
* Map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1

```java
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        // map for generating output basde on weight values
        Map<Integer,ArrayList<Integer>> posToList = new HashMap<>();
        // assign weigth values in BFS
        Map<TreeNode,Integer> nodeToWeight = new HashMap<>(); 
        int minPos = traverseTree(root,posToList,nodeToWeight);
        
        while( posToList.containsKey(minPos)){
            res.add(posToList.get(minPos++));
        } 
        return res;
    }
    
    private int traverseTree(
        TreeNode root,
        Map<Integer,ArrayList<Integer>> posToList, 
        Map<TreeNode,Integer> nodeToWeight){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            nodeToWeight.put(root,0);
            int min = 0;

            while( !queue.isEmpty()){
                TreeNode node = queue.poll();
                int curWeight = nodeToWeight.get(node);
            
                posToList.putIfAbsent(curWeight,new ArrayList<>());
                posToList.get(curWeight).add(node.val);
            
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
```
