# Method of Building a Tree
* In-order : cannot find the root
* Level-order : Waste of space 

## 1.Pre-Order and Recurison

```java
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
```

## 2.1.Follow Up - Use LinkedList and Recurion
```java

public class Solution {
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
```
