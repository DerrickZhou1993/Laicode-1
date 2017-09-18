package TAclass8_DP;

import java.util.Arrays;

/**
 * 
 * @author guoyifeng
	  there are n points on a plane graph which has x coordinate and y coordinate (x, y)
	  try to find a path which starts from bottom-left and heads to top-right and contains 
	  largest number of points
 * 
 */

/*
 * Follow up of LIS
 * 
 * For this problem, we could simply sort points by x-coordinate
 * and run LIS on y-coordinates
 * 
 * And the path which has largest number of points will have max length
 * of LIS
 * 
 * time = O(n ^ 2)
 * space = O(n)
 */
public class PathContainsMostPoints {
	static class Point implements Comparable<Point> {
		private int x;
		private int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point other) {
			if (this.x == other.x) {
				return 0;
			}
			return this.x < other.x ? -1 : 1;
		}
	}


	public int longestPath(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		int globalMax = 1;
		Arrays.sort(points); // sort points by x coordinate
		int[] array = new int[points.length];
		for (int i = 0; i < points.length; i++) {
			array[i] = points[i].y;
		}
		int[] dp = new int[array.length];
		Arrays.fill(dp, 1);
		dp[0] = 1;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			globalMax = Math.max(globalMax, dp[i]);
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(2,2);
		Point p3 = new Point(3,4);
		Point p4 = new Point(3,-4);
		Point p5 = new Point(1,12);
		Point p6 = new Point(9,-4);
		Point p7 = new Point(4,12);
		Point[] points = new Point[] {p1, p2, p3, p4, p5, p6, p7};
		int res = new PathContainsMostPoints().longestPath(points);
		System.out.println(res);
	}
}

