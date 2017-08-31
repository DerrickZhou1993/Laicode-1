package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
/*
 * classic merge two sorted linked lists
 * use dummy and cur
 * move cur and l1 or l2 which has greater value
 * do not forget one of list is empty, directly link the other one with cur
 * 
 * time = O(n)
 * space = O(1)
 */
public class MergeTwoSortedLinkedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (l1 != null && l2 != null) {
			if (l1.key > l2.key) {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
			} else {
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
			}
		}
		if (l1 == null) {
			cur.next = l2;
		} else {
			cur.next = l1;
		}
		return dummy.next;
	}
}
