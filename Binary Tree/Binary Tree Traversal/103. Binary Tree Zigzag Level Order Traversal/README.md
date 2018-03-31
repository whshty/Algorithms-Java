## Deque

```java
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if( root == null ) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        boolean leftToRight = true;
        deque.push(root);
        
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            if(leftToRight){
                addTreeNodeFromLeftToRight(deque,list,size);
            } else{
                addTreeNodeFromRightToLeft(deque,list,size);
            }
            res.add(list);
            leftToRight = leftToRight ? false : true;
        }
        return res;
    }
    
    private void addTreeNodeFromLeftToRight(Deque<TreeNode> deque, List<Integer> list, int size ){
        for (int i = 0 ; i < size ; i++){
            TreeNode node = deque.pollFirst();
            list.add(node.val);  
            if (node.left != null ) deque.addLast(node.left);
            if (node.right != null) deque.addLast(node.right);
        }
    }
    
    private void addTreeNodeFromRightToLeft(Deque<TreeNode> deque, List<Integer> list, int size){
        for(int i = 0 ; i < size ; i++){
            TreeNode node = deque.pollLast();
            list.add(node.val);
            if (node.right != null ) deque.addFirst(node.right);
            if (node.left != null ) deque.addFirst(node.left);
        }
    }
}
```