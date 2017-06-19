package class9String2;

/**
 * 
 * @author guoyifeng
 * Right shift a given string by n characters.

	Assumptions
	
	The given string is not null.
	n >= 0.

 */
/* e.g.: abcdef -> efabcd
 * basic idea : 
 * 		step
 */
public class RightShiftByNCharacters {
	public String rightShift(String input, int n) {
		if (input == null || n == 0) {
			return input;
		}
		if (input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
		n = n % arr.length; // n can be very large so it needs to be checks or it may
							// cause ArrayOutOfBoundsException
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, n - 1);
		reverse(arr, n, arr.length - 1);
		return new String(arr);
	}

	private void reverse(char[] arr, int start, int end) {
		if (end <= start)
			return;
		swap(arr, start, end);
		reverse(arr, start + 1, end - 1);
	}

	private void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
