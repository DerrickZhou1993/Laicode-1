package advanced_class1_TwoPointers_KthValue;
/**
 * 
 * @author guoyifeng
 * Rotate an N * N matrix clockwise 90 degrees.

	Assumptions
	
	The matrix is not null and N >= 0
	Examples
	
	{ {1,  2,  3}
	
	  {8,  9,  4},
	
	  {7,  6,  5} }
	
	after rotation is
	
	{ {7,  8,  1}
	
	  {6,  9,  2},
	
	  {5,  4,  3} }


 */
//1 2 3         7 2 1       7 8 1
//8 9 4    ->   8 9 4   ->  6 9 2 
//7 6 5         5 6 3       5 4 3

//7 8 1       [0][0] -> [0][n - 1]      [0][n - 1] -> [n - 1][n - 1]
//6 9 2      
//5 4 3 

//1   2  3  4 
//12  13  14 5
//11  16  15  6
//10  9  8  7 

//basic idea: split into levels and each level split it into four partitions
public class RotateMatrix {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if(n <= 1) {
			return;
		}
		int round = n / 2;//number of rounds of matrix. n = 3, round = 1 , n = 4, round = 2;
		for(int level = 0; level < round; level++) {//do it on each outer round of the matrix
			int left = level;
			int right = n - 2 - level;//each outer round has 2 more length than its inner round
			for(int i = left; i <= right; i++) { //each inner loop rotate each row or column first n - 1 elements
				int temp = matrix[left][i]; 
				matrix[left][i] = matrix[n - 1 - i][left];
				matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];		
				matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
				matrix[i][n - 1 - left] = temp;
			}
		}
	}
}


