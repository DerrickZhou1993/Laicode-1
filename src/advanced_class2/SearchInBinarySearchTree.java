package advanced_class2;

import advanced_class2.InsertInBinarySearchTree.TreeNode;

/**
 * 
 * @author @Yifeng
 * Find the target key K in the given binary search tree, return the node 
 * that contains the key if K is found, otherwise return null.

Assumptions

There are no duplicate keys in the binary search tree
 */


public class SearchInBinarySearchTree {
	public TreeNode search(TreeNode root, int key) {
		// Write your solution here.
		if (root == null) {
			return root;
		}
		TreeNode cur = root;
		while (cur != null) {
			if (cur.key < key) {
				cur = cur.right;
			} else if (cur.key > key) {
				cur = cur.left;
			} else {
				return cur;
			}
		}
		return null;
	}
}
