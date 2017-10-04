package TAclassfinal_WebBasic;
/**
 * 
 * @author guoyifeng
 	A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

	For 1-byte character, the first bit is a 0, followed by its unicode code.
	For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 
	bytes with most significant 2 bits being 10.
	This is how the UTF-8 encoding would work:

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
	Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
	
	Note:
	The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. 
	This means each integer represents only 1 byte of data.
	
	Example 1:
	
	data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
	
	Return true.
	It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
	Example 2:
	
	data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
	
	Return false.
	The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
	The next byte is a continuation byte which starts with 10 and that's correct.
	But the second continuation byte does not start with 10, so it is invalid.
 */
public class UTF8Validation {
	public boolean validUtf8(int[] data) {
		String[] binaryStrArr = new String[data.length];
		// transform integer in data[] to binary String stored in binaryStrArr
		for (int i = 0; i < data.length; i++) {
			binaryStrArr[i] = to8BitBinary(data[i]);
			System.out.println(binaryStrArr[i]);
		}
		int ones = countFirstNOnes(binaryStrArr[0]);
		int start = 0;
		// corner case: data length == 1
		if (data.length == 1 && ones != 0) {
			return false;
		}
		// check UTF-8 sequence block by block
		while (start < data.length) {
			int firstOnes = countFirstNOnes(binaryStrArr[start]);
			if (firstOnes > 4) {
				return false;
			}
			if (firstOnes == 0) {
				start += 1;
				continue;
			}
			if (firstOnes == 1) {
				return false;
			}
			if (data.length == 1 && firstOnes != 0) {
				return false;
			}
			for (int i = start + 1; i <= start + firstOnes - 1; i++) {
				if (!startWithOneZero(binaryStrArr[i])) {
					return false;
				}
			}
			start += firstOnes;
		}
		return true;
	}

	// count number of first n ones
	private int countFirstNOnes(String num) {
		int count = 0;
		while (count < num.length() && num.charAt(count) != '0') {
			count++;
		}
		return count;
	}
	// sub-sequence validation after head sequence in each block
	private boolean startWithOneZero(String s) {
		return (s.charAt(0) == '1' && s.charAt(1) == '0');
	}
	// for utf-8 sequence is always 8-bit binaty number
	private String to8BitBinary(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(num % 2);
			num /= 2;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		int[] data = new int[] { 115, 100, 102, 231, 154, 132, 13, 10 };
		System.out.println(new UTF8Validation().validUtf8(data));
	}
}
