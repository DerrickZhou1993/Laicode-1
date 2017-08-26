package TAclass1_array;
/**
 * 
 * @author @Yifeng
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.
 */

/*
 * basic idea: binary search
 *  key point: check the numeric relationship between nums[mid], nums[start] and nums[end]
 *  time = O(logn)
 *  space = O(1) 
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return nums[start] < nums[end] ? nums[start] : nums[end];
	}
}
