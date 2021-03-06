package advanced_class6_AdvancedBinarySearch_ComboADT_VotingAlgo;
/**
 * 
 * @author @Yifeng
 * Given two sorted arrays of integers, find the Kth smallest number.

	Assumptions
	
	The two given arrays are not null and at least one of them is not empty
	
	K >= 1, K <= total lengths of the two sorted arrays
	
	Examples
	
	A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
	
	A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 */
public class KthSmallestInTwoSortedArrays {
	public int kth(int[] a, int[] b, int k) {
		return findKthSmallest(a, 0, b, 0, k);
	}

	private int findKthSmallest(int[] a, int aLeft, int[] b, int bLeft, int k) {
		// base case 1
		if (aLeft >= a.length) {
			return b[bLeft + k - 1];
		}
		// base case 2
		if (bLeft >= b.length) {
			return a[aLeft + k - 1];
		}
		// base case 3
		if (k == 1) {
			return Math.min(a[aLeft], b[bLeft]);
		}

		int aHalfKth = aLeft + k / 2 - 1 < a.length ? a[aLeft + k / 2 - 1] : Integer.MAX_VALUE;

		int bHalfKth = bLeft + k / 2 - 1 < b.length ? b[bLeft + k / 2 - 1] : Integer.MAX_VALUE;

		if (aHalfKth < bHalfKth) {
			return findKthSmallest(a, aLeft + k / 2, b, bLeft, k - k / 2);
		} else {
			return findKthSmallest(a, aLeft, b, bLeft + k / 2, k - k / 2);
		}
	}
}
