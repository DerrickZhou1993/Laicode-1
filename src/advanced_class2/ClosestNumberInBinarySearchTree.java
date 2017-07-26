package advanced_class2;

/**
 * 
 * @author guoyifeng
 * In a binary search tree, find the node containing the closest number to the given target number.
	
	Assumptions:
	
	The given root is not null.
	There are no duplicate keys in the binary search tree.
	Examples:
	
	    5
	
	  /    \
	
	2      11
	
	     /    \
	
	    6     14
	
	closest number to 4 is 5
	
	closest number to 10 is 11
	
	closest number to 6 is 6
	
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
 * maintain a min_diff and 
 * maintain a solution_node
 * 
 * case 1: if(cur.val < target) update solution_node & min_diff if feasible, cur = cur.right;
 * case 2: if(cur.val > target) update solution_node & min_diff if feasible, cur = cur.left;
 * case 3: if(cur.val == target) return cur
 */

 

public class ClosestNumberInBinarySearchTree {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}

	public int closest(TreeNode root, int target) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int result = root.key;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.key == target) {
				result = cur.key;
				return result;
			} else {
				if (Math.abs(cur.key - target) < Math.abs(result - target)) {
					result = cur.key;
				}
				if (cur.key > target) {
					cur = cur.left;
				} else {
					cur = cur.right;
				}
			}
		}
		return result;
	}
}


