package TAclass4_Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author @Yifeng
 	Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

	Calling next() will return the next smallest number in the BST.
	
	Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
	
	Credits:
	Special thanks to @ts for adding this problem and creating all test cases.
 */
/*
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
/*
 * use BST property which the inorder traversal of BST
 * will construct an ascending sequence
 */
public class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur != null || !stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.left;
        }
        cur = stack.pollFirst();
        int res = cur.key;
        cur = cur.right;
        return res;
    }
}
