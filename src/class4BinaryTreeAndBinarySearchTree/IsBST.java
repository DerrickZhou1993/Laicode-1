package class4BinaryTreeAndBinarySearchTree;

/**
 * 
 * @author @Yifeng
 * Determine if a given binary tree is binary search tree.

	Assumptions
	
	There are no duplicate keys in binary search tree.
	You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
	Corner Cases
	
	What if the binary tree is null? Return true in this case.
 */

/*
 * BST:for every single node in the tree, the values in its left subtree are all
 * smaller than its value, and the values in its right subtree are all larger than 
 * its value
 */

/*
 * To solve this question,we need to use BST basic property which is 
 * the further go to the left ,the value is smaller, 
 * the further go to the right, the value is larger,
 * we don't know and also we don't care the smallest and largest value,
 * what we care is that when we go to left, the max bound of current node in left subtree is known and should be updated
 *                      when we go to right, the min bound of current node in right subtree is known and should be updated
 * 								
 */
public class IsBST {
	public boolean isBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		
	    return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	  }
	
	private boolean isBST(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.key < min || root.key > max) {
			return false;
		}
		
		return isBST(root.left,min,root.key - 1) && isBST(root.right,root.key + 1,max);
	}
}
