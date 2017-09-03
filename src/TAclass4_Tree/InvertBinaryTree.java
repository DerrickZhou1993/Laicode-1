package TAclass4_Tree;

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
