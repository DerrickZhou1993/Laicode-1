package TAclass1_array;
/**
 * 
 * @author @Yifeng
	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	
	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	For example,
	Given input array nums = [1,1,2],
	
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
	It doesn't matter what you leave beyond the new length.
 */
/*
 * basic idea: fast and slow pointer move to the same direction
 * 		elements to the left of slow is result
 * 		elements between fast and slow are useless
 * 		elements to the right of fast are about to discover
 * time = O(n)
 * space = O(1)
 */
public class RemoveDuplicatesFromSortedArray1 {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int slow = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			if (nums[fast] != nums[slow]) {
				nums[++slow] = nums[fast];
			}
		}
		return slow + 1; // return length not index
	}
}

