package TAclass4_Tree;
/**
 * 
 * @author yifengguo
  Invert a binary tree.

	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	    to
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
 */
/*
 * time = O(n)
 * space = O(height)
 */
class TreeNode {
	TreeNode left;
	TreeNode right;
	int key;
	public TreeNode(int key) {
		this.key = key;
	}
}
public class InvertBinaryTree {
	public TreeNode invert(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = invert(root.left);
		TreeNode right = invert(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
}
