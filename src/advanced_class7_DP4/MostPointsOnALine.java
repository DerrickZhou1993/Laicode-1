package advanced_class7_DP4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

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
	public int most(Point[] points) {
		// y = k * x + b;
		// basic idea: we can use slope-intercept to
		// represent a line. And we need to make sure
		// if k really exists?

		class Pair {
			public double k;
			public double b;

			public Pair(double k, double b) {
				this.k = k;
				this.b = b;
			}
			public String toString() {
				return "(" + k + "," + b + ")";
			}
			
			@Override
			public boolean equals(Object o) {
				if (o == this) {
					return true;
				}
				if (!(o instanceof Pair)) {
					return false;
				}
				Pair p = (Pair) o;
				return p.k == this.k && p.b == this.b;
			}
			
			@Override
			public int hashCode() {
				return Objects.hash(k, b);
			}
		}
		int result = 0;
		Map<Pair, Set<Point>> map = new HashMap<>();
		Map<Integer, Set<Point>> infinity = new HashMap<>();

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				if (points[i].x != points[j].x) {
					double k = (points[j].y - points[i].y) / (points[j].x - points[i].x);
					double b = points[j].y - ((points[j].y - points[i].y) / (points[j].x - points[i].x)) * points[j].x;
					Pair p = new Pair(k, b);
					if (!map.containsKey(p)) {
						Set<Point> set = new HashSet<>();
						set.add(points[i]);
						set.add(points[j]);
						map.put(p, set);
					} else {
						map.get(p).add(points[i]);
						map.get(p).add(points[j]);
					}
				} else { // x1 == x2, k does not exist
					int key = points[j].x;
					if (!infinity.containsKey(key)) {
						Set<Point> set = new HashSet<>();
						set.add(points[i]);
						set.add(points[j]);
						infinity.put(key, set);
					} else {
						infinity.get(key).add(points[i]);
						infinity.get(key).add(points[j]);
					}
				}
			}
		}
		Map.Entry<Pair, Set<Point>> maxEntry1 = null; // map's entry with max value
		for (Map.Entry<Pair, Set<Point>> entry : map.entrySet()) {
		    if (maxEntry1 == null || entry.getValue().size() - (maxEntry1.getValue().size()) > 0) {
		        maxEntry1 = entry;
		    }
		}
		
		Map.Entry<Integer, Set<Point>> maxEntry2 = null;
		for (Map.Entry<Integer, Set<Point>> entry : infinity.entrySet()) {
			if (maxEntry2 == null || entry.getValue().size() - (maxEntry2.getValue().size()) > 0) {
				maxEntry2 = entry;
			}
		}
		System.out.println(Arrays.asList(map));
		return Math.max(maxEntry1.getValue().size(), maxEntry2.getValue().size());
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,3);
		Point p3 = new Point(2,2);
		Point p4 = new Point(3,3);
		Point p5 = new Point(4,1);
		Point p6 = new Point(4,4);
		
		Point[] points = {p1,p2,p3,p4,p5,p6};
		
		
		System.out.print(new MostPointsOnALine().most(points));

	}
}

