package class13BinaryRepresentationAndBitOperation;

/**
 * 
 * @author @Yifeng
 *  Determine the number of bits that are different 
 *  for two given integers.

	Examples
	
	5(¡°0101¡±) and 8(¡°1000¡±) has 3 different bits
 */
public class NumberOfDifferentBits {
	public int diffBits(int a, int b) {
		int c = a ^ b;//XOR, if different bit. the result on different bit is 1 
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((c & (1 << i)) != 0) {// check if current bit is 1 bit by bit
				count++;
			}
		}
		return count;
	}
}

