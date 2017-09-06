package TAclass4_Tree;
/**
 * 
 * @author @Yifeng
 * given a BST and a range say[2,7]
 * remove all the nodes which are out of given range and return 
 * the new bst
 */

/*
 *           5
           /  \
	      3    8
         / \  / \
        2   4 7  9
		
		min 2 
		max 7
		
		time = O(n)
		space = O(height)

 */
public class DeleteNodesOutOfRangeFromBST {
	public TreeNode remove(TreeNode root, int min, int max) {
		if (root == null) {
			return root;
		}
		// traverse all the nodes
		root.left = remove(root.left, min, max);
		root.right = remove(root.right, min, max);
		
		// current recursion layer process
		if (root.key < min) {  // current root.key is too small
			return root.right; // try root.right
		} else if (root.key > max) {  // current root.key is too great
			return root.left;         // try root.left
		} 
		return root; // valid root in given range
	}
}

