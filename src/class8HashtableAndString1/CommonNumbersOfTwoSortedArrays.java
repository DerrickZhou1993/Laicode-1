package class8HashtableAndString1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

	Assumptions
	
	In each of the two sorted arrays, there could be duplicate numbers.
	Both two arrays are not null.
	Examples
	
	A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]
 */
public class CommonNumbersOfTwoSortedArrays {
	/*
	 * method1: double pointers
	 */
	public List<Integer> common(List<Integer> A, List<Integer> B) {
		if (A.size() == 0 || B.size() == 0) {
			return new ArrayList<Integer>();
		}
		int p1 = 0;
		int p2 = 0;
		List<Integer> result = new ArrayList<>();
		while (p1 < A.size() && p2 < B.size()) {
			if (A.get(p1) == B.get(p2)) {
				result.add(A.get(p1));
				p1++;
				p2++;
			} else if (A.get(p1) > B.get(p2)) {
				p2++;
			} else {
				p1++;
			}

		}
		return result;
	}
}
