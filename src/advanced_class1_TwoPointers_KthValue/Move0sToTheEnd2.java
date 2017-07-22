package advanced_class1_TwoPointers_KthValue;
/**
 * 
 * @author guoyifeng
 * Given an array of integers, move all the 0s to the right end of the array.

	The relative order of the elements in the original array need to be maintained.
	
	Assumptions:
	
	The given array is not null.
	Examples:
	
	{1} --> {1}
	{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
 */
//0  1  2  3  4  5
//2  1  3  0  0  1
//       s 
//             f
public class Move0sToTheEnd2 {
	public int[] moveZero(int[] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		int slow = 0;//elements to the left of slow(excluding slow) are no-zeros
		int fast = 1;//current index
		while(fast < array.length) {
			if(array[slow] == 0 && array[fast] != 0) {
				swap(array,slow,fast);
				slow++;
				fast++;
			}
			else if(array[slow] == 0 && array[fast] == 0) {
			  fast++;
			} else {
			  fast++;
			  slow++;
			}
		}
		return array;
	}
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

