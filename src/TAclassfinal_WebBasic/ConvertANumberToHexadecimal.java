package TAclassfinal_WebBasic;
/**
 * 
 * @author guoyifeng
 	Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, 
 	two’s complement method is used.

	Note:
	
	All letters in hexadecimal (a-f) must be in lowercase.
	The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
	The given number is guaranteed to fit within the range of a 32-bit signed integer.
	You must not use any method provided by the library which converts/formats the number to hex directly.
	Example 1:
	
	Input:
	26
	
	Output:
	"1a"
	Example 2:
	
	Input:
	-1
	
	Output:
	"ffffffff"

 */
/*
 * basic idea:
 * 	initialize table of hex char
 * 	each time take a look at the last four digits of
    binary version of the input, and maps that to a hex char,
    then shift the input to the right by 4 bits, do it again
    until input becomes 0.
 */
public class ConvertANumberToHexadecimal {
    char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b',
                            'c','d','e','f'};
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 15]); // num & 15 can know the current 4 bit ==> hex
            num >>>= 4; // right shift by 4 bit to check next 4 bit 
        }
        return sb.reverse().toString(); // result at first is stored reversely in sb
    }
}