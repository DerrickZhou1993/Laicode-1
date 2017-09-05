package TAclass4_Tree;
/**
 * 
 * @author yifengguo
 	Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	Example 1:
	    2
	   / \
	  1   3
	Binary tree [2,1,3], return true.
	Example 2:
	    1
	   / \
	  2   3
	Binary tree [1,2,3], return false.
 */
/*
 * 		sol:
			step1: maintain current node's valid range (min and max)
			step2: if the current node's value is out of valid range, return false
				   else current node's value will be passed as max limit to left child
				        current node's value will be passed as min limit to right child
			recursively call the function
			
			time = O(n)
			space = O(height)
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean helper(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.key >= max || root.key <= min) {
			return false;
		}
		return helper(root.left, min, root.key) && helper(root.right, root.key, max);
	}
}

