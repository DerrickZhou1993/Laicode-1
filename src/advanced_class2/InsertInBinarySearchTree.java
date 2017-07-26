package advanced_class2;
/**
 * 
 * @author @Yifeng
 * Insert a key in a binary search tree if the binary search tree does not already contain the key. Return the root of the binary search tree.

Assumptions

There are no duplicate keys in the binary search tree

If the key is already existed in the binary search tree, you do not need to do anything

Examples

        5

      /    \

    3        8

  /   \

 1     4

insert 11, the tree becomes

        5

      /    \

    3        8

  /   \        \

 1     4       11

insert 6, the tree becomes

        5

      /    \

    3        8

  /   \     /  \

 1     4   6    11
 */



  
public class InsertInBinarySearchTree {
	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int key) {
			this.key = key;
		}
	}

	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		TreeNode cur = root;
		TreeNode parent = cur;
		while (cur != null) {
			parent = cur;
			if (cur.key < key) {
				cur = cur.right;
			} else if (cur.key > key) {
				cur = cur.left;
			} else {
				return root;
			}
		}
		if (parent.key > key) {
			parent.left = new TreeNode(key);
		} else {
			parent.right = new TreeNode(key);
		}
		return root;
	}
}

