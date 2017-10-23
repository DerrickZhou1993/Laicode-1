package advanced_class6_AdvancedBinarySearch_ComboADT_VotingAlgo;
/*
 * Given two sorted arrays of integers in ascending order, find the median value.

	Assumptions
	
	The two given array are not null and at least one of them is not empty
	The two given array are guaranteed to be sorted
	Examples
	
	A = {1, 4, 6}, B = {2, 3}, median is 3
	A = {1, 4}, B = {2, 3}, median is 2.5
 */


/*
 * High level of basic idea: binary reduction for each iteration
 * 			for two sorted array in ascending order:
 * 					1 3 5 7 9
 * 				    2 4 6 8 10
 * 			if we have to find kth smallest element, we can compare k/2th element
 * 			of each array. If a_k/2 > b_k/2, we can guarantee all elements before b_k/2
 * 			are all smaller than kth smallest element in two arrays, so delete them and 
 * 			go next iteration to find the answer. For this we can find (k-k/2)th smallest
 *          element in next recursion (always cut k to k-k/2)
 * 
 * 				This can be proved by contradiction:
 * 					if a_k/2 > b_k/2 and kth element is within [bLeft, b_k/2], we know
 * 					there are at most k/2 elements in [aLeft,a_k/2] and less than k/2
 * 					elements from bLeft to "fake_answer", so this answer can impossibly be 
 * 					the kth element of two arrays
 */
public class MedianOfTwoSortedArrays {
	public double median(int[] a, int[] b) {
		int len = a.length + b.length;
		if (len % 2 != 0) { // odd case
			return findKthSmall(a, 0, b, 0, len / 2 + 1); //k mean kth element, index = len / 2
														  //so index has to be added by 1
		} else { //even case
			return (findKthSmall(a, 0, b, 0, len / 2) + findKthSmall(a, 0, b, 0, len / 2 + 1)) / 2.0;
		}
	}

	private int findKthSmall(int[] a, int aLeft, int[] b, int bLeft, int k) {
		// base case 1
		if (aLeft >= a.length) { // nothing left in a
			return b[bLeft + k - 1]; // return kth element in current b (k may not be the same as original k)
		}
		// base case 2
		if (bLeft >= b.length) { // nothing left in b
			return a[aLeft + k - 1];
		}
		// base case 3: k cannot be further divided to k/2
		if (k == 1) { // it meas we are finding 1th smallest number, so we need to choose smaller one
			return Math.min(a[aLeft], b[bLeft]);
		}
		
		// k/2th element in array a, used for comparing with k/2th element in b
		// what if a.length << b.length, we delete elements from
		// b first, which can be proved by contradiction as well
		int aHalfKth = aLeft + k / 2 - 1 < a.length ? a[aLeft + k / 2 - 1] : Integer.MAX_VALUE;
		// what if b.length << a.length, we delete elements from
		// a first, which can be proved by contradiction as well
		int bHalfKth = bLeft + k / 2 - 1 < b.length ? b[bLeft + k / 2 - 1] : Integer.MAX_VALUE;

		if (aHalfKth < bHalfKth) { // now we have to find (k - k/2)th element
			return findKthSmall(a, aLeft + k / 2, b, bLeft, k - k / 2);  //using k - k/2 could avoid odd or even difference
		} else {
			return findKthSmall(a, aLeft, b, bLeft + k / 2, k - k / 2);
		}
	}
}
