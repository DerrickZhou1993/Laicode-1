package class11DP1;
/**
 * 
 * @author @Yifeng
	Given an unsorted array, find the length of the longest 
	subarray in which the numbers are in ascending order.
	
	Assumptions
	
	The given array is not null
	Examples
	
	{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.
	
	{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
 */
public class LongestAscendingSubArray {
//	public int longest(int[] array) {
//		if (array.length == 0) {
//			return 0;
//		}
//		int globalMax = 1;
//		int[] M = new int[array.length];//space = O(n); aux array
//		M[0] = 1;// base case
//		for (int i = 1; i < array.length; i++) {
//			if (array[i] > array[i - 1]) {
//				M[i] = M[i - 1] + 1;//look back linear times
//				globalMax = Math.max(globalMax, M[i]);//record global max
//			} else {
//				M[i] = 1;
//			}
//		}
//		return globalMax;
//	}
	
	//better solution with space complexity = O(1)
	public int longest(int[] array) {
		if(array.length == 0) {
			return 0;
		}
		int cur = 1;
		int globalMax = 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] > array[i - 1]) {
				cur++;
				globalMax = Math.max(cur, globalMax);
			} else {
				cur = 1;
			}
		}
		return globalMax;
	}
	
}
