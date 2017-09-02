package TAclass3_String;
/**
 * 
 * @author yifengguo
  Given an input string, reverse the string word by word.

	For example,
	Given s = "the sky is blue",
	return "blue is sky the".

 */
/*
 * time = O(n ^ 2)
 * space = O(n)
 */
public class ReverseWordsInString {
	public String reverseWords(String s) {
		if (s == null) {
			return s;
		}
		char[] arr = s.toCharArray();

		// step1: reverse whole sentence
		reverse(arr, 0, arr.length - 1);
		
		// step2: reverse each word in the sentence
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			// find the start of a word
			if (arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')) {
				start = i;
			}
            // find the end of a word and reverse character of this word
			if (arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] ==  ' ')) {
				reverse(arr, start, i);
	 		}
		}
		return new String(arr).trim();
	}
	
	private void reverse(char[] arr, int start, int end) {
        while (end > start) {
            swap(arr, start++, end--);
        }
	}

	private void swap(char[] arr, int a, int b) {
		char temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
