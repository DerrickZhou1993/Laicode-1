package class19Recursion2LCA;
/**
 * 
 * @author @Yifeng
 * Generate an M * N 2D array in spiral order clock-wise starting from the top left corner, using the numbers of 1, 2, 3, бн, M * N in increasing order.

	Assumptions
	
	M >= 0, N >= 0
	Examples
	
	M = 3, N = 4, the generated matrix is
	
	{ {1,  2,  3,  4}
	
	  {10, 11, 12, 5},
	
	  {9,  8,  7,  6} }
 */
public class SpiralOrderGenerator {
	/*
	 * the idea as SpiralOrderTraverseRectangle does
	 */
	public int[][] spiralGenerate(int m, int n) {
		int[][] matrix = new int[m][n];
		if (m == 0 || n == 0) {
			return matrix;
		}
		int count = 1;
		int up = 0;
		int right = n - 1;
		int down = m - 1;
		int left = 0;
		while (up < down && left < right) {
			// upper row
			for (int i = left; i <= right; i++) {
				matrix[up][i] = count++;
			}
			// right column
			for (int i = up + 1; i <= down - 1; i++) {
				matrix[i][right] = count++;
			}
			// bottom row
			for (int i = right; i >= left; i--) {
				matrix[down][i] = count++;
			}
			// left column
			for (int i = down - 1; i >= up + 1; i--) {
				matrix[i][left] = count++;
			}
			left++;
			right--;
			up++;
			down--;
		}
		if (up > down || left > right) { // nothing left
			return matrix;
		} else if (left == right) { // one column left
			for (int i = up; i <= down; i++) {
				matrix[i][left] = count++;
			}
		} else {
			for (int i = left; i <= right; i++) {
				matrix[up][i] = count++;
			}
		}
		return matrix;
	}
}

