package advanced_class1_TwoPointers_KthValue;

import java.util.Arrays;

/**
 * 
 * @author guoyifeng
 * Given a sorted integer array, remove duplicate elements. 
 * For each group of elements with the same value keep at most two of them. 
 * Do this in-place, using the left side of the original array and maintain 
 * the relative order of the elements of the array. Return the array after deduplication.

	Assumptions
	
	The given array is not null
	Examples
	
	{1, 2, 2, 3, 3, 3} -> {1, 2, 2, 3, 3}
 */
//0 1 2 3 4 5
//1 2 2 3 3 3
//        s
//          f
public class ArrayDeduplication2 {
	public int[] dedup(int[] array) {
		if (array == null) {
			return array;
		}
		if (array.length <= 2) {//corner case
			return array;
		}
		int slow = 2; //for first two elements are always legal
		for (int fast = 2; fast < array.length; fast++) {
			if (array[fast] == array[slow - 2]) { //compare with array[slow - 2]
				continue;
			}
			array[slow++] = array[fast];
		}
		return Arrays.copyOfRange(array, 0, slow);
	}
}


