package class4BinaryTreeAndBinarySearchTree;
/**
 * 
 * @author @Yifeng
 * How to re construct a complete binary tree from its 
 * level-order traversal sequence only.

	Assumptions:
	
	The given level-order is not null.
	Examples:
	
	{1, 2, 3} -->
	
	   1
	
	 /   \
	
	2     3
 */
public class LevelorderConstructCompleteBinaryTree {
	public TreeNode construct(int[] level) {
		if (level == null || level.length == 0) {
			return null;
		}
		return helper(new TreeNode(level[0]), level, 0);
	}

	private TreeNode helper(TreeNode root, int[] level, int i) {
		// base case
		if (i >= level.length) {
			return root;
		}
		TreeNode cur = new TreeNode(level[i]);
		root = cur;
		root.left = helper(root.left, level, 2 * i + 1);
		root.right = helper(root.right, level, 2 * i + 2);
		return root;
	}
}
