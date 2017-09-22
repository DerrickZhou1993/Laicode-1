package TAclass8_DP;

public class PalindromeMatrix {
	private boolean[][] isPalindrome(String s) {
        // res[i][j] represents if substring from jth to ith (inclusive)
        // is a palindrome or not
        boolean[][] res = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
        	for (int j = 0; j <= i; j++) {
				if (s.charAt(j) == s.charAt(i) && (j + 1 > i - 1 || res[j + 1][i - 1])) {
					res[j][i] = true;
				}
			}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aba";
		boolean[][] res = new PalindromeMatrix().isPalindrome(s);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
