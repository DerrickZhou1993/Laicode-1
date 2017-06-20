package class9String2;
/**
 * 
 * @author @Yifeng
 * Given a string in compressed form, decompress it to the original string. 
 * The adjacent repeated characters in the original string are compressed to have the character followed by
 * the number of repeated occurrences.

	Assumptions
	
	The string is not null
	
	The characters used in the original string are guaranteed to be ¡®a¡¯ - ¡®z¡¯
	
	There are no adjacent repeated characters with length > 9
	
	Examples
	
	¡°a1c0b2c4¡± ¡ú ¡°abbcccc¡±

 */


public class DecompressStringII {
	/*
	 * method1: in-place
	 * 	basic idea: in-place, so we need a big enough char array to change the element
	 * 		for "a0", "a1" "a2", these cases the decoded string will become shorter
	 * 		for "a3" - "a9", these cases the decoded string will become longer
	 */
	public String decompress(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();

		return decodeLong(arr, decodeShort(arr));
	}

	// x0,x1,x2
	//traverse from left to right
	private int decodeShort(char[] arr) {
		int end = 0;//meaning: after decoding the shorter case, the length of char array
		for (int i = 0; i < arr.length; i += 2) {//at beginning, even index is character, odd index is number
			int digit = getDigit(arr[i + 1]);
			if (digit >= 0 && digit <= 2) {//if shorter case
				for (int j = 0; j < digit; j++) {//hold the i(char do not change) and move end index
					arr[end++] = arr[i];
				}
			} else {//for those will become longer case, we just skip them at this time
				arr[end++] = arr[i];
				arr[end++] = arr[i + 1];
			}
		}
		return end;//because to decode longer case, we need to resize the array, 
				   //so we need the length of shorter decoding case array length
	}
	
	//eg: abbc4  now we must traverse from right to left!!!
	//like abbc4_ _, the _ is empty index after expansion of size
	private String decodeLong(char[] arr, int length) {
		int newLength = length;
		//first of all, c4 > cccc so expand char[] size first
		for (int i = 0; i < length; i++) {
			int digit = getDigit(arr[i]);
			if (digit > 2 && digit <= 9) {
				newLength += digit - 2;//expansion
			}
		}
		char[] result = new char[newLength];//now the array is abbc4 _ _
		int end = newLength - 1;
		for (int i = length - 1; i >= 0; i--) {//i should start at 4's position
			int digit = getDigit(arr[i]);
			if (digit > 2 && digit <= 9) {
				i--;//now i is at c's position which is the last character's index in original array
				for (int j = 0; j < digit; j++) {
					result[end--] = arr[i];//fill the array with newLength
				}
			} else {//shorter case we have already handled ,just skip them normally
				result[end--] = arr[i];
			}
		}
		return new String(result);
	}
	
	//good method to convert number in character form to int number
	private int getDigit(char c) {
		return c - '0';
	}

}
