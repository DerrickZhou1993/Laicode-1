package class18DP3;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author guoyifeng
 * Given a matrix that contains integers, find the submatrix with the largest sum.

	Return the sum of the submatrix.
	
	Assumptions
	
	The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
	Examples
	
	{ {1, -2, -1, 4},
	
	  {1, -1,  1, 1},
	
	  {0, -1, -1, 1},
	
	  {0,  0,  1, 1} }
	
	the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
 */
/*
 * Time =  O(n^3)
 */
public class LargestSubMatrixSum {
	public int largest(int[][] matrix) {
		//assume the matrix row and column is not 0;
		int m = matrix.length;
		int n = matrix[0].length;
		
		//store prefix_sum vector of each column of matrix
		List<List<Integer>> prefixSumCollection = new ArrayList<>();
		//for each column of matrix, do the 1-D prefix_sum record
		for(int i = 0; i < n; i++) {
			List<Integer> prefixSum = prefixSum(matrix,i);
			prefixSumCollection.add(prefixSum);
		}
		
		int[] compressedPrefix = new int[n];
		int largest = 0;
		//two rows of submatrix
		for(int i = 0; i < m; i++) { //O(n^2)
			for(int j = m - 1; j >= i; j--) {
				//get prefix_sum between row1 and row2 in prefixSum 
				for(int k = 0; k < n; k++) { //do it on each column //O(1 * n) = O(n)
					int partialPrefixSum = getPrefixSum(prefixSumCollection.get(k),matrix, i ,j,k); //get prefix_sum between i and j
					compressedPrefix[k] = partialPrefixSum;
				}
				largest = Math.max(largest,maxSubarray(compressedPrefix));
			}
		}
		return largest;
	}
 
	private int getPrefixSum(List<Integer> prefixSum,int[][] matrix,int i, int j,int k) {
		int result = prefixSum.get(j) - prefixSum.get(i) + matrix[i][k];//matrix[i][k] was substracted twice
		return result;
	}
	
	private int maxSubarray(int[] array) {
		//base case
		int globalMax = array[0];
		int preSum = array[0];  // store previous sum
		for(int i = 1; i < array.length; i++) {
			if(array[i] + preSum > array[i]) { //preSum is positive contribution
				preSum = preSum + array[i];
			} else {
				preSum = array[i];
			}
			globalMax = Math.max(globalMax,preSum);
		}
		return globalMax;
	}
 
	/*
	 * record predix_sum on each index of current column of matrix
	 */
	private List<Integer> prefixSum(int[][] matrix, int columnIndex) {
		int m = matrix.length;
		int n = matrix[0].length;
		List<Integer> result = new ArrayList<>();
		int preSum = 0;
		for(int i = 0; i < m; i++) {
			if(i == 0) {
				preSum = matrix[0][columnIndex];
				result.add(preSum);
			} else {
				preSum += matrix[i][columnIndex];
				result.add(preSum);
			}
		}
		return result;
	}
}

 
