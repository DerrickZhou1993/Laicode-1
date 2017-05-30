package class2BinarySearchAndRecursion;

public class ClassicalBinarySearch {
	public int binarySearch(int[] array, int target) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return -1;
		}
		if (target < 0) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
		/*
		 * double-pointer method
		 */
		// while(end > start + 1) {
		// int mid = start + (end - start) / 2;
		// if(array[mid] > target) {
		// end = mid;
		// }
		// else if(array[mid] < target) {
		// start = mid;
		// }
		// else return mid;
		// }
		// if(array[start] == target) {
		// return start;
		// }
		// if(array[end] == target) {
		// return end;
		// }
		
		/*
		 * classical method of binary search
		 */
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}

