package class3QueueStackAndLinkedList;

import java.util.Stack;

/**
 * 
 * @author guoyifeng
 *  Data Structure
	Stack With min()
	Enhance the stack implementation to support min() operation. 
	min() should return the current minimum value in the stack. 
	If the stack is empty, min() should return -1.
	
	
	pop() - remove and return the top element, if the stack is empty, return -1
	push(int element) - push the element to top
	top() - return the top element without remove it, if the stack is empty, return -1
	min() - return the current min value in the stack.
 */
/*
 *    stack cur:       || 2 4 1 1 5
 *    stack global_min || 2 2 1 1 1
 */
public class StackWithMinMethod {
	Stack<Integer> cur = null;
	Stack<Integer> min = null;
	int global_min = 0;
	public StackWithMinMethod() {
		// write your solution here
		cur = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public int pop() {
		if(cur.isEmpty()) return -1;
		min.pop();
		return cur.pop();
	}

	public void push(int element) {
		if(cur.isEmpty()) {
			cur.push(element);
			min.push(element);
			global_min = element;
		} else {
			cur.push(element);
			if(element <= global_min) { // new added element is less than global min
				min.push(element);
				global_min = element;//change current global_min
			} else {
			  min.push(global_min);
			}
		}
	}

	public int top() {
		if(cur.isEmpty()) return -1;
		return cur.peek();
	}

	public int min() {
		if(min.isEmpty()) return -1;
		return min.peek();
	}
}
