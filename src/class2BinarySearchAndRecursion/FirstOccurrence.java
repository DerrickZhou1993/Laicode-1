package class2BinarySearchAndRecursion;

/**
 * 
 * @author yifeng
 * Given a target integer T and an integer array A sorted in ascending order, 
 * find the index of the first occurrence of T in A or return -1 if there is no such index.

	Assumptions
	
	There can be duplicate elements in the array.
	Examples
	
	A = {1, 2, 3}, T = 2, return 1
	A = {1, 2, 3}, T = 4, return -1
	A = {1, 2, 2, 2, 3}, T = 2, return 1
 */

/*
 * To find the first or last occurrence, better use double-pointer method
 * which is to make sure the real target(first or last occurrence) will not 
 * be ruled out by the algorithm
 * 
 *  So for the first occurrence, whenever array[mid] == target, we must let end = mid;
 *  if let start = mid, it is possible to rule out the first occurrence which is located 
 *  before the original mid
 *
 */
public class FirstOccurrence {
	public int firstOccur(int[] array, int target) {
		// Write your solution here
		if (array == null || array.length == 0) {
			return -1;
		}
		if (target < 0) {
			return -1;
		}

		int start = 0;
		int end = array.length - 1;

		while (end - start > 1) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				end = mid;
			} else if (array[mid] < target) {
				start = mid;
			} else
				end = mid;
		}
		if (array[start] == target) {
			return start;
		} else if (array[end] == target) {
			return end;
		} else
			return -1;
	}
}

