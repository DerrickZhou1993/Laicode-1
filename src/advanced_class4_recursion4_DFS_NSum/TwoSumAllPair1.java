package advanced_class4_recursion4_DFS_NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author @Yifeng
 * Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

	Assumptions
	
	The given array is not null and has length of at least 2.
	
	Examples
	
	A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
	
	A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
 */
public class TwoSumAllPair1 {
	public List<List<Integer>> allPairs(int[] array, int target) {
		if (array.length <= 1) {
			return null;
		}
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<>();
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			if (left > 0 && array[left] == array[left - 1]) {
				left++;
				continue;
			}
			int tmp = array[left] + array[right];
			if (tmp == target) {
				result.add(Arrays.asList(left, right));
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
	
	public static void main(String[] args) {
		TwoSumAllPair1 test = new TwoSumAllPair1();
		int[] array = new int[] {1,3,2,4};
		int target = 5;
		List<List<Integer>> result = new ArrayList<>();
		result = test.allPairs(array, target);
		System.out.print(result);
	}
}
