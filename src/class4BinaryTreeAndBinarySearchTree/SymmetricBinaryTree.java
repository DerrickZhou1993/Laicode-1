package class4BinaryTreeAndBinarySearchTree;

/**
 * 
 * @author @Yifeng
 * Check if a given binary tree is symmetric.

	Examples
	
	        5
	
	      /    \
	
	    3        3
	
	  /   \    /   \
	
	1      4  4      1
	
	is symmetric.
	
	        5
	
	      /    \
	
	    3        3
	
	  /   \    /   \
	
	1      4  1      4
	
	is not symmetric.
	
	Corner Cases
	
	What if the binary tree is null? Return true in this case.
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
 * recursion function is help to check input parameter is equal or not
 * what matters is the parameter design. From symmetrical property we know
 * form layer 3, what need to check is the equality between right.right == left.left && right.left == left.right
 */
public class SymmetricBinaryTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		return helper(root.left,root.right);
	}
	
	/*
	 * this recursion function base case is to check 4 conditions on whether left and right are null or not 
	 */
	private boolean helper(TreeNode left, TreeNode right) {
		if(left == null && right == null) { //base case 1
			return true;
		}
		else if(left != null && right == null) {//base case 2
			return false;
		}
		else if(left == null && right != null) {//base case 3
			return false;
		}
		else if(left.key != right.key) {//base case 4 (this conditon left and right are both not null)
			return false; //must use != to check because == cannot check the child nodes below this pair of roots
		}
		return helper(left.left,right.right) && helper(left.right,right.left); //check the symmetrical property by recursion
	}
}
