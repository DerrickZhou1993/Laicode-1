package TAclass5_Matrix;
/**
 * 
 * @author @Yifeng
 	You are given an n x n 2D matrix representing an image.

	Rotate the image by 90 degrees (clockwise).
	
	Note:
	You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
	DO NOT allocate another 2D matrix and do the rotation.
	
	Example 1:
	
	Given input matrix = 
	[
	  [1,2,3],
	  [4,5,6],
	  [7,8,9]
	],
	
	rotate the input matrix in-place such that it becomes:
	[
	  [7,4,1],
	  [8,5,2],
	  [9,6,3]
	]
	Example 2:
	
	Given input matrix =
	[
	  [ 5, 1, 9,11],
	  [ 2, 4, 8,10],
	  [13, 3, 6, 7],
	  [15,14,12,16]
	], 
	
	rotate the input matrix in-place such that it becomes:
	[
	  [15,13, 2, 5],
	  [14, 3, 4, 1],
	  [12, 6, 8, 9],
	  [16, 7,10,11]
	]
 */

/*
 * basic idea:	swap elements line by line
 * 	tips:	number of round = n / 2
 * 	outer loop: from outer round to inner round
 * 	inner loop: on current round, swap elements clockwise, count = n - 2 - level
 * 
 * time = O(n ^ 2)
 * space = O(1)
 */
public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
        int n = matrix.length;	
        int round = n / 2; // number of outer round of matrix
         				 // n = 3, round = 1, n = 4, round = 2
		for (int level = 0; level < round; level++) { // determine on which current outer round
			int count = n - 2 - level; // number of elements except corner element which belongs to another line
			// swap valid elements in four lines
			for (int i = level; i <= count; i++) {
				int tmp = matrix[level][i];
				matrix[level][i] = matrix[n - 1 - i][level];
				matrix[n - 1 - i][level] = matrix[n - 1 - level][n - 1 - i];
				matrix[n - 1 - level][n - 1 - i] = matrix[i][n - 1 - level];
				matrix[i][n - 1 - level] = tmp; 
			}
		}
	}
}
