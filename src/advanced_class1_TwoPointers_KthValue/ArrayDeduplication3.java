package advanced_class1_TwoPointers_KthValue;

import java.util.Arrays;

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
	
	{1, 2, 2, 3, 3, 3} → {1}
 */

//0  1  2  3  4  5
//1  2  2  3  3  4
// s
//              be
//                 f
public class ArrayDeduplication3 {
	public int[] dedup(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int slow = 0;
		int fast = 0;
		while(fast < array.length) {
			int begin = fast;// begin records the first occurrence of new number in the input array
			while(fast < array.length && array[fast] == array[begin]) {
				fast++;//means the duplicated numbers
			}
			if(fast - begin == 1) { //represents the occurrence of current number is only 1
				array[slow++] = array[begin]; //then move the slow pointer
			}
		}
		return Arrays.copyOfRange(array,0,slow);
	}
}


