package class1Sort;

/**
 * 
 * @author Yifeng
 * Given an array of integers, sort the elements in the array in ascending order. 
 * The quick sort algorithm should be used to solve this problem.

	Examples
	
	{1} is sorted to {1}
	{1, 2, 3} is sorted to {1, 2, 3}
	{3, 2, 1} is sorted to {1, 2, 3}
	{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
	Corner Cases
	
	What if the given array is null? In this case, we do not need to do anything.
	What if the given array is of length zero? In this case, we do not need to do anything.
 */

public class QuickSort {
	public int[] quickSort(int[] array) {
		// Write your solution here

		helper(array, 0, array.length - 1);
		return array;
	}

	public void helper(int[] array, int lo, int hi) {
		if (array == null || array.length == 0) {
			return;
		}

		if (lo > hi) {
			return;
		}
		int pivot = getPivot(array, lo, hi);

		helper(array, lo, pivot - 1);
		helper(array, pivot + 1, hi);

	}

	public int getPivot(int[] array, int lo, int hi) {
		int pivot = array[lo];
		while (lo < hi) {
			while (hi > lo && pivot <= array[hi]) {
				hi--;
			}
			array[lo] = array[hi];
			while (hi > lo && pivot >= array[lo]) {
				lo++;
			}
			array[hi] = array[lo];
		}
		array[lo] = pivot;
		return lo;
	}

}
