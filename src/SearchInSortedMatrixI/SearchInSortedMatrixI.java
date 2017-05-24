package SearchInSortedMatrixI;

/**
 * 
 * @author yifeng
 * Given a 2D matrix that contains integers only, which each row is sorted in an ascending order.
 *  The first element of next row is larger than (or equal to) the last element of previous row.

	Given a target number, returning the position that the target locates within the matrix. 
	If the target number does not exist in the matrix, return {-1, -1}.
	
	Assumptions:
	
	The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
	Examples:
	
	matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
	
	target = 7, return {1, 2}
	
	target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
	
 */

public class SearchInSortedMatrixI {
	public int[] search(int[][] matrix, int target) {
		
		// Write your solution here.
		/**
		 * The better solution which only uses binary search once suppose matrix
		 * is: L[0][0] 1 2 3 4 5 6 7 8 target == 7 9 10 11 12 R[n - 1][m - 1]
		 *
		 * start = 0; end = m * n - 1; mid = start + (end - start) / 2 = 0 + 11
		 * / 2 = 5 --> map 5 back to the matrix coordinates 5: row = mid /
		 * col_num = 5 / 4 = 1 col = mid % col_num = 5 % 4 = 1 ==> {1,1}
		 */
		if (matrix == null || matrix.length == 0) {
			return new int[] { -1, -1 };
		}
		if (matrix[0] == null || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}

		int row_num = matrix.length;
		int col_num = matrix[0].length;
		int start = 0;
		int end = row_num * col_num - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int x = mid / col_num;
			int y = mid % col_num;
			if (matrix[x][y] == target) {
				return new int[] { x, y };
			} else if (matrix[x][y] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return new int[] { -1, -1 };
		/**
		 * my first edition: double binary search which is not good; code is too
		 * long and the implementation is too complex;
		 */
		// if(matrix == null || matrix.length == 0) {
		// return new int[] {-1, -1};
		// }
		// if(matrix[0] == null || matrix[0].length == 0) {
		// return new int[] {-1, -1};
		// }

		// int row_start = 0;
		// int row_end = matrix.length - 1;
		// int col_start = 0;
		// int col_end = matrix[0].length - 1;

		// while(row_end - row_start > 1) {
		// int row_mid = row_start + (row_end - row_start) / 2;
		// if(matrix[row_mid][0] == target) {
		// row_end = row_mid;
		// }
		// else if(matrix[row_mid][0] < target) {
		// row_start = row_mid;
		// }
		// else {
		// row_end = row_mid;
		// }
		// }
		// if(matrix[row_end][0] == target) {
		// return new int[] {row_end, 0};
		// }
		// if(matrix[row_start][0] == target) {
		// return new int[] {row_start, 0};
		// }
		// if(matrix[row_end][0] > target) {
		// while(col_end - col_start > 1) {
		// int col_mid = col_start + (col_end - col_start) / 2;
		// if(matrix[row_start][col_mid] == target) {
		// col_end = col_mid;
		// }
		// else if(matrix[row_start][col_mid] < target) {
		// col_start = col_mid;
		// }
		// else {
		// col_end = col_mid;
		// }
		// }
		// if(matrix[row_start][col_end] == target) {
		// return new int[] {row_start, col_end};
		// }
		// if(matrix[row_start][col_start] == target) {
		// return new int[] {row_start, col_start};
		// }
		// }
		// if(matrix[row_start][0] < target) {
		// while(col_end - col_start > 1) {
		// int col_mid = col_start + (col_end - col_start) / 2;
		// if(matrix[row_end][col_mid] == target) {
		// col_end = col_mid;
		// }
		// else if(matrix[row_end][col_mid] < target) {
		// col_start = col_mid;
		// }
		// else {
		// col_end = col_mid;
		// }
		// }
		// if(matrix[row_end][col_end] == target) {
		// return new int[] {row_end, col_end};
		// }
		// if(matrix[row_end][col_start] == target) {
		// return new int[] {row_end, col_start};
		// }
		// }
		// return new int[] {-1, -1};
		
	}
}

