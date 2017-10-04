package advanced_class4_recursion4_DFS_NSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author @Yifeng
 * Determine if there exist two elements in a given array, the sum of which is the given target number.

	Assumptions
	
	The given array is not null and has length of at least 2
	​Examples
	
	A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)
	
	A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
	
	A = {2, 4, 1}, target = 4, return false
 */

/*
 * personal assumptions:
 * 	1.sorted/unsorted
 * 	2.duplicate
 * 	3.return any/all
 *  4.size:if distributed computing is needed or not
 *  5.non-existent
 * 	6.return type
 * 	7.optimize time or space? !!!
 * 			if optimize time  -> HashMap
 * 			if optimize space
 * 				step1 sort the array first
 * 					a. follow up: which sorting algorithm to choose
 * 						1) quick sort O(n) worst case for space
 * 						2) selection sort O(1) for space -> ok
 * 
 *				step2 use two pointer
 *						xxxxxxxxxXxxxxxxxxxxxxxYxxxxxxx
 *						         i->         <-j
 *	             case1: if(input[i] + input[j] < target) i++
 *               case2: if(input[i] + input[j] > target) j--
 *               case3: if(input[i] + input[j] == target) return i,j
 *        However the selection time complexity is O(n^2) which is equal to the brute force algo to this problem
 *        So this algo is not good
 *        
 *        follow up2: what if input size is too big to compute in one mathine?
 *        		truncate into three parts  xxxx xxxxx...xxxxx  xxxx, only compute sorted first and third smaller part
 *        		in this machine
 */
public class TwoSum {
	//if use a HashMap the array has not to be sorted
	// time = O(n)
	// space = O(n0
	public boolean existSum(int[] array, int target) {
		if(array.length <= 1) {
			return false;
		}
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < array.length; i++) {
			if(map.containsKey(target - array[i])) {
				return true;
			}
			map.put(array[i], i + 1);
		}
		return false;
	}
	
	/*
	 * sol 2: two pointers
	 * 	step1: sort the array
	 *  step2: find if exists two sum using  pointers
	 *  		1 2 3 4 5 6
	 *  	   left->        <-right 
	 */
	public boolean existSum2(int[] array, int target) {
		if(array.length <= 1) {
			return false;
		}
		// O(nlogn) time complexity
		// O(1) space
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while(left < right) {
			int tmp = array[left] + array[right];
			if(tmp == target) {
				return true;
			} else if(tmp < target) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

}
