package TAclass9_AdvancedProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author guoyifeng
 	Given a non-empty array of integers, return the k most frequent elements.

	For example,
	Given [1,1,1,2,2,3] and k = 2, return [1,2].
	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
//time = O(n * logk) for we have n numbers in array and max heap size is k if k <= array.length
public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0 || k <= 0) {
			return res;
		}
		// key: num, value : occurrence count
		Map<Integer, Integer> map = new HashMap<>();
		// O(n) time to map num with its occurrence count in the array
		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
		}
		// max heap to maintain top k frequent elements
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				new Comparator<Map.Entry<Integer, Integer>>() {
					@Override
					public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
						if (a.getValue() == b.getValue()) {
							return 0;
						}
						return a.getValue() > b.getValue() ? -1 : 1;
					}
				});
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.offer(entry);
		}
		// need to check k and nums.length relationship
		int limit = Math.min(nums.length, k);
		for (int i = 0; i < limit; i++) {
			res.add(maxHeap.poll().getKey());
		}
		return res;
	}
}

