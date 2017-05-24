package class1Sort;

/**
 * 
 * @author Yifeng
 * Given an array of integers, move all the 0s to the right end of the array.

	The relative order of the elements in the original array does not need to be maintained.
	
	Assumptions:
	
	The given array is not null.
	Examples:
	
	{1} --> {1}
	{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0} or {1, 1, 3, 0, 0} or {3, 1, 1, 0, 0}

 */
public class MoveAllZerosToTheEnd {
	public int[] moveZero(int[] array) {
		// Write your solution here.
		if (array == null || array.length == 0) {
			return array;
		}

		int left = 0;
		int right = array.length - 1;
		int cur = 0;
		while (left <= right) {
			if (array[cur] == 0 && array[right] == 0) {
				right--;
			} else if (array[cur] == 0) {
				swap(array, cur, right);
				right--;
				left++;
				cur++;
			} else {
				left++;
				cur++;
			}
		}
		return array;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
