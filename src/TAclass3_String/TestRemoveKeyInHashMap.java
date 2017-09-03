package TAclass3_String;

import java.util.HashMap;
import java.util.Map;

public class TestRemoveKeyInHashMap {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.remove(1);
		System.out.println(map.containsKey(1)); // when remove(key), key actually has been deleted
	}
}
