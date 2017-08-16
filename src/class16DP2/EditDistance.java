package class16DP2;

/**
 * 
 * @author guoyifeng
 * Given two strings of alphanumeric characters, determine the minimum number of 
 * Replace, Delete, and Insert operations needed to transform one string into the other.

	Assumptions
	
	Both strings are not null
	Examples
	
	string one: "sigh", string two : "asith" 
	
	the edit distance between one and two is 2 (one insert "a" at front then replace "g" with "t").
 */
public class EditDistance {
	public int editDistance(String one, String two) {
		int m = one.length();//one's length
		int n = two.length();//two's length
		//M[i][j] represents the minimum number of actions to transform the first i letters of   s1 to the first j letters in s2
		int[][] M = new int[m+1][n+1]; //2d matrix, the left-most column and top-most row is to represent the empty string case
		if(m == 0) return n;//if one of the string is empty, the action number must be another one's length
		if(n == 0) return m;
		//base case:
		M[0][0] = 0;
		//fill each position of the 2-d matrix from top to bottom, from left to right 
		for(int i = 0; i < m + 1; i++) {
			for(int j = 0; j < n + 1; j++) {
				if(i == 0) { // empty case
					M[i][j] = j;
				} else if(j == 0) {// empty case
					M[i][j] = i;
				}

				//case 1: do nothing, inherit the result from current position's left-top position
				else if(one.charAt(i - 1) == two.charAt(j - 1)) {
					M[i][j] = M[i - 1][j - 1];
				} else {//case 2,3,4(Replace,Delete,Insert)
					M[i][j] = Math.min(Math.min(M[i-1][j], M[i][j-1]), M[i-1][j-1]) + 1;//  choose minimum value from three positions and + 1	
				}
			}	
		}
		return M[m][n];// the value of right-bottom of 2d matrix is the result to return
	}
}

