package class9String2;
/**
 * 
 * @author guoyifeng
 *	Reverse the words in a sentence.

	Assumptions
	
	Words are separated by single space
	
	There are no heading or tailing white spaces
	
	Examples
	
	“I love Google” → “Google love I”
	
	Corner Cases
	
	If the given string is null, we do not need to do anything.
 */

/*
 * basic idea: 
 * 			step 1: reverse the whole sentence -> elgooG evol I
 * 			step 2: reverse each word in the sentence -> Google love I
 */
public class ReverseWordsInASentenceI {
	public String reverseWords(String input) {
		if (input == null) {
			return input;
		}
		char[] arr = input.toCharArray();
		reverse(arr, 0, arr.length - 1);
		int start = 0;//initialize word start index out of the for loop
		for (int i = 0; i < arr.length; i++) {
			//to check if current index is a start index of a word
			if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')) {
				start = i;
			}
			//to check if current index is an end index of a word
			if (arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] == ' ')) {
				reverse(arr, start, i);//if so, reverse this word
			}
		}
		String result = new String(arr);
		return result;
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
