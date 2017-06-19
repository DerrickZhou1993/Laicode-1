package class8HashtableAndString1;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author @Yifeng
 *  Given an integer array of size N - 1, containing all the numbers from 1 to N except one, 
 *  find the missing number.

	Assumptions
	
	The given array is not null, and N >= 1
	Examples
	
	A = {2, 1, 4}, the missing number is 3
	A = {1, 2, 3}, the missing number is 4
	A = {}, the missing number is 1
 */
public class MissingNumberI {
	public int missing(int[] array) {
		if (array == null || array.length == 0) {
			return 1;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : array) {
			map.put(i, 1);
		}
		for (int i = 1; i <= array.length + 1; i++) {
			if (!map.containsKey(i))
				return i;
		}
		return -1;
	}
}