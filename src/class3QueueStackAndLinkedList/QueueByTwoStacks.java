package class3QueueStackAndLinkedList;

import java.util.Stack;

/**
 * 
 * @author guoyifeng
 * Java: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), offer(), poll() and peek() operations. 
 * When the queue is empty, poll() and peek() should return null.

	C++: Implement a queue by using two stacks. The queue should provide size(), isEmpty(), push(), 
	front() and pop() operations. When the queue is empty, front() should return -1.
	
	Assumptions
	
	The elements in the queue are all Integers.
	size() should return the number of elements buffered in the queue.
	isEmpty() should return true if there is no element buffered in the queue, false otherwise.
 */

/*
 *    The quene implemented by two stacks is like below:
 *    
 *     1 2 3 ||      ||4 5 6
 *    stack out       stack in
 *    
 *    out is for poll() and peek();
 *    in is for offer()
 *    
 *    when out is empty and need invoke poll() or peek()
 *    use move() to move all the elements in stack in to stack out;
 */
public class QueueByTwoStacks {
	private Stack<Integer> in;
	private Stack<Integer> out;

	public QueueByTwoStacks() {
		// Write your solution here.
		in = new Stack<>();
		out = new Stack<>();
	}

	public Integer poll() {
		move();
		return out.isEmpty() ? null : out.pop();
	}

	public void offer(int element) {
		in.push(element);
	}

	public Integer peek() {
		move();
		return out.isEmpty() ? null : out.peek();
	}

	public int size() {
		return in.size() + out.size();
	}

	public boolean isEmpty() {
		return in.isEmpty() && out.isEmpty();
	}

	// if out stack is empty, move elements from in stack to out stack;
	private void move() {
		if (out.isEmpty()) {
			while (!in.isEmpty()) {
				out.push(in.pop());
			}
		}
	}
}