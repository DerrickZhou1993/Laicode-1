package class4BinaryTreeAndBinarySearchTree;

/**
 * 
 * @author @Yifeng
 * Check if a given binary tree is balanced. A balanced binary tree is one in which the depths of every node¡¯s 
 * left and right subtree differ by at most 1.

	Examples
	
	        5
	
	      /    \
	
	    3        8
	
	  /   \        \
	
	1      4        11
	
	is balanced binary tree,
	
	        5
	
	      /
	
	    3
	
	  /   \
	
	1      4
	
	is not balanced binary tree.
	
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
 * Primitive Solution which used nested recursion function so the time complexity and space complexity is not good enough
 * This solution is based on the primary property of balanced binary tree
 */
public class CheckIfBinaryTreeIsBalanced {
	/*
	 * time : O(nlogn)
	 */
//	public boolean isBalanced(TreeNode root) {
//	    // Write your solution here.
//		if(root == null) {
//			return true;
//		}
//		
//		int leftHeight = getHeight(root.left);
//		int rightHeight = getHeight(root.right);
//		if(Math.abs(leftHeight - rightHeight) > 1) {
//			return false;
//		}
//		
//	    return isBalanced(root.left) && isBalanced(root.right);
//	  }
//	
//	private int getHeight(TreeNode root) {
//		if(root == null) {
//			return 0;
//		}
//		
//		int left = getHeight(root.left);
//		int right = getHeight(root.right);
//		
//		return Math.max(left,right) + 1;
//	}
	
	public boolean isBalanced(TreeNode root) {
		
		return false;
	}
}
