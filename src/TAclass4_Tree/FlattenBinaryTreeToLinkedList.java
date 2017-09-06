package TAclass4_Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author yifengguo
 	
	Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
 */
public class FlattenBinaryTreeToLinkedList {
	/*
	 * elegant recursion
	 */
	private TreeNode prev = null;
	public void flatten(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}
		flatten(root.right);
		flatten(root.left);
	}
	
	
	
	
	
	
	/*
	 * intuitive thinking use pre-order traversal of bianry tree
	 * which is not concise and elegant enough
	 * time = O(n)
	 * space = O(n)
	 */
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            list.add(cur);
        }
        for (int i = 1; i < list.size(); i++) {
            root.left = null;
            root.right = list.get(i);
            root = root.right;
        }
        return;
    }
}