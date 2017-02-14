/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root  == null ) return res;
        //Using a deque to maintain the current nodes in the same level with same order froem left to right 
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        
        // The order to put into result 
        boolean lefttoRight = true; 
        deque.addFirst(root);
        
        while ( !deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0 ; i < size ; i ++){
                //case 1 
                if (lefttoRight){
                    TreeNode cur = deque.pollFirst();
                    list.add(cur.val);
                    if (cur.left != null) deque.addLast(cur.left);
                    if (cur.right != null) deque.addLast(cur.right);
                }
                // case 2 
                else {
                    TreeNode cur = deque.pollLast();
                    list.add(cur.val);
                    if (cur.right != null) deque.addFirst(cur.right);
                    if (cur.left != null) deque.addFirst(cur.left);
                }
            }
            lefttoRight = lefttoRight ? false: true;
            res.add(list);
            
        }
        return res;
    }
    
}