package advanced_class6_AdvancedBinarySearch_ComboADT_VotingAlgo;

import java.util.HashMap;
import java.util.Map;

/*
 * step 1: we use a HashMap to efficiently find the element we 
 * 		   we want to access
 * step 2: to implement LRU property, we can use a DLL(doubly linked list) to 
 * 		   simulate 'least recently used', i.e, 
 * 		   1).even though when we just read 
 * 		   an element in DLL, we still need to remove the node from current 
 * 		   position and append it to the head of DLL.
 * 		   2). new set element must be updated to head.
 * 	       	   when set an element in DLL, check if DLL already has 
 * 			   this node and if DLL has enough space.
 * 			   if cache has this node's key, update value directly and update to head
 * 			   if not, we need to add a new node to DLL, so we have to check space limit
 * 					if space is enough, set the new node to the head
 *             		if not enough space, tail element(least recently used one) shall be 
 *             		removed from DLL. new node shall be set to the head
 *          
 */
public class LRUCache<K, V> {
	class Node<K, V> { // ListNode for DLL
		Node<K, V> next;
		Node<K, V> prev;
		K key;
		V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public void update(K key, V value) { // update info of a certain node
			this.key = key;
			this.value = value;
		}
	}

	private Node head; // head node of DLL
	private Node tail; // tail node of DLL
	private Map<K, Node<K, V>> map;
	private final int limit; // size of map(LRU), make it final for fixed size
	// constructor

	public LRUCache(int limit) {
		this.limit = limit;
		this.map = new HashMap<K, Node<K, V>>();
	}

	// setter
	public void set(K key, V value) {
		Node<K, V> node = null;
		if (map.containsKey(key)) {
			node = map.get(key);
			node.value = value;
			remove(node);
		} else { // if cache does not have this node before
			if (map.size() < limit) { // map still has enough space
				node = new Node<K, V>(key, value);
			} else { // map has no space
				node = new Node<K, V>(key, value);
				if (tail != null) {
					remove(tail);
				}
			}
		}
		append(node);
	}

	// append node to the head of DLL (most recently used one)
	private Node<K, V> append(Node<K, V> node) {
		map.put(node.key, node); // initialize mapping
		if (head == null) { // if DLL is empty
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		return node;
	}

	// remove current node from DLL and return it
	private Node<K, V> remove(Node node) {
		// node is in the middle part of DLL
		if (node == null) {
			return null;
		}
		map.remove(node.key);
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node == head) {
			head = node.next;
		}
		if (node == tail) {
			tail = node.prev;
		}
		node.prev = node.next = null;
		return node;
	}

	// getter
	public V get(K key) {
		Node<K, V> node = map.get(key);
		if (node == null) {
			return null;
		}
		remove(node);
		append(node);
		return node.value;
	}
}
