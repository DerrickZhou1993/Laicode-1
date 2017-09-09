package TAclass5_Matrix;
/**
 * 
 * @author @Yifeng
 	Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	
	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?
 */

/*
 *  Demo:
 eg:
   	7 4 1
   	8 0 2   fr = false
   	3 6 3   fc = false
   	
   	to
   	
   	7 0 1
   	0 0 0
   	3 0 3 

    7 0 1
   	8 8 2
   	3 6 3
   	
   	to
   	
   	0 0 0   fr = true
   	8 0 2	fr = false
   	3 0 3
	
	basic idea:
			this problem we need to focus on first column and first row at the beginning
			if at very beginning there is 0 existing in the first row or first column, we shall
			use a boolean flag to record it so we could set all the other non-zero element on
			that column or row later on
			
			when for for loop traverse the given matrix, once we found current position is 0,
			we should  
						1. determine if i == 0 or j == 0, reason is above
						2. set its leftmost (m[i][0]) and topmost (m[0][j]) to 0 at once
						   this is useful to set other elements except ones in first row and first 
						   column to zero
						   
			when second time for for loop traverse matrix except first row and column
			check if current element's leftmost or topmost element is 0 or not
				if 0, set it to 0 directly
				
			finally, because we did not traverse all the elements in the first row and first column
			we just check that two boolean flags to determine if need to set them to 0 or not 
			
	Time = O(mn)
	Space = O(1)
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		// record if first row or first column has 0 at start
		boolean firstRow = false;
		boolean firstColumn = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						firstRow = true; // first row has 0 at beginning
					}
					if (j == 0) {
						firstColumn = true; // first column has 0 at beginning
					}
					// set current 0¡¯s leftmost and topmost 
					// element to 0
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				// set current element to 0 if 
				// its topmost or leftmost is zero
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		// if there is 0 in first row at start, then set all the
		// other elements in the first row to 0
		if (firstRow) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		// if there is 0 in first column at start, then set all the
		// other elements in the first columnto 0
		if (firstColumn) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
