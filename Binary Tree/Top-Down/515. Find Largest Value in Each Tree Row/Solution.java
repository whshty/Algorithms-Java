public class Solution {
    public List<Integer> largestValues(TreeNode root) {
	    List<Integer> res = new ArrayList<>();
	    dfs(res, root, 0);
	    return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int row) {
	    if (root == null) return;    	
	    setMax(res, root, row);
	    dfs(res, root.left, row + 1);
	    dfs(res, root.right, row + 1);
    }

    private void setMax(List<Integer> res, TreeNode root, int row) {
	    if (row >= res.size()) res.add(root.val);
	    else res.set(row, Math.max(root.val, res.get(row)));
    }
}