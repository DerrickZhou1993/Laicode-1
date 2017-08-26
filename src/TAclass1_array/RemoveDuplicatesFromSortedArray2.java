package TAclass1_array;
/**
 * 
 * @author @Yifeng
 	Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array nums = [1,1,1,2,2,3],
	
	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
	It doesn't matter what you leave beyond the new length.
 */

/*
 * basic idea: fast and slow pointer move to the same direction
 * 		elements to the left of slow is result
 * 		elements between fast and slow are useless
 * 		elements to the right of fast are about to discover
 * 	
 * 	what is different from remove duplicate from sorted array1 is now we 
 *  need to compare arr[fast] with arr[slow - 2] for we are allowed to keep
 *  an element twice at most
 * 
 * time = O(n)
 * space = O(1)
 */

/*
 * 1    1    2    2    3    3
 *                          f
 *                          s
 */
public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length <= 2) { // corner case
								// <=2 are always valid
			return nums.length;
		}
		int slow = 2;
		for (int fast = 2; fast < nums.length; fast++) {
			if (nums[fast] != nums[slow - 2]) {
				nums[slow++] = nums[fast];
			}
		}
		return slow;
	}
}
