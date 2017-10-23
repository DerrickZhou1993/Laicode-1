package advanced_class7_DP4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
/**
 * 
 * @author @Yifeng
 * Given an array of 2D coordinates of points (all the coordinates are integers), 
 * find the largest number of points that can be crossed by a single line in 2D space.

	Assumptions
	
	The given array is not null and it has at least 2 points
	Examples
	
	<0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
 */
class Point {	
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}


public class MostPointsOnALine {
	  // basic idea
	  // 1. use HashMap to record number of points which has same k
	  // 2. special case: k does not exist (x1 == x2) 
      // two points with same x and y are considered as different ones
	  public int most(Point[] points) {
	  	if (points == null || points.length == 0) {
	  		return 0;
	  	}
	  	int res = 0;
	  	for (int i = 0; i < points.length; i++) {
	  		// choose current point as seed and try to find all
	  		// possible points with same k
	  		Point seed = points[i];
	  		int most = 0;
	  		int same = 0; // record number of points with same x and y
	  		int sameX = 0; // record number of points which has same x (meaning the k does not exist)
	  		// key: k, value: number of points with same k
	  		Map<Double, Integer> map = new HashMap<>();
	  		for (int j = 0; j < points.length; j++) {
	  			if (i == j) {
	  				continue;
	  			}
	  			if (seed.x == points[j].x && seed.y == points[j].y) {
	  				same++;
	  			} else if (seed.x == points[j].x) { // two points construct a line without slope
	  				sameX++;
	  			} else { // two points which do not have same x or same y
	  				double k = (points[j].y - seed.y) * 1.0 / (points[j].x - seed.x); 
	  				if (!map.containsKey(k)) {
	  					map.put(k, 2); // initially a line contains two points
	  				} else {
	  					map.put(k, map.get(k) + 1); 
	  				}
	  				most = Math.max(most, map.get(k)); // update most points in the current line with slope == k
	  			}
	  		} // end of inner for loop
	  		most = Math.max(most, sameX) + same; // compare points of line with k and line without k and then add duplicate points based on current seed point
	  		res = Math.max(res, most); // update res
	  	} // end of outer for loop
	  	return res;
	  }
	
	/*
	 * my own solution using two hashmap, one is to store line of points which has slope
	 * another one is to store number of points which does not have slope(x coordinates are the same)
	 * but cannot cover all the test cases
	 */
//	public int most(Point[] points) {
//		// y = k * x + b;
//		// basic idea: we can use slope-intercept to
//		// represent a line. And we need to make sure
//		// if k really exists?
//
//		class Pair {
//			public double k;
//			public double b;
//
//			public Pair(double k, double b) {
//				this.k = k;
//				this.b = b;
//			}
//			public String toString() {
//				return "(" + k + "," + b + ")";
//			}
//			
//			@Override
//			public boolean equals(Object o) {
//				if (o == this) {
//					return true;
//				}
//				if (!(o instanceof Pair)) {
//					return false;
//				}
//				Pair p = (Pair) o;
//				return p.k == this.k && p.b == this.b;
//			}
//			
//			@Override
//			public int hashCode() {
//				return Objects.hash(k, b);
//			}
//		}
//		int result = 0;
//		Map<Pair, Set<Point>> map = new HashMap<>();
//		Map<Integer, Set<Point>> infinity = new HashMap<>();
//
//		for (int i = 0; i < points.length; i++) {
//			for (int j = 0; j < points.length; j++) {
//				if (i == j) {
//					continue;
//				}
//				if (points[i].x != points[j].x) {
//					double k = (points[j].y - points[i].y) / (points[j].x - points[i].x);
//					double b = points[j].y - ((points[j].y - points[i].y) / (points[j].x - points[i].x)) * points[j].x;
//					Pair p = new Pair(k, b);
//					if (!map.containsKey(p)) {
//						Set<Point> set = new HashSet<>();
//						set.add(points[i]);
//						set.add(points[j]);
//						map.put(p, set);
//					} else {
//						map.get(p).add(points[i]);
//						map.get(p).add(points[j]);
//					}
//				} else { // x1 == x2, k does not exist
//					int key = points[j].x;
//					if (!infinity.containsKey(key)) {
//						Set<Point> set = new HashSet<>();
//						set.add(points[i]);
//						set.add(points[j]);
//						infinity.put(key, set);
//					} else {
//						infinity.get(key).add(points[i]);
//						infinity.get(key).add(points[j]);
//					}
//				}
//			}
//		}
//		Map.Entry<Pair, Set<Point>> maxEntry1 = null; // map's entry with max value
//		for (Map.Entry<Pair, Set<Point>> entry : map.entrySet()) {
//		    if (maxEntry1 == null || entry.getValue().size() - (maxEntry1.getValue().size()) > 0) {
//		        maxEntry1 = entry;
//		    }
//		}
//		
//		Map.Entry<Integer, Set<Point>> maxEntry2 = null;
//		for (Map.Entry<Integer, Set<Point>> entry : infinity.entrySet()) {
//			if (maxEntry2 == null || entry.getValue().size() - (maxEntry2.getValue().size()) > 0) {
//				maxEntry2 = entry;
//			}
//		}
//		System.out.println(Arrays.asList(map));
//		return Math.max(maxEntry1.getValue().size(), maxEntry2.getValue().size());
//	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,1);
		Point p3 = new Point(1,1);
		Point p4 = new Point(1,1);
		Point p5 = new Point(1,1);
		Point p6 = new Point(1,1);
		
		Point[] points = {p1,p2,p3,p4,p5,p6};
		
		
		System.out.print(new MostPointsOnALine().most(points));

	}
}

