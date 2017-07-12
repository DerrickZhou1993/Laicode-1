package class19Recursion2LCA;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

	Assumptions
	
	The 2D array is not null and has size of N * N where N >= 0
	Examples
	
	{ {1,  2,  3},
	
	  {4,  5,  6},
	
	  {7,  8,  9} }
	
	the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 */
public class SpiralOrderTraverseSquare {
	public List<Integer> spiral(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		List<Integer> result = new ArrayList<>();
		helper(matrix, 0, matrix.length, result);
		return result;
	}

	private void helper(int[][] matrix, int offset, int size, List<Integer> result) {
		// Base case
		if (size == 1) {
			result.add(matrix[offset][offset]);
			return;
		} else if (size < 1) {
			return;
		}

		// upper row
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[0 + offset][i + offset]);
		}

		// right column
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[i + offset][size - 1 + offset]);
		}

		// bottom row
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[size - 1 + offset][size - 1 - i + offset]);
		}

		// left column
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[size - 1 - i + offset][0 + offset]);
		}

		helper(matrix, offset + 1, size - 2, result);// recursive call
	}
}

