public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if( root == null ) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = root;
        
        DoublyListNode dummy = new DoublyListNode(-1);
        DoublyListNode head = dummy;
        
        while( node != null || !deque.isEmpty()){
            if ( node != null ){
                deque.addFirst(node);
                node = node.left;
            } else{
                node = deque.removeFirst();
                DoublyListNode cur = new DoublyListNode(node.val);
                head.next = cur;
                
                cur.prev = head;
                head = head.next;
                node = node.right;
            }
        } 
        return dummy.next;
    }
}

// Recursion
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Solution sol = new Solution();
        sol.convert(root);

        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        while (cur.right != null) {
            System.out.print(cur.val);
            cur = cur.right;
        }
        System.out.print(cur.val);
        System.out.println("");

        while (cur.left != null) {
            System.out.print(cur.val);
            cur = cur.left;
        }
        System.out.print(cur.val);


    }


    TreeNode prev = null;

    public void convert(TreeNode root) {
        if (root == null) return;
        convert(root.left);
        if (prev != null) {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
    }

    public void generateCycle(TreeNode root) {
        TreeNode pre = root, head = root;
        while (head.right != null) {
            head = head.right;
        }
        head.right = pre;
        pre.left = head;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

