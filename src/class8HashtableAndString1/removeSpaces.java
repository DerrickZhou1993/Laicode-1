package class8HashtableAndString1;
/**
 * 
 * @author @Yifeng
 *  Given a string, remove all leading/trailing/duplicated empty spaces.

	Assumptions:
	
	The given string is not null.
	Examples:
	
	¡°  a¡± --> ¡°a¡±
	¡°   I     love MTV ¡± --> ¡°I love MTV¡±

 */
public class removeSpaces {
	public String removeSpacesMethod(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ' && (i == 0 || arr[i - 1] == ' ')) {
				continue;
			}
			arr[end] = arr[i];
			end++;
		}
		if (end > 0 && arr[end - 1] == ' ') {
			return new String(arr, 0, end - 1);
		} else {
			return new String(arr, 0, end);
		}
	}

}