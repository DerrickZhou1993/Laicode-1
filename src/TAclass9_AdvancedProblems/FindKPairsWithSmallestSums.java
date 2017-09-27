package TAclass9_AdvancedProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

	Define a pair (u,v) which consists of one element from the first array and one element from the second array.
	
	Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
	
	Example 1:
	Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
	
	Return: [1,2],[1,4],[1,6]
	
	The first 3 pairs are returned from the sequence:
	[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
	Example 2:
	Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
	
	Return: [1,1],[1,1]
	
	The first 2 pairs are returned from the sequence:
	[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
	Example 3:
	Given nums1 = [1,2], nums2 = [3],  k = 3 
	
	Return: [1,3],[2,3]
	
	All possible pairs are returned from the sequence:
	[1,3],[2,3]
 * @author guoyifeng
 *
 */
/*
 * basic idea:
 * 		use Best First Search
 * 		[1,7,11]
 *      [2,4,6]
 *     all pairs can be represented as point with coordinate
 *     (0,0) (0,1) (0,2)
 *     (1,0) (1,1) (1,2)
 *     (2,0) (2,1) (2,2)
 *     
 *     for (0,1), 0 is index in nums1, 1 is index in nums2
 *     pair sum = nums1[x] + nums2[y]
 *     
 *     initialize a PriorityQueue<Point> implements Comparable<Point>
 *     generate (0,0) as initial node
 *     and expand bottom node and right node by Best First Search
 *     use a hashSet to determine if current node has been expanded or not
 *     each time minHeap.poll() will return current pair with min sum
 *     and do this iteration for k times if k <= nums1.length * nums2.length
 * 		
 */
public class FindKPairsWithSmallestSums {
	class Point implements Comparable<Point> {
		private int x; // x coordinate
		private int y; // y coordinate
		private int sum; // x + y (pair sum)
		// constructor
		public Point(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (!(o instanceof Point)) {
				return false;
			}
			Point p = (Point) o;
			return p.x == x && p.y == y && p.sum == sum;
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = result + 31 * this.x;
			result = result + 31 * this.y;
			result = result + 31 * this.sum;
			return result;
		}

		@Override
		public int compareTo(Point p) {
			if (this.sum == p.sum) {
				return 0;
			}
			return this.sum < p.sum ? -1 : 1;
		}
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
			return res;
		}
		List<Point> points = new ArrayList<>(); // solution in points format
		PriorityQueue<Point> minHeap = new PriorityQueue<>();
		Set<Point> visited = new HashSet<>(); // record current point has been
											  // visited or not;
											  // generate point(0,0);
		minHeap.offer(new Point(0, 0, nums1[0] + nums2[0]));
		// loop limit times where limit is k if k <= nums1.length * nums2.length
		int limit = Math.min(k, nums1.length * nums2.length);
		for (int i = 0; i < limit; i++) {
			Point min = minHeap.poll();
			points.add(min);
			// expand bottom node and right node
			if (min.x + 1 < nums1.length) { // expand bottom node
				Point p1 = new Point(min.x + 1, min.y, nums1[min.x + 1] + nums2[min.y]);
				if (visited.add(p1)) { // not visited before
					minHeap.offer(p1);
				}
			}

			if (min.y + 1 < nums2.length) {
				Point p2 = new Point(min.x, min.y + 1, nums1[min.x] + nums2[min.y + 1]);
				if (visited.add(p2)) { // not visited before
					minHeap.offer(p2);
				}
			}
		}
		for (int i = 0; i < points.size(); i++) {
			int[] p = new int[2];
			p[0] = nums1[points.get(i).x];
			p[1] = nums2[points.get(i).y];
			res.add(p);
		}
		return res;
	}
}


