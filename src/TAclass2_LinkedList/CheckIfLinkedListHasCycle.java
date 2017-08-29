package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo
 * Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?
 */
/*
 * basic idea: fast and slow pointer
 * time O(n)
 * space O(1)
 */
public class CheckIfLinkedListHasCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast!= null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}
