package class9String2;

/**
 * 
 * @author guoyifeng
 *	Reverse a given string.

	Assumptions
	
	The given string is not null.

 */
public class ReverseString {
	public String reverse(String input) {
		if (input == null) {
			return input;
		}
		char[] arr = input.toCharArray();
		reverse(arr, 0, input.length() - 1);
		return new String(arr);
	}

	private void reverse(char[] arr, int start, int end) {//recursive function
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
