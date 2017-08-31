package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo
 	Write a program to find the node at which the intersection of two singly linked lists begins.


	For example, the following two linked lists:
	
	A:          a1 → a2
	                   ↘
	                     c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3
	begin to intersect at node c1.


	Notes:
	
	If the two linked lists have no intersection at all, return null.
	The linked lists must retain their original structure after the function returns.
	You may assume there are no cycles anywhere in the entire linked structure.
	Your code should preferably run in O(n) time and use only O(1) memory.
 */
/*
 * basic idea:
 * 	step1: calculate length of two linked lists respectively
 *  step2: calculate the difference of two lengths
 *  step3: move the head pointer of longer list by diff steps in order to
 *         make two head pointers have identical distance to first intersection node
 *         if existed
 *  step4: move two lists' head pointer by one step each time until find the node with
 *         same value
 *         if not found, return null
 *         
 *  time = O(n + m) where m and n are the length of linked lists
 *  space = O(1)
 *  
 *  follow up:
 *  	what if we need to find the first intersection node of K linked lists?
 *      	basic idea: almost the same logic as two linked lists
 *          step1: calculate the length of k linked lists respectively and find the shortest one
 *          step2: calculate diff between shortest and other k - 1 lists and move other k - 1 lists
 *                 by corrsponding diff steps in order to make all the lists' head pointers have the
 *                 same distance to first intersection node
 *          step3: move head pointer of each list until find the node which has identical value
 *                 if not found, return null
 *           
 *          time = O(kn) n is the average length of all lists
 *          space = O(k)
 */
public class FindFirstIntersectionNodeOfTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		int length1 = 0;
		int length2 = 0;
		ListNode cur1 = headA;
		ListNode cur2 = headB;

		// calculate the length of both linked list
		while (cur1 != null) {
			cur1 = cur1.next;
			length1++;
		}
		while (cur2 != null) {
			cur2 = cur2.next;
			length2++;
		}

		// calculate the diff of two lengths
		int diff = Math.abs(length1 - length2);
		
		// move longer list by diff steps
		ListNode cur3 = headA;
		ListNode cur4 = headB;
		if (length1 >= length2) {
			for (int i = 0; i < diff; i++) {
				cur3 = cur3.next; 
			}
		} else {
			for (int i = 0; i < diff; i++) {
				cur4 = cur4.next;
			}
		}
		// now two lists’ head has same distance to first
        // intersection node
		while (cur3 != null && cur4 != null) {
			if (cur3.key == cur4.key) {
				return cur3;
			}
			cur3 = cur3.next;
			cur4 = cur4.next;
		}
		return null;
	}
}
