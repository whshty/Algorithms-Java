// Queue + BFS 
class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if( root == null ) return;
        queue.offer(root);
        
        while( !queue.isEmpty() ){
            int size = queue.size();
            TreeLinkNode temp = null;
            for(int i = 0 ; i < size ; i++){
                TreeLinkNode node = queue.poll();
                node.next = temp;
                temp = node;
                if( node.right != null) queue.offer(node.right);
                if( node.left != null) queue.offer(node.left);
            }
        }
    }
}

// DFS
class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Map<Integer, TreeLinkNode> map = new HashMap<>();
        dfs(root, map, 0);
    }

    public void dfs(TreeLinkNode root, Map<Integer, TreeLinkNode> map, int level) {
        if (root == null) return;
        if (!map.containsKey(level)) {
            map.put(level, root);
        }
        else {
            TreeLinkNode pre = map.get(level);
            pre.next = root;
            map.put(level, root);
        }

        dfs(root.left, map, level+1);
        dfs(root.right, map, level+1);
    }
}


// Pointers
class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root, dummy = new TreeLinkNode(-1);
        
        // Different levels
        while( node != null ){ 
            TreeLinkNode cur = dummy;
            
            // Same level
            while( node != null ){
                if( node.left != null ){
                    cur.next = node.left;
                    cur = cur.next;
                }
                if( node.right != null ){
                    cur.next = node.right;
                    cur = cur.next;
                }
                // move node to next in same level
                node = node.next; 
            }
            
            node = dummy.next;
            dummy.next = null;  
        }
    }
}