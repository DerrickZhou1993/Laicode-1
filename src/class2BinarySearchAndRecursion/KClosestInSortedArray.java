package class2BinarySearchAndRecursion;

/**
 * 
 * @author Yifeng
 * Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order,
 *  find the K closest numbers to T in A.

	Assumptions
	
	A is not null
	K is guranteed to be >= 0 and K is guranteed to be <= A.length
	Return
	
	A size K integer array containing the K closest numbers(not indices) in A, 
	sorted in ascending order by the difference between the number and T. 
	
	Examples
	
	A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
	A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
	 
 
 */
public class KClosestInSortedArray {
	public int[] kClosest(int[] array, int target, int k) {
		// Write your solution here
		if (array == null || array.length == 0) {
			return array;
		}
		int[] res = new int[k];
		// ArrayList<Integer> l = new ArrayList<>();
		int start = 0;
		int end = array.length - 1;
		while (end - start > 1) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				end = mid;
			} else if (array[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		int i = 0;
		while (i < k) {
			if (start < 0 && end > array.length - 1) { //end loop condition
				break;
			}
			if (start < 0) {
				// l.add(array[end]);
				res[i] = array[end];
				i++;
				end++;
				continue;
			}
			if (end > array.length - 1) {
				// l.add(array[start]);
				res[i] = array[start];
				i++;
				start--;
				continue;
			}
			if ((target - array[start]) <= (array[end] - target)) {
				// l.add(array[start]);
				res[i] = array[start];
				i++;
				start--;
				continue;
			} else {
				// l.add(array[end]);
				res[i] = array[end];
				i++;
				end++;
				continue;
			}
		}
		return res;
	}
}

