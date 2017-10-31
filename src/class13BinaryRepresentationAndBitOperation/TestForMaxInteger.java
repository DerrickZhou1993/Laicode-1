package class13BinaryRepresentationAndBitOperation;
/**
 * test for max integer in Java
 * @author guoyifeng
 *
 */
public class TestForMaxInteger {
	/*
	 * in Java, Integer.MAX_VALUE is a number which
	 * an integer could hold (4 bytes == 32 bits)
	 * and most significant bit in java is sign bit
	 * so only have 31 bit to represent integer
	 * so max integer in java == 0111 1111 1111 1111 1111 1111 1111 1111(binary)
	 * 0111 ... 1111 = 2^0 + 2^1 + 2^2 +..+2^30 = 2^31 - 1;
	 */
	public static void main(String[] args) {
		int maxInteger = (int)(Math.pow(2, 31) - 1);
		int max = Integer.MAX_VALUE;
		System.out.println(max == maxInteger); // true
		System.out.println(Integer.toBinaryString(maxInteger)); // 31bit 1
		int sum = 0;
		for (int i = 0; i < 31; i++) {
			sum += Math.pow(2, i);
		}
		System.out.println(sum == Integer.MAX_VALUE);
		System.out.println(sum == Math.pow(2, 31) - 1);
	}
}
