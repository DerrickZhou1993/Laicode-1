package class4BinaryTreeAndBinarySearchTree;

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
