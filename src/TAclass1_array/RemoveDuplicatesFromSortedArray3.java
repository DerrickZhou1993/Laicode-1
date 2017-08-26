package TAclass1_array;
/**
 * 

 * @author guoyifeng
 * Given a sorted integer array, remove duplicate elements. 
 * For each group of elements with the same value do not keep any of them. 
 * Do this in-place, using the left side of the original array and and maintain 
 * the relative order of the elements of the array. Return the array after deduplication.

	Assumptions
	
	The given array is not null
	Examples
	
	{1, 2, 2, 3, 3, 3} -> {1}
 */

// 1    2    2    3    3    3
//                             f
//                be
//      s
/*
 * basic idea:
 * 	fast slow and begin three pointers move to the same direction
 *  the goal is simply remove all the elements if they have duplicates and
 *  only keep those which only occur once
 *  
 *  time = O(n)  only one pass of array
 *  space = O(1)
 *  
 */
public class RemoveDuplicatesFromSortedArray3 {
	public int removeDuplicates(int nums[]) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int fast = 0;
		int slow = 0;
		while (fast < nums.length) {
			int begin = fast; // begin records the first occurrence of new number in the input array
			while (fast < nums.length && nums[fast] == nums[begin]) {
				fast++;
			}
			if (fast - begin == 1) { // represents the occurrence of current number is only 1
				nums[slow++] = nums[begin]; // then move the slow pointer
			}
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 2, 3, 3, 3};
		System.out.print(new RemoveDuplicatesFromSortedArray3().removeDuplicates(a));
	}
}
