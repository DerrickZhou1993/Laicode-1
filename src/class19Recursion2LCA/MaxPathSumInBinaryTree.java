package class19Recursion2LCA;

public class MaxPathSumInBinaryTree {
	class TreeNode {
		private int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	private int globalMax = Integer.MIN_VALUE;
	public int maxPath(TreeNode root) {
		if(root == null) {
			return 0;
		}
		helper(root);
		return globalMax;
	}
	private int helper(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = Math.max(0, helper(root.left));
		int right = Math.max(0, helper(root.right));
		
		if(root.left != null && root.right != null) {
			globalMax = Math.max(0, left + right + root.val);
			return Math.max(left, right) + root.val;
		}
		globalMax = root.left == null ? right + root.val : left + root.val;
		return root.left == null ? right + root.val : left + root.val;
	}
}
