package class8HashtableAndString1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author guoyifeng
 *  Repeatedly remove all adjacent, repeated characters 
 *  in a given string from left to right.

	No adjacent characters should be identified in the final string.
	
	Examples
	
	"abbbaaccz" → "aaaccz" → "ccz" → "z"
	"aabccdc" → "bccdc" → "bdc"
 */
public class RemoveAdjacentRepeatedCharactersIV {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		Deque<Character> stack = new LinkedList<>();
		char[] array = input.toCharArray();
		int slow = 0;
		stack.offerFirst(array[slow]);
		for (int fast = 1; fast < array.length; fast++) {
			if (stack.isEmpty() || array[fast] != stack.peek()) {//if stack is empty or no duplicate in stack
																 //push arr[fast] into stack 
				stack.offerFirst(array[fast]);
				array[++slow] = array[fast];    //slow physical meaning: stack top
												//so its left side characters and itself will be returned as result
			} else {
				stack.pollFirst();//if meet duplicate character, pop stack 
				slow--;//slow is the top pointer of stack
				while (fast + 1 < array.length && array[fast] == array[fast + 1]) { // skip duplicate characters
					fast++;
				}
			}
		}
		return new String(array, 0, slow + 1);
	}
}

