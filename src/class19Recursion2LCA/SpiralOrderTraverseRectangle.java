package class19Recursion2LCA;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

	Assumptions
	
	The 2D array is not null and has size of M * N where M, N >= 0
	Examples
	
	{ {1,  2,  3,  4},
	
	  {5,  6,  7,  8},
	
	  {9, 10, 11, 12} }
	
	the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 */
public class SpiralOrderTraverseRectangle {
	/*
	 * basic idea, for the length of rows and columns are not equal, do it iteratively from 4 directions
	 */
	public List<Integer> spiral(int[][] matrix) {
		// assume the matrix is not null and the length is not 0;
		List<Integer> result = new ArrayList<>();
		int m = matrix.length;
		if (m == 0) {
			return result;
		}
		int n = matrix[0].length;
		// initialize four directions row and column start index
		int up = 0;
		int right = n - 1;
		int down = m - 1;
		int left = 0;
		while (left < right && up < down) { //guarantee a rectangle exists
			// upper row
			for (int i = left; i <= right; i++) {
				result.add(matrix[up][i]);
			}

			// right column
			for (int i = up + 1; i <= down - 1; i++) {
				result.add(matrix[i][right]);
			}

			// bottom row
			for (int i = right; i >= left; i--) {
				result.add(matrix[down][i]);
			}

			// left column
			for (int i = down - 1; i >= up + 1; i--) {
				result.add(matrix[i][left]);
			}
			up++;
			right--;
			down--;
			left++;
		}
		//handle special cases:
		if (up > down || left > right) { // if no column or row left
			return result;
		} else if (left == right) { // if there is one column left
			for (int i = up; i <= down; i++) {
				result.add(matrix[i][left]);
			}
		} else { // if there is one row left
			for (int i = left; i <= right; i++) {
				result.add(matrix[up][i]);
			}
		}
		return result;
	}
}


