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
public class RemoveDuplicatesFromSortedArray3 {
	public int removeDuplicates(int nums[]) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int fast = 0;
		int slow = 0;
		while (fast < nums.length) {
			int begin = fast;
			while (fast < nums.length && nums[fast] == nums[begin]) {
				fast++;
			}
			if (fast - begin == 1) {
				nums[slow++] = nums[begin];
			}
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 2, 3, 3, 3};
		System.out.print(new RemoveDuplicatesFromSortedArray3().removeDuplicates(a));
	}
}
