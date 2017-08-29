package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo
  Given a singly linked list, determine if it is a palindrome.

	Follow up:
	Could you do it in O(n) time and O(1) space?
 */
/*
 * basic idea: fast and slow pointer
 *  1. move fast two nodes and slow one node to find middle node of linked list
 *  2. for even and odd case
 *     if fast != null, meaning this list's nodes # is odd, slow = slow.next to make 
 *     second half smaller.
 *     even case do not need special handling
 *  3. reverse the second half. use h2 to represent the head node of reversed list
 *  4. move fast back to head. compare fast.key and h2.key one by one until h2 is null
 *     because second half is smaller when in odd case. even case they have equal length
 *     
 *     time = O(n)
 *     space = O(1)
 * 
 */
public class IfLinkedListIsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode fast = head;
		ListNode slow = head;
		// find middle node
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		// to determine if linkedlist’s length is odd or even
		if (fast != null) { // odd case
			slow = slow.next; // make second half smaller
		}
		// reverse second half
		ListNode h2 = reverse(slow);
		// move fast back to first half head
		fast = head;
		// compare value one by one from each half
		while (h2 != null) { // for second half is shorter if in odd case
			if (fast.key != h2.key) {
				return false;
			}
			fast = fast.next;
			h2 = h2.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
