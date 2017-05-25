package class2BinarySearchAndRecursion;

/**
 * 
 * @author Yifeng
 * Given a target integer T and an integer array A sorted in ascending order, 
 * find the index i in A such that A[i] is closest to T.

	Assumptions
	
	There can be duplicate elements in the array, and we can return any of the indices with same value.
	Examples
	
	A = {1, 2, 3}, T = 2, return 1
	A = {1, 4, 6}, T = 3, return 1
	A = {1, 4, 6}, T = 5, return 1 or 2
	A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
 */
public class ClosestInSortedArray {
	public int closest(int[] array, int target) {
		// Write your solution here
		if (array == null || array.length == 0) {
			return -1;
		}
		//double-pointer method
		int start = 0;
		int end = array.length - 1;
		//even if the array only has one element, the post-processing will handle this situation
		while (end - start > 1) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				end = mid;
			} else if (array[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (array[end] == target) {
			return end;
		} else if (Math.abs(target - array[start]) < Math.abs(array[end] - target)) { // if array has no element == target,t
																					  // then find the closest one					
			return start;
		} else {
			return end;
		}
	}
}

