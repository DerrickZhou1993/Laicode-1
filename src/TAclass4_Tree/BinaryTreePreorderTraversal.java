package TAclass4_Tree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreePreorderTraversal {
	public void preorder(TreeNode root) {
		if (root == null) {
			return;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			System.out.println(stack.peek());
			TreeNode cur = stack.pop();
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}
}
