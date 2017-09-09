package TAclass5_Matrix;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author @Yifeng
 	
	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	
	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].
 */
/*
 * basic idea: traverse upper row, right column, bottom row and then left column direction by direction
 * pay attention to corner element, each element shall only be traversed once
 * time = O(n)
 * space = O(1)
 * 
 * recursion method works only when the given matrix is a square, not recommended by need to handle
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int up = 0;
		int down = m - 1;
		int left = 0;
		int right = n - 1;
		while (left < right && up < down) { // guarantee rectangle exists
			for (int i = left; i <= right; i++) { // upper row
				res.add(matrix[up][i]);
			}
			for (int i = up + 1; i <= down - 1; i++) { // right column
				res.add(matrix[i][right]);
			}
			for (int i = right; i >= left; i--) { // bottom row
				res.add(matrix[down][i]);
			}
			for (int i = down - 1; i >= up + 1; i--) { // left column
				res.add(matrix[i][left]);
			}
			up++;
			down--;
			left++;
			right--;

		}
		if (left > right || up > down) { // no valid element left
			return res;
		} else if (left == right) { // only one column left
			for (int i = up; i <= down; i++) {
				res.add(matrix[i][left]);
			}
		} else { // only one row left
			for (int i = left; i <= right; i++) {
				res.add(matrix[up][i]);
			}
		}
		return res;
	}
}
