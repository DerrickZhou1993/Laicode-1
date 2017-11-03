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
	/*
	 * a better solution for using random index for pivot which will avoid sorted array condition
	 */
	public int[] quickSort(int[] array) {
		if (array == null || array.length == 0)
			return array; // corner case;
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private void quickSort(int[] array, int lo, int hi) {
		if (lo >= hi)
			return;
		int pivot = getPivot(array, lo, hi);
		quickSort(array, lo, pivot - 1);// divide and conquer
		quickSort(array, pivot + 1, hi);
	}

	private int getPivotIndex(int lo, int hi) {
		double rand = Math.random();
		return lo + (int) rand * (hi - lo + 1);
	}

	private int getPivot(int[] array, int lo, int hi) {
		int pivotIndex = getPivotIndex(lo, hi);
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, hi);// move pivot to the last position of array
		int left = lo; // two pointers for partition
		int right = hi - 1;
		while (left <= right) { // when pointers cross, stop loop
			if (array[left] <= pivot) {
				left++;// move left pointer forward
			} else if (array[right] >= pivot) {
				right--;
			} else {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		swap(array, left, hi);
		return left;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	
//	public int[] quickSort(int[] array) {
//		// Write your solution here
//
//		helper(array, 0, array.length - 1);
//		return array;
//	}
//
//	public void helper(int[] array, int lo, int hi) {
//		if (array == null || array.length == 0) {
//			return;
//		}
//
//		if (lo > hi) {
//			return;
//		}
//		int pivot = getPivot(array, lo, hi);
//
//		helper(array, lo, pivot - 1);
//		helper(array, pivot + 1, hi);
//
//	}
//
//	public int getPivot(int[] array, int lo, int hi) {
//		int pivot = array[lo];
//		while (lo < hi) {
//			while (hi > lo && pivot <= array[hi]) {
//				hi--;
//			}
//			array[lo] = array[hi];
//			while (hi > lo && pivot >= array[lo]) {
//				lo++;
//			}
//			array[hi] = array[lo];
//		}
//		array[lo] = pivot;
//		return lo;
//	}

}
