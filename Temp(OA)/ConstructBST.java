import java.util.ArrayList;
import java.util.List;

public class ConstructBST {

    public static void main(String[] args) {
        int[] input = new int[]{5, 6, 3, 1, 2, 4};
        ConstructBST sol = new ConstructBST();
        System.out.println(sol.findDistance(input, 2, 4));

        int[] input2 = new int[]{12, 5, 9, 4, 8, 10};
        System.out.println(sol.findDistance(input2, 5, 8));
    }

    public int findDistance(int[] input, int a, int b) {

        TreeNode node = buildBST(input);
        List<TreeNode> path1 = buildTreePath(node, a);
        List<TreeNode> path2 = buildTreePath(node, b);

        return calDistance(path1, path2);
    }

    public int calDistance(List<TreeNode> path1, List<TreeNode> path2) {
        int ancestor = 0;

        if (path1 == null || path2 == null) return -1;

        int leftPath = 0;

        for (int i = 0; i < path1.size(); i++) {
            if (i < path2.size()) {
                if (path1.get(i) == path2.get(i)) ancestor = i;
                else leftPath++;
            } else {
                leftPath++;
            }
        }

        int rightPath = path2.size() - ancestor;
        return leftPath + rightPath - 1;

    }

    public TreeNode buildBST(int[] values) {
        TreeNode root = new TreeNode(values[0]);
        for (int i = 1; i < values.length; i++) {
            TreeNode node = root;
            while (node != null) {
                if (values[i] < node.value) {
                    if (node.left == null) {
                        TreeNode tempLeft = new TreeNode((values[i]));
                        node.left = tempLeft;
                        break;
                    }
                    node = node.left;
                } else {

                    if (node.right == null) {
                        TreeNode tempRight = new TreeNode(values[i]);
                        node.right = tempRight;
                        break;
                    }
                    node = node.right;
                }
            }
        }
        return root;
    }

    private List<TreeNode> buildTreePath(TreeNode root, int value) {

        List<TreeNode> path = new ArrayList<>();
        if (root == null) return path;
        TreeNode node = root;
        while (node != null) {
            path.add(node);
            if (value == node.value) break;

            if (value < node.value) node = node.left;

            else if (value > node.value) node = node.right;
        }

        return path;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        value = x;
    }
}
