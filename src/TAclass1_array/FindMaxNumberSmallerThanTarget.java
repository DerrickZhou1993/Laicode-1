package TAclass1_array;

public class FindMaxNumberSmallerThanTarget {
	public int find(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}
		int lo = 0;
		int hi = nums.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > target) {
				hi = mid;
			} else if(nums[mid] < target){
				lo = mid;
			} else {
				return nums[mid - 1];
			}
		}
		if (nums[hi] < target) {
			return nums[hi];
		}
		if (nums[lo] < target) {
			return nums[lo];
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5,6,7,8};
		//int target = 10;
		int target = 7;
		FindMaxNumberSmallerThanTarget test = new FindMaxNumberSmallerThanTarget();
		System.out.print(test.find(nums, target));
	}
}
