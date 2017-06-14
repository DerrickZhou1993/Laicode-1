package class8HashtableAndString1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author @Yifeng
 * Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

	Assumptions
	
	the composition is not null and is not guaranteed to be sorted
	K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
	Return
	
	a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
	Examples
	
	Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [¡°b¡±, ¡°c¡±]
	Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [¡°b¡±, ¡°c¡±, "a", "d"]
	Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [¡°b¡±, ¡°c¡±, "a", "d"]
 */
public class TopKFrequentWords {
	public String[] topKFrequent(String[] combo, int k) {
		if (combo.length == 0) {
			return new String[0];
		}
		HashMap<String, Integer> map = new HashMap<>();
		// get frequency of element in the array
		for (String word : combo) {
			Integer freq = map.get(word);
			if (freq == null) {
				map.put(word, 1);
			} else {
				map.put(word, freq + 1);
			}
		}
		//must override the comparator for MinHeap or the Map.Entry<> cannot be compared directly 
		Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
				new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						if (e1.getValue() == e2.getValue())
							return 0;
						return e1.getValue() < e2.getValue() ? -1 : 1;
					}
				});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else {
				if (minHeap.peek().getValue() < entry.getValue()) {
					minHeap.poll();
					minHeap.offer(entry);
				}
			}
		}

		String[] result = new String[minHeap.size()];//do not use k because k may be bigger than the unique element number
		for (int i = minHeap.size() - 1; i >= 0; i--) { //This is a minHeap but the result should be in high freq to low freq, so add 
														// elements from tail to head in to array
			result[i] = minHeap.poll().getKey();
		}
		return result;

	}

}

