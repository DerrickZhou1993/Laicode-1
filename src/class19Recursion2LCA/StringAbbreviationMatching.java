package class19Recursion2LCA;
/**
 * 
 * @author @Yifeng
 * Word ¡°book¡± can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, 
 * return if the string matches the abbreviation.

	Assumptions:
	
	The original string only contains alphabetic characters.
	Both input and pattern are not null.
	Examples:
	
	pattern ¡°s11d¡± matches input ¡°sophisticated¡± since ¡°11¡± matches eleven chars ¡°ophisticate¡±.
 */
public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		//base case
		if(input.length() == 0 && pattern.length() == 0) {
			return true;
		}
		if(input.length() == 0 || pattern.length() == 0) {
			return false;
		}
		//case 1: the first character of pattern is digit 
		if(isDigit(pattern.charAt(0))) {
			int index = 0;
			int offset = 0;
			// while loop is to count offset need moving in input
			while(index < pattern.length() && isDigit(pattern.charAt(index))) {
				offset = offset * 10 + (pattern.charAt(index) - '0');
				index++;
			}
			if(offset > input.length()) {
				return false;
			}
			return match(input.substring(offset), pattern.substring(index));
		} else { // case 2: the first character of pattern is character
			if(input.charAt(0) != pattern.charAt(0)) { // check if equal
				return false;
			} else {
				return match(input.substring(1), pattern.substring(1));
			}
		}
	}
	
	private boolean isDigit(char c) {
		if(c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "2p2";
		StringAbbreviationMatching s = new StringAbbreviationMatching();
		System.out.print(s.match(s1,s2));
	}
}
