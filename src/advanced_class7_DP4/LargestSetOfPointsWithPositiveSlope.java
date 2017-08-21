package advanced_class7_DP4;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 
 * @author @Yifeng
 * Given an array of 2D coordinates of points (all the coordinates are integers), 
 * find the largest number of points that can form a set such that any pair of points 
 * in the set can form a line with positive slope. Return the size of such a maximal set.

	Assumptions
	
	The given array is not null
	Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
	Examples
	
	<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
 */
public class LargestSetOfPointsWithPositiveSlope {
	public int largest(Point[] points) {
		if (points == null || points.length <= 1) {
			return 0;
		}
		// sort the array by points¡¯ x coordinate
		// then the problem is converted to longest
		// subsequence ascending problem
		Arrays.sort(points, new MyComparator());
		int result = 0;
		// M[] represents the length of longest subsequence
		// from 0th element to i-th element (including i-th)
		int[] M = new int[points.length];
		M[0] = 1; // Base case
		for (int i = 1; i < points.length; i++) {
			boolean existed = false;
			for (int j = 0; j < i; j++) {
				if (points[i].y > points[j].y) {
					existed = true;
					M[i] = Math.max(M[j] + 1, M[i]);
				}
				if (!existed) { // single point cannot be counted as a line
								// it has to find a point'y before smaller than
								// its y
					M[i] = 0;
				}
			}
			result = Math.max(M[i], result);
		}
		return result;
	}

	static class MyComparator implements Comparator<Point> {
		@Override
		public int compare(Point p1, Point p2) {
			if (p1.x == p2.x) {
				return 0;
			}
			return p1.x < p2.x ? -1 : 1;
		}
	}
}
