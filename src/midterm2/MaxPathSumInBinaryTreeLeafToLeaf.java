package midterm2;
/**
 * 
 * @author @Yifeng
 * Given a binary tree in which each node contains an integer number. Find the maximum possible sum from one leaf node to
   another leaf node. If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).

Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */

/*
 *  Basic idea: three step dfs
 *  
 *  this problem is the same as binary tree diameter problem
 *  only when we at a node which has both lchild and rchild 
 *  can we have the right to update globalMax (guarantee leaf to leaf)
 */
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
		// to guarantee leaf to leaf, only when we reach a node
		// which has both left child and right child, can we have 
		// right to update globalMax!!!
		if (root.left != null && root.right != null) {
			globalMax = Math.max(globalMax, left + right + root.key);
			return Math.max(left, right) + root.key;
		}
		return root.left == null ? root.key + right : root.key + left;
	}
}
