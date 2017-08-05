public TreeNode deepCopyTree(TreeNode root) {
	if (root == null) {
		return null;
	}
	TreeNode leftNode = deepCopyTree(root.left);
	TreeNode rightNode = deepCopyTree(root.right);

	TreeNode cur = new TreeNode(root.val);
	cur.left = leftNode;
	cur.right = rightNode;
	return cur;
}