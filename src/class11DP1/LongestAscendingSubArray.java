package class11DP1;

public class LongestAscendingSubArray {
//	public int longest(int[] array) {
//		if (array.length == 0) {
//			return 0;
//		}
//		int globalMax = 1;
//		int[] M = new int[array.length];//space = O(n); aux array
//		M[0] = 1;// base case
//		for (int i = 1; i < array.length; i++) {
//			if (array[i] > array[i - 1]) {
//				M[i] = M[i - 1] + 1;//look back linear times
//				globalMax = Math.max(globalMax, M[i]);//record global max
//			} else {
//				M[i] = 1;
//			}
//		}
//		return globalMax;
//	}
	
	//better solution with space complexity = O(1)
	public int longest(int[] array) {
		if(array.length == 0) {
			return 0;
		}
		int cur = 1;
		int globalMax = 1;
		for(int i = 1; i < array.length; i++) {
			if(array[i] > array[i - 1]) {
				cur++;
				globalMax = Math.max(cur, globalMax);
			} else {
				cur = 1;
			}
		}
		return globalMax;
	}
	
}
