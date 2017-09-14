package TAclass6_DFS;
/**
 * 
 * @author yifengguo
 		
 		delete nodes which has and only has one child
 		
 		1 ,11 and 4 has 0 child so cannot be deleted
 		
                 2
               /   \
              7     5
              \      \
               6      9
             /   \    /
            1    11   4
            
            to 
            
            	  2
            	 / \
            	6   4
               / \
              1  11
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
public class DeleteHalfOfTree {
	public TreeNode deleteHalf(TreeNode root) {
		if (root == null) {
			return root;
		}
		root.left = deleteHalf(root.left);
		root.right = deleteHalf(root.right);
		
		if (root.left == null && root.right == null) {
			return null;
		} else if (root.left == null || root.right == null) {
			return root.left != null ? root.left : root.right;
		} else {
			return root;
		}
	}
}
