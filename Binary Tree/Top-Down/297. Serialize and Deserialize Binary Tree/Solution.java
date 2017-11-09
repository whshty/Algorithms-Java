// Pre-Order and Recurison
public class Codec {
    private String N = "N"; // N for null
    private String M = ","; // M for marker

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode node, StringBuilder sb){
        if( node == null ) sb.append(N).append(M);
        else{
            sb.append(node.val).append(M);
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(s.split(M)));
        return buildTree(deque);
    }
    
    private TreeNode buildTree(Deque<String> deque){
        String root = deque.removeFirst();
        if(root.equals(N)) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(root));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }
}

// Pre-Order and Iteration
public class Codec {
    private String N = "N"; // N for null
    private String M = ","; // M for marker

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while ( node != null || !stack.isEmpty()) {
            if ( node != null) {
                sb.append(String.valueOf(node.val)).append(M);
                stack.push(node);
                node = node.left;
            } else {
                sb.append(N).append(M);
                node = stack.pop();
                node = node.right;
            }
        }
        sb.append(N);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if( s.length() == 0 ) return null;
        Deque<String> deque = new ArrayDeque<>();
        deque.addAll(Arrays.asList(s.split(M)));
        return buildTree(deque);
    }
    
    private TreeNode buildTree(Deque<String> deque){
        String root = deque.removeFirst();
        if(root.equals(N)) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(root));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }
}



// Follow Up - Use LinkedList and Recurion
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Solution sol = new Solution();
        ListNode node = sol.serialize(root);
//        while (node != null) {
//            System.out.print(node.val + " ");
//            node = node.next;
//        }

        TreeNode root2 = sol.deserialize(node);
        ListNode node2 = sol.serialize(root2);

    }


    public ListNode serialize(TreeNode root) {
        ListNode dummy = new ListNode(-1);
        buildLinkedList(root, dummy);
        return dummy.next;
    }

    private void buildLinkedList(TreeNode root, ListNode node) {
        if (root == null) {
            node.next = new ListNode(-1);
            node = node.next;
            return;
        } else {
            node.next = new ListNode(root.val);
            node = node.next;
            buildLinkedList(root.left, node);
            while (node.next != null) node = node.next;
            buildLinkedList(root.right, node);
        }
    }


    public TreeNode deserialize(ListNode node) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (node != null) {
            deque.add(node);
            node = node.next;
        }
        return buildTree(deque);
    }

    private TreeNode buildTree(Deque<ListNode> deque) {
        ListNode root = deque.removeFirst();
        if (root.val == -1) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(root.val));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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

// Use LinkedList and Iteration
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Solution sol = new Solution();
        ListNode node = sol.serialize(root);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

//        TreeNode root2 = sol.deserialize(node);
//        ListNode node2 = sol.serialize(root2);

    }


    public ListNode serialize(TreeNode root) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        while( cur != null || !deque.isEmpty()){
            if ( cur != null ){
                //res.add(cur.val);
                node.next = new ListNode(cur.val);
                node = node.next;
                deque.addFirst(cur);
                cur = cur.left;
            } else {
                node.next = new ListNode(-1);
                node = node.next;
                cur = deque.removeFirst();
                cur = cur.right;
            }
        }
        return dummy.next;

    }


    public TreeNode deserialize(ListNode node) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (node != null) {
            deque.add(node);
            node = node.next;
        }
        return buildTree(deque);
    }

    private TreeNode buildTree(Deque<ListNode> deque) {
        ListNode root = deque.removeFirst();
        if (root.val == -1) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(root.val));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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
