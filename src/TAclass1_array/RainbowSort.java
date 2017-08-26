package TAclass1_array;
/**
 * 
 * @author @Yifeng
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 with the colors in the order red, white and blue.

	Here, we will use the integers -1, 0, and 1 to represent the color red, white, and blue respectively.
 */
// -1    -1    0    1    1 
//             lo                    
//             hi
//                 cur
/*
 * time = O(n)
 * space = O(1)
 */
public class RainbowSort {
	public int[] rainbowSort(int[] nums) {
		if (nums == null || nums.length ==0) {
			return nums;
		}
		int cur = 0;
		int lo = 0;
		int hi = nums.length - 1;
		while (cur <= hi) {    // pay attention of loop halt condition
			if (nums[cur] == -1) {
				swap(nums, lo++, cur++);  // cur is increased from 0 so what is left to cur
										  // must be valid result
			} else if (nums[cur] == 0) {
				cur++;
			}else if(nums[cur] == 1) {
				swap(nums, cur, hi--); // pay attention when swap cur and hi
				                       // do not increase cur for we don't know
				                       // what is swapped from hi position
									   // need to check next iteration
			}
		}
		return nums;
	}
	
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,-1};
		RainbowSort test = new RainbowSort();
		int[] result = test.rainbowSort(nums);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}
