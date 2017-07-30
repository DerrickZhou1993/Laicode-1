package midterm2;

public class MaxPathSumInBinaryTreeLeafToLeaf {

	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}

	private int globalMax = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		helper(root);
		return globalMax;
	}

	private int helper(TreeNode root) {
		if (root == null) {// base case
			return 0;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		if (root.left != null && root.right != null) {
			globalMax = Math.max(globalMax, left + right + root.key);
			return Math.max(left, right) + root.key;
		}
		return root.left == null ? root.key + right : root.key + left;
	}
}
