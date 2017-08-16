package class4BinaryTreeAndBinarySearchTree;
/**
 * 
 * @author @Yifeng
 * Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.

If there does not exist any such paths, return 0.

Examples

    5

  /    \

2      11

     /    \

    6     14

The diameter of this tree is 4 (2 ¡ú 5 ¡ú 11 ¡ú 14)

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
 *  this problem is the same as Leaf to Leaf max path problem
 *  only when we at a node which has both lchild and rchild 
 *  can we have the right to update globalMax (guarantee leaf to leaf)
 */
public class BinaryTreeDiameter {
	private int globalMax = 0;

	public int diameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root);
		return globalMax;
	}

	private int helper(TreeNode root) {
		// base case
		if (root == null) {
			return 0;
		}

		int left = helper(root.left);
		int right = helper(root.right);

		if (root.left != null && root.right != null) {
			globalMax = Math.max(globalMax, left + right + 1);
			return Math.max(left, right) + 1;
		}
		return root.left == null ? right + 1 : left + 1;
	}
}

