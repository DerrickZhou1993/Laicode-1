package class9String2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author @Yifeng
 * Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

	Assumptions
	
	input, S and T are not null, S is not empty string
	Examples
	
	input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
	input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 
 */
public class StringReplace {
	public String replace(String input, String s, String t) {
		char[] array = input.toCharArray();
		if (s.length() >= t.length()) {
			return longToShort(array, s, t);
		}
		return shortToLong(array, s, t);
	}

	// slow: left side of it including itself is the return result
	// fast: current index
	// for this case, size s >= t, so the array does not have to resize, the
	// space is enough
	// traverse from left to right   easy to implement
	private String longToShort(char[] array, String s, String t) {
		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			// if fast > array.length - s.length(), the rest substring impossibly match the s
			// && find the substring which matches s
			if (fast <= array.length - s.length() && patternEquals(array, fast, s)) {
				copyString(array, slow, t);//replace with t
				// long to short case
				//applecatdog   apple xx ¡ú xxcatdog
				//xxplecatdog                catdog    
				//	   f    after first time replecament the slow and fast pointers should like this
				//  s
				//xxcatdog
				//  
				slow += t.length();
				fast += s.length();
			} else {
				array[slow++] = array[fast++];//if not match, increase normally
			}
		}
		return new String(array, 0, slow);
	}
	
	//short to long we need to expand size of result array
	private String shortToLong(char[] array, String s, String t) {
		List<Integer> matches = findAllMatches(array, s);//first find all matched pattern and record their last char's index for future use
		int newLength = array.length + (t.length() - s.length()) * matches.size();//computer extra space needed in new char[] array
		char[] result = new char[newLength];
		// short to long case
		//applecatdog    cat  ->   animal
		//applecatdog_ _ _
		//			f
		//		 s             when s is at cat's last char's index which is t's index, invoke replace process, this is why we store last index 
		//           d o g
		//appleanimaldog  after replacement the two pointers are like this
		//    f          
		//    s
		int fast = result.length - 1;//when short to long fast should be at new result's last index
		int slow = array.length - 1;//slow should at original array's last index
		int patternEndIndex = matches.size() - 1;
		while (slow >= 0) {
			if (patternEndIndex >= 0 && slow == matches.get(patternEndIndex)) {//if there exist pattern need to replace and slow 
																		      //reaches its last char index
				copyString(result, fast - t.length() + 1, t);//focus on the replacement starting index
				fast -= t.length();
				slow -= s.length();
				patternEndIndex--;//do not forget update the remaining number of to-be-replaced pattern s
			} else {
				result[fast--] = array[slow--];//if not meet the last char index of pattern, decrease normally
			}
		}
		return new String(result);
	}
	
	//to check from 'fromIndex', this current substring with length of s.length() matches with s or not
	private boolean patternEquals(char[] array, int fromIndex, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (array[fromIndex + i] != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * start from 'fromIndex' replace sub-string with string t
	 */
	private void copyString(char[] array, int fromIndex, String t) {
		for (int i = 0; i < t.length(); i++) {
			array[fromIndex + i] = t.charAt(i);
		}
	}

	private List<Integer> findAllMatches(char[] array, String s) {
		List<Integer> matches = new ArrayList<>();
		int i = 0;
		while (i <= array.length - s.length()) {//if i > array.length - s.length(), there can not exist complete s
			if (patternEquals(array, i, s)) {
				matches.add(i + s.length() - 1);// record end index of pattern for future convenience
				i += s.length();//skip i of s.length()
			} else {
				i++;
			}
		}
		return matches;
	}
}

/* script */
// long to short case
//applecatdog   apple xx ¡ú xxcatdog
//xxplecatdog                catdog    
//     f
//xxcatdog
//  s
// 
// short to long case
//applecatdog    cat  ->   animal
//applecatdog_ _ _
//	       f
//             s 
//apple       animal    d o g

