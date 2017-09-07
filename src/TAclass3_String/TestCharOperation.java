package TAclass3_String;

public class TestCharOperation {
	public static void main(String[] args) {
		char a = 'a';
		char k = 'k';
		
		// ascii 
		// char : #
		// a : 97
		// A : 65
	   // '0' : 48
		System.out.println(k - a);
		System.out.println(a < k);
		System.out.println((int)a); // get ascii number of char
		char a1 = '1';
		System.out.println(a1 - '0'); // char to int
	}
}
