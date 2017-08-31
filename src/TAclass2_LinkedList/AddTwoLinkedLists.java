package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
/*
 * basic idea:
 * 	1. if given two linked lists are not reversed, we need to reverse both of them
 *     for we have to add number starting from least significant digits
 *  2. initialize carry = 0 at the very beginning, and do addition operation for
 *     each digit, the current node's value is sum(p.val + q.val + carry) % 10
 *     and carry = sum / 10
 *  3. advance cur, p, q
 *     pay attention to p and q =, need check if they are null or not when get value
 *     and move the reference, if null -> val = 0
 *     
 *  time = O(Math.max(m,n)) which m and n represent the length of two linked lists
 *  space = O(1)
 */
public class AddTwoLinkedLists {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		// ListNode r1 = reverse(l1);
		// ListNode r2 = reverse(l2);
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		ListNode p = l1;
		ListNode q = l2;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.key : 0;
			int y = (q != null) ? q.key : 0;
			int sum = x + y + carry;
			cur.next = new ListNode(sum % 10);
			carry = sum / 10;
			cur = cur.next;
			p = (p != null) ? p.next : null;
			q = (q != null) ? q.next : null;
		}
		if (carry != 0) {
			cur.next = new ListNode(carry);
		}
		return dummy.next;
	}
	
//	private ListNode reverse(ListNode head) {
//		if (head == null || head.next == null) {
//			return head;
//		}
//		ListNode prev = null;
//		ListNode cur = head;
//		while (cur != null) {
//			ListNode next = cur.next;
//			cur.next = prev;
//			prev = cur;
//			cur = next;
//		}
//		return prev;
//	}

}
