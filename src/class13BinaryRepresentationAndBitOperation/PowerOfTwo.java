package class13BinaryRepresentationAndBitOperation;

/**
 * 
 * @author @Yifeng
 * Determine if a given integer is power of 2.

	Examples
	
	16 is power of 2 (2 ^ 4)
	3 is not
	0 is not
	-1 is not
 
 */
/*
 *  basic idea: the binary representation of 2^x =  0000 0... 1 000
 *  only one of some bit is 1
 *  minus 1
 *  it becomes 000 0..0111
 *  and use &(bit AND) on them , if return 0 , it means only one 1 exits in the original number
 *  And it is 2^x
 */
public class PowerOfTwo {
	  public boolean isPowerOfTwo(int number) {
	    if(number <= 0) {
	      return false;
	    }
	    return (number & (number - 1)) == 0;
	  }
	}
