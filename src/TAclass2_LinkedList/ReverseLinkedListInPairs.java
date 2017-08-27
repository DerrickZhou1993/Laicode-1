package TAclass2_LinkedList;
/**
 * 
 * @author @Yifeng
 	set n nodes as a pair to reverse a LinkedList
		1->2->3->4->5->6, n = 3,   ==>    3->2->1->6->5->4
 */
/*
 * time = O(n ^ 2) while loop is nested by a reverse()
 * space = O(1)
 */

/*	Demo: step 1 and step4 is identical case in different position
 * 	step1:original LinkedList
 * 	   dummy
 * 		0 ->   1     ->    2    ->   3    ->       4 -> 5-> 6
 * 	   prev   head
 * 			   cur
 * 
 * 	step2:when cur reaches the nth node: 
 * 		0 ->   1     ->    2    ->   3     ->      4 -> 5-> 6
 * 	   prev    h2                    cur           t2
 * 
 * 	step3:then cut the linkage between 3 and 4 and 0 and 1 
 * 		so LinkedList is separated into two parts with a dummy node
 * 		and then reverse the first and second part respectively
 * 		0  ->   3     ->    2    ->   1           4    ->    5    ->    6
 *     prev    cur                    h2          t2
 *     		 newHead
 *  step4: move references
 *  	3 is newHead of first reversed part, then we linked prev with newHead
 *      0  ->   3     ->    2    ->   1     ->      4    ->    5    ->    6	...
 *      							  h2            t2
 *      							  prev          cur 
 *      then do the same logic operation to second part and then ... nth part                       
 *      0 ->   3->2->1  ->  6->5->4 ...
 *      return dummy.next
 */
public class ReverseLinkedListInPairs {
	public ListNode reverseInPairs(ListNode head, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		int counter = n; // counter to record cur position
		while (cur != null) {
			if (counter == 1) {  // cur reaches a pair's last node
				// record first part head and second part head
				ListNode h2 = prev.next;
				ListNode t2 = cur.next;
				
				// cut linkage
				prev.next = null;
				cur.next = null;
				
				// reverse previous sub-linkedlist
				ListNode newHead = reverse(h2);
				prev.next = cur;
				h2.next = t2;
				
				// move references for repeating operations above
				prev = h2;
				cur = t2;
				counter = n; // do not forget reset counter for 
						     // next iteration moving cur operation
			} else { // if counter != 1, meaning cur has not reached nth node
				cur = cur.next;
				counter--;
			}
		}
		return dummy.next;
	}
	
	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
