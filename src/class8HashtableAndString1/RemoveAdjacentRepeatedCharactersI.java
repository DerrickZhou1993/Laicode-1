package class8HashtableAndString1;
/**
 * 
 * @author @Yifeng
 * Remove adjacent, repeated characters in a given string, 
 * leaving only one character for each group of such characters.

	Assumptions
	
	Try to do it in place.
	Examples
	
	¡°aaaabbbc¡± is transferred to ¡°abc¡±
	Corner Cases
	
	If the given string is null, we do not need to do anything.

 */
public class RemoveAdjacentRepeatedCharactersI {
	public String deDup(String input) {
		if (input == null) {
			return input;
		}
		char[] arr = input.toCharArray();
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i] != arr[end - 1]) {
				arr[end] = arr[i];
				end++;
			}
		}
		return new String(arr, 0, end);
	}
}
