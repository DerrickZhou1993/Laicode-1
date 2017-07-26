package advanced_class4_recursion4_DFS_NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.

	Assumptions
	
	The given array is not null and has length of at least 2
	The order of the values in the pair does not matter
	Examples
	
	A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 */
public class TwoSumAllPair2 {
	public List<List<Integer>> allPairs(int[] array, int target) {
		if (array.length <= 1) {
			return null;
		}
		Arrays.sort(array);// must sorted
		List<List<Integer>> result = new ArrayList<>();
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (left > 0 && array[left] == array[left - 1]) { //de-duplicate
				left++;
				continue;
			}
			int tmp = array[left] + array[right];
			if (tmp == target) {
				result.add(Arrays.asList(array[left], array[right]));
				left++;
				right--;
			} else if (tmp < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}


