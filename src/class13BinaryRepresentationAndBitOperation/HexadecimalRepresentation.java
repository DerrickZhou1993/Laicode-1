package class13BinaryRepresentationAndBitOperation;
/**
 * 
 * @author @Yifeng
 * Generate the hexadecimal representation for a given non-negative integer number as a string. 
 * The hex representation should start with "0x".

	There should not be extra zeros on the left side.
	
	Examples
	
	0's hex representation is "0x0"
	255's hex representation is "0xFF"
 */
public class HexadecimalRepresentation {
	public String hex(int number) {
		if (number < 0) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		int temp = number;
		if (number == 0) {//if number == 0, it cannot step in while loop
					      // so it must be handled as corner case
			result.append('0');
		}
		while (temp != 0) {//if temp divided by 16 != 0, append the module by 16 to result
			result.append(convert(temp % 16));
			temp /= 16;
		}
		result.append("x0");//the order is reverse
		return result.reverse().toString();//reverse the order of chars
	}
	//assume number >= 0 and number <=15
	//this method is to convert this number into character form
	private char convert(int number) {
		if (number < 10) {
			return (char) (number + '0');
		} else {
			return (char) ((number - 10) + 'A');
		}
	}
}