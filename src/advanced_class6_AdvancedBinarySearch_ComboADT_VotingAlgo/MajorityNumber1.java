package advanced_class6_AdvancedBinarySearch_ComboADT_VotingAlgo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author guoyifeng
 * Given an integer array of length L, find the number that occurs more than 0.5 * L times.

	Assumptions
	
	The given array is not null or empty
	It is guaranteed there exists such a majority number
	Examples
	
	A = {1, 2, 1, 2, 1}, return 1
 */
public class MajorityNumber1 {
	/*
	 * solution 1 HashMap and Counter
	 *  time = O(n)
	 *  Space = O(n)
	 */
	public int majority(int[] array) {
		int max = 0;
		int major = 0;
		// key = candidate, value = counter
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(array[i])) {
				map.put(array[i], 1);
			} else {
				map.put(array[i], map.get(array[i]) + 1);
			}
		}
		for (int i = 0; i < array.length; i++) {
			int temp = map.get(array[i]);
			if (temp >= max) {
				max = temp;
				major = array[i];
			}
		}
		return major;
	}
	
	/*
	 * solution2 voting algorithm
	 */
}


