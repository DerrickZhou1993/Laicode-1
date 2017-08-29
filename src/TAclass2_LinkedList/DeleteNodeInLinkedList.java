package TAclass2_LinkedList;
/**
 * 
 * @author yifengguo
 * delete nth last node from LinkedList
 */
/*
 *  0  ->    1 -> 2 -> 3 -> 4 -> 5
 *  dummy                          f 
 *                     s
 *   n = 2, initialize f and s = dummy
 *   move f by n position advanced by s
 *   then move f and s until f == null
 *   at that moment s is exactly before the node to delete
 *   so s.next = s.next.next will delete n-th last node 
 *   
 *   time = O(n)
 *   space = O(1)
 */
public class DeleteNodeInLinkedList {
	public ListNode delete(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		for (int i = 1; i <= n; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
