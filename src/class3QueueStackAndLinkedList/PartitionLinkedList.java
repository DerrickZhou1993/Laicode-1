package class3QueueStackAndLinkedList;

/**
 * 
 * @author @Yifeng
 * Given a linked list and a target value T, partition it such that all nodes less than T 
 * are listed before the nodes larger than or equal to target value T. 
 * The original relative order of the nodes in each of the two partitions should be preserved.

	Examples
	
				  L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, 
	is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 */


/*
 *  example:   L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3
 *  	step1: initialize two LinkedLists heads;
 *  	
 *  	step2: 
 *  		Iterate each element in the list and compare the current node's value to the target's value
 *  			case1:
 *  				if current node's value < target's value, add the current node to the tail of first LinkedList;
 *  			case2:
 *  				else, add the current node to the tail of second LinkedList;
 *  		The result should like below:
 *  			LinkedList1: to store nodes less than target     			  2 -> 1
 *  			LinkedList2: to store nodes greater than or equal to target   4 -> 3 -> 5
 *  
 *  	step3: Concatenate the tail of first half to the head of second half
 *  			2 -> 1 -> 4 -> 3 -> 5;
 *  	step4: Do not forget to add null to the tail of second half;
 *  			2 -> 1 -> 4 -> 3 -> 5 -> null;
 */

/**
 * 
 * @author @Yifeng
 *  My first accepted version
 */
public class PartitionLinkedList {
	public ListNode partition(ListNode head, int target) {
		if (head == null) {
			return head;
		}
		// step1:
		ListNode smallHead = new ListNode(0);
		ListNode smallTail = smallHead;
		ListNode largeHead = new ListNode(0);
		ListNode largeTail = largeHead;
		
		// step2:
		while (head != null) { //must head != null or the last element may be ruled out if use head.next != null 
			if (head.value < target) {
				smallTail.next = head;
				smallTail = smallTail.next;
				head = head.next;
			} else {
				largeTail.next = head;
				largeTail = largeTail.next;
				head = head.next;
			}
		}
		smallHead = smallHead.next; // put fakeHead to current half's real head
		largeHead = largeHead.next;

		smallTail.next = largeHead; // step 3: concatenation

		largeTail.next = null;     // step 4 set null at tail

		return (smallHead == null ? largeHead : smallHead); // if input is like {2} target is 1, so smallHead is null always
	}
}
