package advanced_class4_recursion4_DFS_NSum;
/*
 * Q1.1 print all valid permutations of ()()()
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* Q1.2
 * Midterm2 if {
 * 				
 * 			}
 */

/**
 * 
 * @author @Yifeng
 * Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.

	Assumptions
	
	l, m, n >= 0
	Examples
	
	l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", "[]()"]
 */

/* Basic idea:
 * for this problem, we have three kinds of parenthesis.
 * to construct valid parenthesis combination of three kinds of parenthesis:
 * 		1. For the same type of parenthesis, left_add_so_far > right_add_so_far
 * 		2. For the same type of parenthesis, its left parenthesis must match right parenthesis,
 * 		   no matter how many other parenthesis in between
 *             eg: [ xxxxxxxx ]  guarantee linear scan to check if stack top matches new added parenthesis
 *             	     all valid parentheses between the [] can be counteracted via stack pop and offer
 *             			eg: [{()}    <-]   {()} can be popped out from stack
 *             
 *       recursion tree:
 *       	                          root(empty)
 *                            /         |    |    |   |    \
 *    level 0                 (          )    [    ]    {   }
 *                           stack|| (
 *                        /    |   |   |   |   \    
 *                       (     )   [   ]   {   }         only ( ) [ { can be added, others are invalid 
 *                       															(] is invalid 
 *                       
 *    level 1
 *    ...
 */                      

/*
 * Solution detail:
 * 	case1: whenever add one kind of left parenthesis, add this left parenthesis to the path_prefix(StringBuilder), 
 * 		   and push to the stack. Update the reminder
 *  case2: whenever add one kind of right parenthesis, first check whether it matches the top of stack
 *  			case2.1 if matches, stack.pop() and path_prefix.add(right_parenthesis). Update reminder
 *  			case2.2 if not matches, then prune this branch(do nothing,NOT calling recursion function) 
 *  Don't forget recovering added parenthesis on last layer of recursion tree! 
 */
public class AllValidPermutationsOfParenthesesII {
	// because we have three different kinds of parentheses,
	// so we need a char[] to record each kind of left and right parenthesis
	private static final char[] PS = new char[] { '(', ')', '[', ']', '{', '}' };

	public List<String> validParentheses(int l, int m, int n) {
		// assume l, m and n are greater than 0
		int[] remain = new int[] { l, l, m, m, n, n };
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int maxLength = 2 * l + 2 * m + 2 * n;// record max layers of recursion tree
												
		Deque<Character> stack = new LinkedList<>();

		helper(remain, sb, stack, maxLength, result);

		return result;
	}

	private void helper(int[] remain, StringBuilder sb, Deque<Character> stack, int maxLength, List<String> result) {
		if (sb.length() == maxLength) { // base case
			result.add(new String(sb.toString()));
			return;
		}
		for (int i = 0; i < remain.length; i++) {
			if (i % 2 == 0) { //meaning current parenthesis is a left one
				if (remain[i] > 0) { //current parenthesis has remaining
					sb.append(PS[i]);
					stack.offerFirst(PS[i]);
					remain[i]--;
					helper(remain,sb,stack,maxLength,result);
					sb.deleteCharAt(sb.length() - 1);//delete last element of sb to recover to last recursion tree
					stack.pollFirst();//delete top element of stack
					remain[i]++;
				}
			} else { //current parenthesis is a right one
				if(!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) { //only if stack is not empty and top element
																		 //match current right parenthesis(same type)
					sb.append(PS[i]);
					stack.pollFirst(); // current pair of parenthesis of same type can be counteracted
					remain[i]--;
					helper(remain,sb,stack,maxLength,result);
					stack.offerFirst(PS[i - 1]); //recovery to original condition
					remain[i]++;
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
	}
}
