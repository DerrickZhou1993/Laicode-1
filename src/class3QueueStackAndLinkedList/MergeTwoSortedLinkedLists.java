package class3QueueStackAndLinkedList;

/**
 * 
 * @author guoyifeng
 *Merge two sorted lists into one large sorted list.

	Examples
	
	L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
	L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
	L1 = null, L2 = null, merge L1 and L2 to null

 */

/*
 * basic idea: we don't know which node will be the head of merged linkedlist,
 * so we have to use a dummy head for return,
 * in addtion, we still have to use another node reference(cur) to maintain the current tail of merged linkedlist
 * to judge the next-merge-node belongs to which linkedlist
 * and do not check if one of the linkedlist meets null already
 */
public class MergeTwoSortedLinkedLists {
	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while(one != null || two != null) {
			if(one != null && two != null) {  // if both linkedlists still have nodes
				if(one.value > two.value) {
					cur.next = two;
					two = two.next;
				} else {
					cur.next = one;
					one = one.next;
				}
				cur = cur.next; // move cur to the current tail of merged linkedlist;
			} else if(one == null) { // if one linkedlist is empty, move rest nodes in two to merged linkedlist
				cur.next = two;
				two = two.next;
				cur = cur.next;
			} else {                // if two linkedlist is empty, move rest nodes in one to merged linkedlist
				cur.next = one;
				one = one.next;
				cur = cur.next;
			}
		}
		return dummy.next;   //return real head of merged linkedlist;
	}
}
