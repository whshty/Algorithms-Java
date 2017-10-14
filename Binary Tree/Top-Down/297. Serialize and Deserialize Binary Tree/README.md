### Method of building a tree
* In-order : cannot find the root
* Level-order : Waste of space 

### Pre-Order

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
