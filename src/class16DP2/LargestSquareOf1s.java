package class16DP2;

/**
 * 
 * @author @Yifeng
 * Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

	Assumptions
	
	The given matrix is not null and guaranteed to be of size N * N, N >= 0
	Examples
	
	{ {0, 0, 0, 0},
	
	  {1, 1, 1, 1},
	
	  {0, 1, 1, 1},
	
	  {1, 0, 1, 1}}
	
	the largest square of 1s has length of 2
 */
public class LargestSquareOf1s {
	public int largest(int[][] matrix) {
		int n = matrix.length;
		if(n == 0) {
			return 0;
		}
		int result = 0;
		int[][] M = new int[n][n]; //M[i][j] represents the largest length of square having matrix[i][j] as right-bottom element
		//base case
		for(int i = 0; i < n; i++) { //traverse each element in the matrix, time O(n^2)
			for(int j = 0; j < n; j++) {
			  if(i == 0 || j == 0) { //set the value of the fist row and column
			    M[i][j] = matrix[i][j] == 1 ? 1 : 0;
			  } else if(matrix[i][j] == 1){ // if matrix[i][j] == 0, do nothing, meaning 0 as M[i][j]
  				M[i][j] = matrix[i][j] + Math.min(Math.min(M[i - 1][j - 1], M[i - 1][j]), M[i][j - 1]);
			  }
			  result = Math.max(result,M[i][j]);
			}
		}
		return result;
	}
}

