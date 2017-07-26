package advanced_class4_recursion4_DFS_NSum;

/*
 * basic idea: find out the subproblem to construct recursive rule
 * this tree must be "left-lean" binary tree
 */

public class ReverseBinaryTreeUpSideDown {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}

	public TreeNode reverse(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode newHead = reverse(root.left);
		root.left.left = root;
		root.left.right = root.right;
		root.left = null;
		root.right = null;
		return newHead;
	}
}

