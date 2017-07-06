package class17DP3;

/**
 * 
 * @author guoyifeng
 * Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, 
 * with the same arm lengths and the four arms joining at the central point.

	Return the arm length of the largest cross.

	Assumptions
	
	The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
	Examples
	
	{ {0, 0, 0, 0},
	
	  {1, 1, 1, 1},
	
	  {0, 1, 1, 1},
	
	  {1, 0, 1, 1} }
	
	the largest cross of 1s has arm length 2.
 */

/*
 * basic idea, for each element in the matrix, find longest consecutive 1s from
 * 			   four directions (top->down,down->top,left->right,right->left) to this 
 *             element. The minimum consecutive 1s of 4 directions can guarantee the 
 *             shape of cross
 */
public class LongestCrossOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int maxArm = 0;
		int currentArm = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//m1,m2,m3,m4 represents number of longest consecutive 1s from four direction limit to current element
				//so they must be reset at the beginning of every iteration
				int m1 = 0; // from right to left
				int m1cur = m1;
				int m2 = 0; // from left to right
				int m2cur = m2;
				int m3 = 0; // from top to bottom
				int m3cur = m3;
				int m4 = 0; // from bottom to top
				int m4cur = m4;
				
				//for each direction, find the longest consecutive 1s to current element
				// m1:from right to left
				for (int k = n - 1; k >= j; k--) {
					if (matrix[i][k] == 0) {
						if (k == n - 1 || matrix[i][k + 1] == 1) {
							m1cur = 0;
						}
					} else {
						m1cur++;
					}
					m1 = Math.max(m1cur, m1);
				} // end loop to find m1 longest consecutive 1s

				// m2:from left to right
				for (int k = 0; k <= j; k++) {
					if (matrix[i][k] == 0) {
						if (k == 0 || matrix[i][k - 1] == 1) {
							m2cur = 0;
						}
					} else {
						m2cur++;
					}
					m2 = Math.max(m2cur, m2);
				} // end loop to find m2 longest consecutive 1s

				// m3:from top to bottom
				for (int k = 0; k <= i; k++) {
					if (matrix[k][j] == 0) {
						if (k == 0 || matrix[k - 1][j] == 1) {
							m3cur = 0;
						}
					} else {
						m3cur++;
					}
					m3 = Math.max(m3cur, m3);
				} // end loop to find m3 longest consecutive 1s

				// m4:from bottom to top
				for (int k = m - 1; k >= i; k--) {
					if (matrix[k][j] == 0) {
						if (k == m - 1 || matrix[k + 1][j] == 1) {
							m4cur = 0;
						}
					} else {
						m4cur++;
					}
					m4 = Math.max(m4cur, m4);
				} // end loop to find m4 longest consecutive 1s

				currentArm = Math.max(Math.min(Math.min(Math.min(m1, m2), m3), m4), currentArm);// the max (minimum value) as max armLength must be maintained
				maxArm = Math.max(currentArm, maxArm);
			}
		}
		return maxArm;
	}
}


