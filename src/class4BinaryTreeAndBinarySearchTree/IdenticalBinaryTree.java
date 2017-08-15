package class4BinaryTreeAndBinarySearchTree;
/**
 * 
 * @author @Yifeng
 *  Check if two given binary trees are identical. Identical means the equal valued keys are at the same 
 *  position in the two binary trees.

Examples

 

        5

      /    \

    3        8

and

        5

      /    \

    3        8

are identical trees.

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
 */

/*
 * Time = O(n)
 * Space = O(height) = O(logn) if tree is balanced
 */
public class IdenticalBinaryTree {
	  public boolean isIdentical(TreeNode one, TreeNode two) {
	    // Write your solution here.
	    if (one == null && two == null) {
	      return true;
	    } else if (one == null || two == null) {
	      return false;
	    } else if (one.key != two.key) {
	      return false;
	    }
	    return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
	  }
	}
