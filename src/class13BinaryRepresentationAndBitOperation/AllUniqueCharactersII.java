package class13BinaryRepresentationAndBitOperation;

/**
 * 
 * @author @Yifeng
 * Determine if the characters of a given string are all unique.

	Assumptions
	
	We are using ASCII charset, the value of valid characters are from 0 to 255
	The given string is not null
	Examples
	
	all the characters in "abA+\8" are unique
	"abA+\a88" contains duplicate characters
 */

/*
 * basic idea: construct a bit map like:
 * 		0000 .... 0000
 * 		0000 .... 0000
 * 		0000 .... 0000
 *		0000 .... 0000
 * 		0000 .... 0000
 *		0000 .... 0000
 * 		0000 .... 0000
 * 		0000 .... 0000
 * 
 * and one of the bit represents a character in the ascii. 
 * 
 */
public class AllUniqueCharactersII {
	public boolean allUnique(String word) {
		char[] array = word.toCharArray();
		int[] vector = new int[8];// 1 int = 4 byte = 32 bit, so 8 int can represent ASCII map
		for (char c : array) {
			int bitIndex = c;// convert int to ascii
			int row = bitIndex / 32;
			int col = bitIndex % 32;
			if ((vector[row] & (1 << col)) != 0) { // current already exists in the map
				return false;
			} else { // if this is first time found character, update value in
						// bit vector
				vector[row] = ((1 << col) | vector[row]);// set current c¡¯s
															// index in bit
															// vector to 1
			}
		}
		return true;
	}
}