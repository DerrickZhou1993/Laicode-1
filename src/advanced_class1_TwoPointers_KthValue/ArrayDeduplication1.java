package advanced_class1_TwoPointers_KthValue;

import java.util.Arrays;

/**
 * 
 * @author guoyifeng
 * Given a sorted integer array, remove duplicate elements. 
 * For each group of elements with the same value keep only one of them. 
 * Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array. 
 * Return the array after deduplication.

	Assumptions
	
	The array is not null
	Examples
	
	{1, 2, 2, 3, 3, 3} -> {1, 2, 3}
 */
//0 1 2 3 4
//1 2 3 2 3
//    s
//        f 

public class ArrayDeduplication1 {
	/* idea1: slow is excluded from result
	 * slow: the elements on the left side of slow pointer(excluding slow) is the result to return
	 * fast: current index
 	 */
	public int[] dedup(int[] array) {
		if(array.length <= 1) {
			return array;
		}
		int slow = 1;
		for(int fast = 1; fast < array.length; fast++) {
			if(array[fast] == array[slow - 1]) {
				continue;
			}
			array[slow++] = array[fast];
		}
		return Arrays.copyOfRange(array,0,slow);
	}
}


