package TAclass4_Tree;
/**
 * 
 * @author yifengguo
 	Given a binary tree, determine if it is height-balanced.

	For this problem, a height-balanced binary tree is defined as a binary tree 
	in which the depth of the two subtrees of every node never differ by more than 1.
 */
/*
 * more elegant code for determining if a binary tree is balanced
 * only need O(n) time and O(height) space
 * recommended
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int res = getHeight(root);
		return res != -1;
	}
	
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left == -1 || right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	
	
	/*
	 * time = O(nlogn)
	 * space = O(height ^ 2)
	 * nested recursion costs much time and space, not recommended
	 */
//	public boolean isBalanced(TreeNode root) {
//		if (root == null) {
//			return true;
//		}
//		int left = getHeight(root.left);
//		int right = getHeight(root.right);
//		if (Math.abs(left - right) > 1) {
//			return false;
//		}
//		return isBalanced(root.left) && isBalanced(root.right);
//	}
//	
//	private int getHeight(TreeNode root) {
//		if (root == null) {
//			return 0;
//		}
//		int left = getHeight(root.left);
//		int right = getHeight(root.right);
//		return Math.max(left, right) + 1;
//	}
}
