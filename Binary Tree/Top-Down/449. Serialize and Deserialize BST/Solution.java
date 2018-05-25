public class Codec {
    
    private final static String NULL = "N";
    private final static String COMMA = ",";
    
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }
    
    private void buildString(StringBuilder sb, TreeNode node) {
        if (node == null) sb.append(NULL).append(COMMA);
        else {
            sb.append(node.val).append(COMMA);
            buildString(sb, node.left);
            buildString(sb, node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(COMMA)));
        return buildTree(deque);
    }
    
    private TreeNode buildTree(Deque<String> deque) {
        String val = deque.poll();
        if (val.equals(NULL)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }
}
