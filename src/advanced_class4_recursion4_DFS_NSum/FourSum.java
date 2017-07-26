package advanced_class4_recursion4_DFS_NSum;

import java.util.Arrays;

/*
 * Sol1: for for for for O(N ^ 4)
 * 
 * Sol2: if not sorted, then sort it first
 * 		 for(i = 0; i < n; i++) {
 * 			for(int j = i + 1; j < n; j++) {
 *          	Run TwoSum in range [j + 1, n - 1]
 * 			}
 * 		 }
 * 	   Time = O(n ^ 2 * n) = O(n^3)
 */

/*
 * eg: 1 2 3 4
 *    1 + 4 = 5
 *    2 + 3 = 5
 *    how to know <5,<1,4>> and <5,<2,3>> are not the same to de-duplicate <5,<1,4>> appearing twice
 */
public class FourSum {
	public boolean exist(int[] array, int target) {
		if (array.length <= 3) {
			return false;
		}
		Arrays.sort(array);
		for (int i = 0; i < array.length - 3; i++) {
			int threeSum = target - array[i];
			for (int j = i + 1; j < array.length - 1; j++) {
				int twoSum = threeSum - array[j];
				int left = j + 1;
				int right = array.length - 1;
				while (left < right) {
					int tmp = array[left] + array[right];
					if (tmp == twoSum) {
						return true;
					} else if (tmp < twoSum) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return false;
	}
}
