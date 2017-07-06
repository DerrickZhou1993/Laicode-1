package class17DP3;

/**
 * 
 * @author guoyifeng
 * Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

	Assumptions
	
	The given array is not null and has length of at least 1.
	Examples
	
	{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5
	
	{-2, -1, -3}, the largest subarray sum is -1

 */
public class LongestSubArraySum {

//	public int largestSum(int[] array) {
//		// base case
//		int globalMax = array[0];
//		int preSum = array[0];// instead of using an array to store partial solution,
//							  // use previous sum to store last position max sum, space O(1)
//		for (int i = 1; i < array.length; i++) {
//			if (preSum + array[i] > array[i]) { // if previous sum is positive contribution
//				preSum = array[i] + preSum;
//			} else {
//				preSum = array[i]; //if not, update preSum as current array[i]
//			}
//			globalMax = Math.max(preSum, globalMax); // update global max value
//		}
//		return globalMax;
//	}
	
	
	/*
	 * follow ups:
	 * 		print the subarray start and end index:
	 * 
	 */
	
	public int largestSum(int[] array) {
		// base case
		int globalMax = array[0];
		int preSum = array[0];// instead of using an array to store partial solution,
							  // use previous sum to store last position max sum, space O(1)
		
		int start = 0;
		int end = 0;
		
		for (int i = 1; i < array.length; i++) {
			if (preSum + array[i] > array[i]) { // if previous sum is positive contribution
				preSum = array[i] + preSum;
			} else {
				preSum = array[i]; //if not, update preSum as current array[i]
				start = i;// now find a new start
			}
			
			if(globalMax < preSum) { //if globalMax need to be updated, then we find a new end
				globalMax = preSum;
				end = i;
			}
			globalMax = Math.max(preSum, globalMax); // update global max value
		}
		System.out.println("The largest subarray sum is: " + globalMax);
		System.out.println("The range of max sum of subarray is : " + start + " to " + end );
		return globalMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubArraySum test = new LongestSubArraySum();
		//int[] a = {2, -1, 4, -2, 1};
		int[] a = {-2,-1,-3};
		int result = test.largestSum(a);
		
	}

}
