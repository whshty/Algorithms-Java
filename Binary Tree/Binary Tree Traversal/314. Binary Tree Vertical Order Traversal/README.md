* Use a HashMap to store column value and related result list
* Use a HashMap to store the TreeNode and the according cloumn value
* Map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1

```java
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        HashMap<Integer,ArrayList<Integer>> resMap = new HashMap<>();// map for generating output basde on weight values
        HashMap<TreeNode,Integer> weightMap = new HashMap<>(); // assign weigth values in BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        weightMap.put(root,0);
        int min = 0;
        
        while( !queue.isEmpty()){
            TreeNode node = queue.poll();
            int weight = weightMap.get(node);
            
            resMap.putIfAbsent(weight,new ArrayList<>());
            resMap.get(weight).add(node.val);
            
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
        
        while( resMap.containsKey(min)){
            res.add(resMap.get(min++));
        }
        
        return res;
    }
}
```
