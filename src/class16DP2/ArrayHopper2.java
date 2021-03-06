package class16DP2;

/**
 * 
 * @author guoyifeng
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array. 
 * A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). 
 * Determine the minimum number of jumps you need to reach the end of array. 
 * If you can not reach the end of the array, return -1.

	Assumptions
	
	The given array is not null and has length of at least 1.
	Examples
	
	{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
	
	{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
 */
public class ArrayHopper2 { 
	public int minJump(int[] array) {
		//M[i] records the minimum number of jumps needed to reach the array[n -1] 
		int[] M = new int[array.length];
		//base case:
		M[0] = 0;
		for(int i = 1; i < array.length; i++) {
			M[i] = -1;//initialize as unreachable
			for(int j = i -1; j >= 0; j--) {
				if(array[j] + j >= i && M[j] != -1) {//if j can be reached and from j to i is possible
					if(M[i] == -1 || M[i] > M[j] + 1) {// if i has not been reached before or M[i] > M[j] + 1
						M[i] = M[j] + 1;
					}
				}
			}
		}
		return M[array.length - 1];
	}
}


