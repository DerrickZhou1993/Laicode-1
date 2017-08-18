package class4BinaryTreeAndBinarySearchTree;
/**
 * 
 * @author @Yifeng
 * 
 * Given Inorder and Preorder traversals of a binary tree, get the Postorder traversal without reconstructing a binary tree.

	Assumptions:
	
	The given Inorder and Preorder traversals are guaranteed to be valid.
	Examples:
	
	Input:
	
	Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
	Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
	
	Output:
	Postorder traversal is {4, 5, 2, 6, 3, 1}
 */

/*
   The idea is, root is always the first item in preorder traversal and it must be the last item in postorder traversal. 
   We first recursively print left subtree, then recursively print right subtree. Finally, print root. 
  
   To find boundaries of left and right subtrees in pre[] and in[], we search root in in[], all elements before root in in[] are 
   elements of left subtree and all elements after root are elements of right subtree. 
   
   In pre[], all elements after index of root in in[] are elements of right subtree. And elements before index 
   (including the element at index and excluding the first element) are elements of left subtree.

 */
public class GetPostorderSequenceByPreorderAndInorder {
	public int[] postOrder(int[] pre, int[] in) {
		int[] result = new int[pre.length];
		if (pre == null || pre.length == 0 || in == null || in.length == 0) {
			return new int[] {};
		}
		helper(0, in.length - 1, in, pre, result);
		return result;
	}

	private int getRootIndex(int inStart, int inEnd, int[] in, int x) {
		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == x) {
				return i;
			}
		}
		return -1;
	}

	static int preIndex = 0;
	static int cur = 0; // pointer of result

	private void helper(int inStart, int inEnd, int[] in, int[] pre, int[] result) {
		// base case
		if (inStart > inEnd) {
			return;
		}
		// add left and right child
		if (inStart == inEnd) {
			result[cur++] = pre[preIndex++];
			return;
		}
		// get current layer root index in in[]
		int rootIndex = getRootIndex(inStart, inEnd, in, pre[preIndex++]);
		helper(inStart, rootIndex - 1, in, pre, result);
		helper(rootIndex + 1, inEnd, in, pre, result);
		// add current layer rot
		result[cur++] = in[rootIndex];
	}
	
	public static void main(String[] args) {
		int[] pre = new int[]{4,5,6};
		int[] in = new int[]{4,5,6};
		GetPostorderSequenceByPreorderAndInorder test = new GetPostorderSequenceByPreorderAndInorder();
		int[] res = test.postOrder(pre, in);
		for(int i : res) {
			System.out.print(i + " ");
		}
	}
}
