public class Codec {

    private String MARK = ",";
    private String NULL = "N";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildTree(root,sb);
        return sb.toString();
    }
    private void buildTree(TreeNode node, StringBuilder sb){
        if( node == null ) sb.append(NULL).append(MARK);
        else{
            sb.append(node.val).append(MARK);
            buildTree(node.left,sb);
            buildTree(node.right,sb);
        }
    }
    
    public TreeNode deserialize(String data) {
        Deque<String> deque  = new  LinkedList<>();
        deque.addAll(Arrays.asList(data.split(MARK)));
        return buildTree(deque);
    }
    
    
    private TreeNode buildTree(Deque<String> deque){
        String root = deque.remove();
        if(root.equals(NULL)) return null;
        else{ 
            TreeNode node = new TreeNode(Integer.valueOf(root));
            node.left = buildTree(deque);
            node.right = buildTree(deque);
            return node;
        }
    }
}