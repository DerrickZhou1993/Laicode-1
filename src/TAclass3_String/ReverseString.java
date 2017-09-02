package TAclass3_String;
/**
 * 
 * @author yifengguo

	Write a function that takes a string as input and returns the string reversed.
	
	Example:
	Given s = "hello", return "olleh".
 */
/*
 * time = O(n)
 * space = O(n)
 */
public class ReverseString {
	public String reverseString(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		return new String(arr);

	}

	private void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
