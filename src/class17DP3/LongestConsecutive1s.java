package class17DP3;
/**
 * 
 * @author guoyifeng
 * Given an array containing only 0s and 1s, find the length of the longest subarray of consecutive 1s.

	Assumptions
	
	The given array is not null
	Examples
	
	{0, 1, 0, 1, 1, 1, 0}, the longest consecutive 1s is 3.


 */
public class LongestConsecutive1s {
	public int longest(int[] array) {
		if(array == null || array.length == 0) {
			return 0;
		}
		int globalMax = 0;//result to return
		int preSum = 0; // last iteration number of consecutive 1s
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 0) {
				if(i == 0 || array[i - 1] == 1) {
					preSum = 0;
				} 
			} else {
				preSum++;
			}
			globalMax = Math.max(preSum,globalMax);
		}
		return globalMax;
	}
}


