package advanced_class2;


/**
 * 
 * @author guoyifeng
 * In a binary search tree, find the node containing the largest number smaller than the given target number.

	If there is no such number, return INT_MIN.
	
	Assumptions:
	
	The given root is not null.
	There are no duplicate keys in the binary search tree.
	Examples
	
	    5
	
	  /    \
	
	2      11
	
	     /    \
	
	    6     14
	
	largest number smaller than 1 is Integer.MIN_VALUE(Java) or INT_MIN(c++)
	
	largest number smaller than 10 is 6
	
	largest number smaller than 6 is 5
	
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
 * case 1: if(cur.val < target) update solution_so_far, cur = cur.right (try to find larger one)
 * case 2: if(cur.val >= target) do not update solution_so_far, cur = cur.left;(find from smaller one)
 */
public class LargestNumberOfSmallerInBinarySearchTree {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}

	public int largestSmaller(TreeNode root, int target) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		TreeNode cur = root;
		int tmpMax = Integer.MIN_VALUE;
		while (cur != null) {
			if (cur.key < target) {
				tmpMax = cur.key;
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		return tmpMax;
	}
}
